package com.crystal.mystia_izakaya.client.block;

import com.crystal.mystia_izakaya.client.blockEntity.MystiaSeatTE;
import com.github.tartaricacid.touhoulittlemaid.entity.item.EntitySit;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
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
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MystiasSeatBlock extends BaseEntityBlock {
    public static final MapCodec<MystiasSeatBlock> CODEC = simpleCodec((properties) -> new MystiasSeatBlock());
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final String MystiasSeatBlock = "mystias_seat";

    public MystiasSeatBlock() {
        super(BlockBehaviour.Properties.of().strength(2.5F).noOcclusion());
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof MystiaSeatTE mystiaSeatTE) {
            mystiaSeatTE.setItem(0, itemStack);
            return ItemInteractionResult.SUCCESS;
        } else return super.useItemOn(itemStack, state, level, pos, player, hand, hit);
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
}
