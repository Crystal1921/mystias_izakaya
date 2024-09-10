package com.crystal.mystia_izakaya.client.block;

import com.crystal.mystia_izakaya.client.blockEntity.BoilingPotTE;
import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BoilingPotBlock extends AbstractHorizontalBlock {
    public static final MapCodec<BoilingPotBlock> CODEC = simpleCodec((properties) -> new BoilingPotBlock());
    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 1.0D, 12.0D);
    protected static final VoxelShape SHAPE1 = Block.box(2.0D, 1.0D, 2.0D, 14.0D, 7.0D, 14.0D);
    protected static final VoxelShape SHAPE2 = Block.box(7.0D, 7.0D, 7.0D, 9.0D, 8.0D, 9.0D);

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            ServerPlayer serverPlayer = (ServerPlayer) pPlayer;
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof BoilingPotTE boilingPotTE) {
                serverPlayer.openMenu(boilingPotTE, friendlyByteBuf -> friendlyByteBuf.writeBlockPos(pPos));
            }
            return InteractionResult.CONSUME;
        }
    }

    @javax.annotation.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createCookTicker(pLevel, pBlockEntityType, BlockEntityRegistry.BOILING_POT.get());
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }


    @SuppressWarnings("all")
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.or(SHAPE, SHAPE1, SHAPE2);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new BoilingPotTE(pPos, pState);
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

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(LIT)) {
            double d0 = (double) pos.getX() + random.nextDouble();
            double d1 = pos.getY() + 0.15;
            double d2 = (double) pos.getZ() + random.nextDouble();
            if (random.nextDouble() < 0.1) {
                level.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
            level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0, 0.0, 0.0);
            level.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0, 0.0, 0.0);
        }
    }
}
