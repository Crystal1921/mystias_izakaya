package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class CuttingBoardTE extends AbstractCookerTE {
    public CuttingBoardTE(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.CUTTING_BOARD.get(), pPos, pBlockState);
    }

    @Override
    protected Component getDefaultName() {
        return null;
    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return null;
    }
}
