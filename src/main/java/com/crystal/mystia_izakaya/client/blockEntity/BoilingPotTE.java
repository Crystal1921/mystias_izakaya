package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class BoilingPotTE extends AbstractCookerTE {
    public BoilingPotTE(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.BOILING_POT.get(), pPos, pBlockState);
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
