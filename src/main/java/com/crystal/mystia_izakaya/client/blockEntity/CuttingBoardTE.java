package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.client.gui.menu.CuttingBoardMenu;
import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class CuttingBoardTE extends AbstractCookerTE {
    public CuttingBoardTE(BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.CUTTING_BOARD.get(), pPos, pBlockState);
        this.cookerTypeEnum = CookerTypeEnum.Cutting_Board;
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("block.mystia_izakaya.cutting_board");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return new CuttingBoardMenu(pContainerId, pInventory, this,this,this.dataAccess);
    }
}
