package com.crystal.mystia_izakaya.compat.touhou_little_maid;

import com.crystal.mystia_izakaya.client.blockEntity.MystiaSeatTE;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.component.FoodTagComponent;
import com.crystal.mystia_izakaya.registry.ComponentRegistry;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.registry.MemoryTypeRegister;
import com.crystal.mystia_izakaya.utils.LocalMealList;
import com.crystal.mystia_izakaya.utils.ServerUtilMethod;
import com.github.tartaricacid.touhoulittlemaid.entity.ai.brain.task.MaidCheckRateTask;
import com.github.tartaricacid.touhoulittlemaid.entity.chatbubble.ChatText;
import com.github.tartaricacid.touhoulittlemaid.entity.chatbubble.ChatTextType;
import com.github.tartaricacid.touhoulittlemaid.entity.item.EntitySit;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.github.tartaricacid.touhoulittlemaid.init.InitEntities;
import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.behavior.BlockPosTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.crystal.mystia_izakaya.client.blockEntity.MystiaSeatTE.bubbles1;
import static com.crystal.mystia_izakaya.client.blockEntity.MystiaSeatTE.bubbles2;
import static com.github.tartaricacid.touhoulittlemaid.entity.chatbubble.ChatText.EMPTY_ICON_PATH;

public class MaidMealTask extends MaidCheckRateTask {
    private static final Random random = new Random();
    private static final int checkRate = 50;
    private static final int showTime = 2000;

    public MaidMealTask() {
        super(ImmutableMap.of(MemoryModuleType.WALK_TARGET, MemoryStatus.VALUE_ABSENT,
                InitEntities.TARGET_POS.get(), MemoryStatus.VALUE_ABSENT));
        this.setMaxCheckRate(checkRate);
    }

    @Override
    protected void start(@NotNull ServerLevel level, EntityMaid maid, long gameTimeIn) {
        if (maid.getBrain().getMemory(MemoryTypeRegister.TARGET_POS.get()).isEmpty()) {
            Entity vehicle = maid.getVehicle();
            if (vehicle instanceof EntitySit sit) {
                BlockPos associatedBlockPos = sit.getAssociatedBlockPos();
                if (level.getBlockEntity(associatedBlockPos) instanceof MystiaSeatTE) {
                    maid.getBrain().setMemory(MemoryTypeRegister.TARGET_POS.get(), new BlockPosTracker(associatedBlockPos));
                }
            }
        }
        maid.getBrain().getMemory(MemoryTypeRegister.TARGET_POS.get()).ifPresent(targetPos -> {
            BlockEntity blockEntity = level.getBlockEntity(targetPos.currentBlockPosition());
            if (blockEntity instanceof MystiaSeatTE mystiaSeatTE) {
                ItemStack item = mystiaSeatTE.getItem();
                if (mystiaSeatTE.targetTags.isEmpty()) {
                    int tagNum;
                    String modelId = maid.getModelId();
                    tagNum = modelId.equals("touhou_little_maid:saigyouji_yuyuko") ? 3 : 2;
                    mystiaSeatTE.targetTags = ServerUtilMethod.getRandomTags(LocalMealList.getInstance().getFoodTags(), tagNum);
                }
                if (!mystiaSeatTE.targetTags.isEmpty()) {
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
                        for (Byte element : mystiaSeatTE.targetTags) {
                            if (tagEnums.contains(element)) {
                                count++;
                            }
                        }

                        switch (count) {
                            case 0 ->
                                    maid.addChatBubble(System.currentTimeMillis() + showTime, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, "简直是黑暗料理"));
                            case 1 ->
                                    maid.addChatBubble(System.currentTimeMillis() + showTime, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, bubbles1.get(random.nextInt(bubbles1.size() - 1))));
                            case 2 ->
                                    maid.addChatBubble(System.currentTimeMillis() + showTime, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, bubbles2.get(random.nextInt(bubbles2.size() - 1))));
                            case 3 ->
                                    maid.addChatBubble(System.currentTimeMillis() + showTime, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, "还是很怀念小脆骨呢"));
                            default ->
                                    maid.addChatBubble(System.currentTimeMillis() + showTime, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, "我是谁，我在哪里"));
                        }

                        if (count >= 2) {
                            if (random.nextInt() < 0.1) {
                                level.addFreshEntity(new ItemEntity(level, mystiaSeatTE.getBlockPos().getX(), mystiaSeatTE.getBlockPos().getY(), mystiaSeatTE.getBlockPos().getZ(), ItemRegistry.ChromeBall.toStack()));
                            }
                        }

                        mystiaSeatTE.clearItem();
                        mystiaSeatTE.targetTags = new ArrayList<>();
                    }
                }
                level.sendBlockUpdated(mystiaSeatTE.getBlockPos(), mystiaSeatTE.getBlockState(), mystiaSeatTE.getBlockState(), Block.UPDATE_CLIENTS);
                if (!mystiaSeatTE.targetTags.isEmpty()){
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mystiaSeatTE.targetTags.size(); i++) {
                        sb.append(LocalMealList.getInstance().getFoodTags()[mystiaSeatTE.targetTags.get(i)].getCn()).append(" ");
                    }
                    maid.addChatBubble(System.currentTimeMillis() + (checkRate - 1) * 50, new ChatText(ChatTextType.TEXT, EMPTY_ICON_PATH, sb.toString()));
                }
            } else {
                maid.getBrain().eraseMemory(InitEntities.TARGET_POS.get());
                maid.stopRiding();
            }
        });
    }
}
