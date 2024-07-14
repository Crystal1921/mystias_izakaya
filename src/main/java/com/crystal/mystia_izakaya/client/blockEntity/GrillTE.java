package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.client.gui.menu.GrillMenu;
import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class GrillTE extends AbstractCookerTE {
    public GrillTE(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.GRILL.get(), pPos, pBlockState);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("block.mystia_izakaya.grill");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pInventory) {
        return new GrillMenu(pContainerId, pInventory, this,this);
    }
}
