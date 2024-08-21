package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.client.gui.menu.FryingPanMenu;
import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class FryingPanTE extends AbstractCookerTE{
    public FryingPanTE(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.FRYING_PAN.get(), pPos, pBlockState);
        this.cookerTypeEnum = CookerTypeEnum.Frying_Pan;
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("block.mystia_izakaya.frying_pan");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new FryingPanMenu(pContainerId, pInventory, this,this,this.dataAccess);
    }
}
