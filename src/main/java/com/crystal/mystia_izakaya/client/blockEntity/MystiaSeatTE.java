package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import net.minecraft.Util;
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
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MystiaSeatTE extends BaseContainerBlockEntity {
    public static final List<String> bubbles1 = List.of(
            "我开动了",
            "就是这个味道",
            "像这样偶尔吃一顿也不错");
    public static final List<String> bubbles2 = List.of(
            "这一顿，就算花光所有钱也是值得的",
            "不枉我特意攒钱来吃",
            "好马配好鞍，好酒配好菜",
            "积攒一天的疲劳被治愈了",
            "太好吃了，我要介绍的我的世界去",
            "你偷偷加了什么魔法吗，这么好吃",
            "真可谓层层叠叠，色香味俱全啊");
    private final int CONTAINER_SIZE = 1;
    private final String maid_uuid = "maid_uuid";
    private final String target_tags = "target_tags";
    public List<Byte> targetTags = new ArrayList<>();
    private NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
    private UUID sitId;

    public MystiaSeatTE(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.MYSTIAS_SEAT.get(), pos, blockState);
        this.sitId = Util.NIL_UUID;
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        this.sitId = getPersistentData().getUUID(maid_uuid);
        List<Byte> bytes = new ArrayList<>();
        byte[] byteArray = getPersistentData().getByteArray(target_tags);
        for (byte b : byteArray) {
            bytes.add(b);
        }
        this.targetTags = bytes;
        ContainerHelper.loadAllItems(pTag, this.items, pRegistries);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider pRegistries) {
        ContainerHelper.saveAllItems(pTag, this.items, pRegistries);
        getPersistentData().putUUID(maid_uuid, this.sitId);
        getPersistentData().putByteArray(target_tags, targetTags);
        super.saveAdditional(pTag, pRegistries);
    }

    public ItemStack getItem() {
        return items.getFirst();
    }

    public void clearItem() {
        this.items.clear();
    }

    public UUID getSitId() {
        return sitId;
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
