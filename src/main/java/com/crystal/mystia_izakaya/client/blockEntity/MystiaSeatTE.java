package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.UUID;

public class MystiaSeatTE extends BaseContainerBlockEntity {
    private UUID sitId;
    private final int CONTAINER_SIZE = 1;
    private NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);

    public MystiaSeatTE(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.MYSTIAS_SEAT.get(), pos, blockState);
    }

    public UUID getSitId() {
        return sitId;
    }

    public void setSitId(UUID sitId) {
        this.sitId = sitId;
    }

    @Override
    protected Component getDefaultName() {
        return null;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return null;
    }

    @Override
    public int getContainerSize() {
        return CONTAINER_SIZE;
    }
}
