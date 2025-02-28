package com.crystal.mystia_izakaya.client.block;

import com.crystal.mystia_izakaya.client.blockEntity.CuttingBoardTE;
import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
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

public class CuttingBoardBlock extends AbstractHorizontalBlock {
    public static final MapCodec<CuttingBoardBlock> CODEC = simpleCodec((properties) -> new CuttingBoardBlock());
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 3.0D, 16.0D, 1.0D, 13.0D);
    protected static final VoxelShape SHAPE1 = Block.box(3.0D, 0.0D, 0.0D, 13.0D, 1.0D, 16.0D);

    @Override
    protected @NotNull InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        super.useWithoutItem(pState, pLevel, pPos, pPlayer, pHitResult);
        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            ServerPlayer serverPlayer = (ServerPlayer) pPlayer;
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof CuttingBoardTE cuttingBoardTE) {
                serverPlayer.openMenu(cuttingBoardTE, friendlyByteBuf -> friendlyByteBuf.writeBlockPos(pPos));
            }
            return InteractionResult.CONSUME;
        }
    }

    @javax.annotation.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createCookTicker(pLevel, pBlockEntityType, BlockEntityRegistry.CUTTING_BOARD.get());
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
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new CuttingBoardTE(pPos, pState);
    }
}
