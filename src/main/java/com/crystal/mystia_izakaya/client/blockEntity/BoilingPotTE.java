package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.client.gui.menu.BoilingPotMenu;
import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class BoilingPotTE extends AbstractCookerTE {
    public BoilingPotTE(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.BOILING_POT.get(), pPos, pBlockState);
        this.cookerTypeEnum = CookerTypeEnum.Boiling_Pot;
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("block.mystia_izakaya.boiling_pot");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pInventory) {
        return new BoilingPotMenu(pContainerId, pInventory, this,this,this.dataAccess);
    }
}
