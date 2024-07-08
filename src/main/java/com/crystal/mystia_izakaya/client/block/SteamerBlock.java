package com.crystal.mystia_izakaya.client.block;

import com.crystal.mystia_izakaya.client.blockEntity.BoilingPotTE;
import com.crystal.mystia_izakaya.client.blockEntity.SteamerTE;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SteamerBlock extends AbstractHorizontalBlock {
    public static final MapCodec<SteamerBlock> CODEC = simpleCodec((properties) -> new SteamerBlock());
    protected static final VoxelShape SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 4.0D, 13.0D);
    protected static final VoxelShape SHAPE1 = Block.box(1.0D, 4.0D, 1.0D, 15.0D, 5.0D, 15.0D);

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            ServerPlayer serverPlayer = (ServerPlayer) pPlayer;
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof SteamerTE steamerTE) {
                serverPlayer.openMenu(steamerTE);
            }
            return InteractionResult.CONSUME;
        }
    }

    @SuppressWarnings("all")
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.join(SHAPE1, SHAPE, BooleanOp.OR);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SteamerTE(pPos, pState);
    }

    @Override
    @SuppressWarnings("all")
    protected void spawnDestroyParticles(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState) {
        if (pLevel instanceof ServerLevel serverLevel && pPlayer != null) {
            serverLevel.sendParticles(
                    ParticleTypes.FLAME,
                    pPos.getX() + 0.5, pPos.getY(), pPos.getZ() + 0.5,
                    25,
                    pPlayer.getRandom().nextGaussian() * 0.2D,
                    (pPlayer.getRandom().nextGaussian() * 0.25D) + 0.1,
                    pPlayer.getRandom().nextGaussian() * 0.2D,
                    0.05f);
        }
    }
}
