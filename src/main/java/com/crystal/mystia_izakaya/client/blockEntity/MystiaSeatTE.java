package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import com.crystal.mystia_izakaya.utils.MealList;
import com.crystal.mystia_izakaya.utils.UtilMethod;
import com.github.tartaricacid.touhoulittlemaid.entity.chatbubble.ChatText;
import com.github.tartaricacid.touhoulittlemaid.entity.chatbubble.ChatTextType;
import com.github.tartaricacid.touhoulittlemaid.entity.item.EntitySit;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static com.github.tartaricacid.touhoulittlemaid.entity.chatbubble.ChatText.EMPTY_ICON_PATH;

public class MystiaSeatTE extends BaseContainerBlockEntity {
    private static final Random random = new Random();
    private final int CONTAINER_SIZE = 1;
    private final int gapTime = 100;
    private final String maid_uuid = "maid_uuid";
    private final String target_tags = "target_tags";
    private NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
    private List<Byte> targetTags = new ArrayList<>();
    private UUID sitId;
    private int tick;

    public MystiaSeatTE(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.MYSTIAS_SEAT.get(), pos, blockState);
        this.sitId = Util.NIL_UUID;
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, MystiaSeatTE pBlockEntity) {
        if (pLevel instanceof ServerLevel serverLevel) {
            pBlockEntity.tick++;
            if (pBlockEntity.tick == pBlockEntity.gapTime) {
                pBlockEntity.tick = 0;
                Entity entity = serverLevel.getEntity(pBlockEntity.sitId);
                if (entity instanceof EntitySit sit) {
                    List<Entity> passengers = sit.getPassengers();
                    if (!passengers.isEmpty()) {
                        Entity first = passengers.getFirst();
                        //经过一大堆判断保证拿到的是目标女仆
                        if (first instanceof EntityMaid maid) {
                            if (pBlockEntity.targetTags.isEmpty()) {
                                pBlockEntity.targetTags = UtilMethod.getRandomTags(MealList.getInstance().getFoodTags(), 3);
                            }
                            StringBuilder sb = new StringBuilder();
                            for (int i = 0; i < 2; i++) {
                                sb.append(Component.translatable("mystia_izakaya." + MealList.getInstance().getFoodTags()[pBlockEntity.targetTags.get(i)]).getString()).append(" ");
                            }
                            maid.addChatBubble(System.currentTimeMillis() + (pBlockEntity.gapTime - 1) * 50, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, sb.toString()));
                        }
                    }
                }
            }
        }
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
