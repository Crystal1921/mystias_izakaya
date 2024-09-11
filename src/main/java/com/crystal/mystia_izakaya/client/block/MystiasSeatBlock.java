package com.crystal.mystia_izakaya.client.block;

import com.crystal.mystia_izakaya.client.blockEntity.MystiaSeatTE;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.utils.UtilMethod;
import com.github.tartaricacid.touhoulittlemaid.entity.item.EntitySit;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
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
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MystiasSeatBlock extends BaseEntityBlock {
    public static final MapCodec<MystiasSeatBlock> CODEC = simpleCodec((properties) -> new MystiasSeatBlock());
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE = Shapes.box(0.4375, 0, 0.4375, 0.5625, 0.625, 0.5625);
    protected static final VoxelShape SHAPE1 = Shapes.box(0.125, 0.625, 0.125, 0.875, 0.75, 0.875);
    private static final String MystiasSeatBlock = "mystias_seat";

    public MystiasSeatBlock() {
        super(BlockBehaviour.Properties.of().strength(2.5F).noOcclusion());
    }

    @javax.annotation.Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createCookTicker(
            Level pLevel, BlockEntityType<T> pServerType, BlockEntityType<? extends MystiaSeatTE> pClientType
    ) {
        return pLevel.isClientSide ? null : createTickerHelper(pServerType, pClientType, MystiaSeatTE::serverTick);
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

    public void startMaidSit(EntityMaid maid, BlockState state, Level worldIn, BlockPos pos) {
        if (worldIn instanceof ServerLevel serverLevel) {
            BlockEntity blockEntity = serverLevel.getBlockEntity(pos);
            if (blockEntity instanceof MystiaSeatTE seatTE) {
                Direction face = state.getValue(FACING).getClockWise();
                Vec3 position = new Vec3(0.5 + (double) face.getStepX() * 1.5, 0.1, 0.5 + (double) face.getStepZ() * 1.5);
                EntitySit newSitEntity = new EntitySit(worldIn, Vec3.atLowerCornerWithOffset(pos, position.x, position.y, position.z), MystiasSeatBlock, pos);
                newSitEntity.setYRot(face.getOpposite().toYRot());
                worldIn.addFreshEntity(newSitEntity);
                seatTE.setSitId(newSitEntity.getUUID());
                seatTE.setChanged();
                maid.startRiding(newSitEntity);
            }
        }
    }

    public @NotNull RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.or(SHAPE, SHAPE1);
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
                if (pLevel instanceof ServerLevel) {
                    UtilMethod.dropContents(pLevel, pPos, mystiaSeatTE, mystiaSeatTE.getContainerSize());
                }
                super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            } else {
                super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
            }
        }
    }
}
