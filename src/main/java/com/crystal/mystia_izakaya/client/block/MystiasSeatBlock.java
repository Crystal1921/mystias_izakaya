package com.crystal.mystia_izakaya.client.block;

import com.crystal.mystia_izakaya.client.blockEntity.MystiaSeatTE;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.utils.ServerUtilMethod;
import com.github.tartaricacid.touhoulittlemaid.entity.item.EntitySit;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MystiasSeatBlock extends BaseEntityBlock {
    public static final MapCodec<MystiasSeatBlock> CODEC = simpleCodec((properties) -> new MystiasSeatBlock());
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final String MystiasSeat = "mystias_seat";

    public MystiasSeatBlock() {
        super(BlockBehaviour.Properties.of().strength(2.5F).noOcclusion());
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (level instanceof ServerLevel serverLevel && blockEntity instanceof MystiaSeatTE mystiaSeatTE) {
            if (itemStack.getItem() instanceof CookedMealItem) {
                mystiaSeatTE.setItem(0, itemStack.getItem().getDefaultInstance());
                ItemStack itemStack1 = itemStack.copy();
                if (!player.isCreative()) {
                    itemStack1.shrink(1);
                }
                player.setItemInHand(hand, itemStack1);
                serverLevel.sendBlockUpdated(pos, blockEntity.getBlockState(), blockEntity.getBlockState(), Block.UPDATE_CLIENTS);
                return ItemInteractionResult.SUCCESS;
            }
            if (itemStack.isEmpty() && !mystiaSeatTE.getItem(0).isEmpty()) {
                ItemStack itemStack2 = mystiaSeatTE.getItem(0);
                mystiaSeatTE.clearContent();
                ItemEntity itemEntity = new ItemEntity(serverLevel, pos.getX(), pos.getY(), pos.getZ(), itemStack2);
                serverLevel.addFreshEntity(itemEntity);
                serverLevel.sendBlockUpdated(pos, blockEntity.getBlockState(), blockEntity.getBlockState(), Block.UPDATE_CLIENTS);
            }
        }
        return super.useItemOn(itemStack, state, level, pos, player, hand, hit);
    }

    @SuppressWarnings("deprecation")
    public @NotNull RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return makeShape();
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState()
                .setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    protected MapCodec<? extends MystiasSeatBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MystiaSeatTE(pos, state);
    }

    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (!pState.is(pNewState.getBlock())) {
            BlockEntity blockentity = pLevel.getBlockEntity(pPos);
            if (blockentity instanceof MystiaSeatTE mystiaSeatTE) {
                if (pLevel instanceof ServerLevel serverLevel) {
                    ServerUtilMethod.dropContents(serverLevel, pPos, mystiaSeatTE, mystiaSeatTE.getContainerSize());
                    Entity entity = serverLevel.getEntity(mystiaSeatTE.getSitId());
                    if (entity instanceof EntitySit) {
                        entity.discard();
                    }
                }
                super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            } else {
                super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
            }
        }
    }

    public VoxelShape makeShape(){
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.375, 0, 0.375, 0.625, 0.0625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.0625, 0.4375, 0.5625, 0.5625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.5625, 0.1875, 0.8125, 0.625, 0.8125), BooleanOp.OR);

        return shape;
    }
}
