package com.crystal.mystia_izakaya.client.block;

import com.crystal.mystia_izakaya.client.blockEntity.GrillTE;
import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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

public class GrillBlock extends AbstractHorizontalBlock {
    public static final MapCodec<GrillBlock> CODEC = simpleCodec((properties) -> new GrillBlock());
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 3.0D, 16.0D, 5.0D, 13.0D);
    protected static final VoxelShape SHAPE1 = Block.box(3.0D, 0.0D, 0.0D, 13.0D, 5.0D, 16.0D);

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            ServerPlayer serverPlayer = (ServerPlayer) pPlayer;
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof GrillTE grillTE) {
                serverPlayer.openMenu(grillTE, friendlyByteBuf -> friendlyByteBuf.writeBlockPos(pPos));
            }
            return InteractionResult.CONSUME;
        }
    }

    @javax.annotation.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createCookTicker(pLevel, pBlockEntityType, BlockEntityRegistry.GRILL.get());
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }


    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction direction = pState.getValue(FACING);
        return switch (direction) {
            case EAST, WEST -> SHAPE;
            case NORTH, SOUTH -> SHAPE1;
            default -> Shapes.empty();
        };
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

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
        return new GrillTE(pPos, pState);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(LIT)) {
            double d0 = (double) pos.getX() + 0.25 + random.nextDouble() * 0.5;
            double d1 = pos.getY() + 0.35;
            double d2 = (double) pos.getZ() + 0.25 + random.nextDouble() * 0.5;
            if (random.nextDouble() < 0.1) {
                level.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }
            level.addParticle(ParticleTypes.SMOKE, d0, d1, d2, 0.0, 0.0, 0.0);
            level.addParticle(ParticleTypes.FLAME, d0, d1, d2, 0.0, 0.0, 0.0);
        }
    }
}
