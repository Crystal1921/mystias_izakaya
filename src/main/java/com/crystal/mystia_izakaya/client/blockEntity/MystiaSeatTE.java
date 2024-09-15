package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.component.FoodTagComponent;
import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import com.crystal.mystia_izakaya.registry.ComponentRegistry;
import com.crystal.mystia_izakaya.utils.MealList;
import com.crystal.mystia_izakaya.utils.ServerUtilMethod;
import com.github.tartaricacid.touhoulittlemaid.entity.chatbubble.ChatText;
import com.github.tartaricacid.touhoulittlemaid.entity.chatbubble.ChatTextType;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import it.unimi.dsi.fastutil.ints.IntList;
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
    private final int CONTAINER_SIZE = 1;
    private final int gapTime = 100;
    private final Random random = new Random();
    private final String maid_uuid = "maid_uuid";
    private final String target_tags = "target_tags";
    private final List<String> bubbles1 = List.of(
            "我开动了",
            "就是这个味道",
            "像这样偶尔吃一顿也不错");
    private final List<String> bubbles2 = List.of(
            "这一顿，就算花光所有钱也是值得的",
            "不枉我特意攒钱来吃",
            "好马配好鞍，好酒配好菜",
            "积攒一天的疲劳被治愈了",
            "太好吃了，我要介绍的我的世界去",
            "你偷偷加了什么魔法吗，这么好吃",
            "真可谓层层叠叠，色香味俱全啊");
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
                EntityMaid maid = pBlockEntity.getEntityMaid(serverLevel);
                if (maid != null) {
                    if (pBlockEntity.targetTags.isEmpty()) {
                        int tagNum;
                        String modelId = maid.getModelId();
                        tagNum = modelId.equals("touhou_little_maid:saigyouji_yuyuko") ? 3 : 2;
                        pBlockEntity.targetTags = ServerUtilMethod.getRandomTags(MealList.getInstance().getFoodTags(), tagNum);
                    }
                    pBlockEntity.updateMeal(serverLevel);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < pBlockEntity.targetTags.size(); i++) {
                        sb.append(MealList.getInstance().getFoodTags()[pBlockEntity.targetTags.get(i)].getCn()).append(" ");
                    }
                    maid.addChatBubble(System.currentTimeMillis() + (pBlockEntity.gapTime - 1) * 50, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, sb.toString()));
                }
            }
        }
    }

    public void updateMeal(ServerLevel serverLevel) {
        EntityMaid maid = getEntityMaid(serverLevel);
        if (maid != null && !targetTags.isEmpty()) {
            ItemStack item = items.getFirst();
            if (item.getItem() instanceof CookedMealItem cookedMealItem) {
                List<Byte> tagEnums;
                FoodTagComponent foodTagComponent = item.get(ComponentRegistry.FOOD_TAG);
                if (foodTagComponent != null) {
                    IntList intList = foodTagComponent.intList();
                    tagEnums = intList.intStream().mapToObj(integer -> (byte) integer).toList();
                } else {
                    tagEnums = cookedMealItem.positiveTag.stream().map(foodTagEnum -> (byte) foodTagEnum.ordinal()).toList();
                }

                int count = 0;
                for (Byte element : targetTags) {
                    if (tagEnums.contains(element)) {
                        count++;
                    }
                }

                switch (count) {
                    case 0 -> maid.addChatBubble(System.currentTimeMillis() + 2000, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, "简直是黑暗料理"));
                    case 1 -> maid.addChatBubble(System.currentTimeMillis() + 2000, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, bubbles1.get(random.nextInt(bubbles1.size() - 1))));
                    case 2 -> maid.addChatBubble(System.currentTimeMillis() + 2000, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, bubbles2.get(random.nextInt(bubbles2.size() - 1))));
                    case 3 -> maid.addChatBubble(System.currentTimeMillis() + 2000, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, "还是很怀念小脆骨呢"));
                    default -> maid.addChatBubble(System.currentTimeMillis() + 2000, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, "我是谁，我在哪里"));
                }

                items.clear();
                targetTags = new ArrayList<>();
            }
        }
    }

    @Nullable
    private EntityMaid getEntityMaid(ServerLevel pLevel) {
        if (sitId != null) {
            Entity sit = pLevel.getEntity(sitId);
            if (sit != null) {
                List<Entity> passengers = sit.getPassengers();
                if (!passengers.isEmpty()) {
                    Entity first = passengers.getFirst();
                    if (first instanceof EntityMaid maid) {
                        return maid;
                    }
                }
            }
        }
        return null;
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
