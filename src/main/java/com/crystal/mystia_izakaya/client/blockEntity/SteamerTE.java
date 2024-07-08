package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.client.gui.menu.SteamerMenu;
import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SteamerTE extends AbstractCookerTE {
    public SteamerTE(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.STEAMER.get(), pPos, pBlockState);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("block.mystia_izakaya.steamer");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new SteamerMenu(pContainerId, pInventory, this);
    }
}
