package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.UUID;

public class MystiaSeatTE extends BaseContainerBlockEntity {
    private UUID sitId;
    private final int CONTAINER_SIZE = 1;
    private NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);

    public MystiaSeatTE(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.MYSTIAS_SEAT.get(), pos, blockState);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, MystiaSeatTE pBlockEntity) {

    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items, pRegistries);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider pRegistries) {
        ContainerHelper.saveAllItems(pTag, this.items, pRegistries);
        super.saveAdditional(pTag, pRegistries);
    }

    public ItemStack getItem() {
        return items.getFirst();
    }

    public UUID getSitId() {
        return sitId;
    }

    public void setSitId(UUID sitId) {
        this.sitId = sitId;
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("block.mystia_izakaya.mystias_seat");
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, @NotNull Inventory inventory) {
        return null;
    }

    @Override
    public int getContainerSize() {
        return CONTAINER_SIZE;
    }

    @Override
    @Nullable
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.@NotNull Provider registries) {
        return saveWithoutMetadata(registries);
    }
}
