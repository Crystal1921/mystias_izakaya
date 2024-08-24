package com.crystal.mystia_izakaya.event;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.blockEntity.AbstractCookerTE;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.client.item.MystiasHatItem;
import com.crystal.mystia_izakaya.component.CookerPosComponent;
import com.crystal.mystia_izakaya.network.CookInfoPacket;
import com.crystal.mystia_izakaya.network.MealInfoPacket;
import com.crystal.mystia_izakaya.registry.ComponentRegistry;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.utils.MealList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.crystal.mystia_izakaya.utils.ServerUtilMethod.isIngredientsMatch;

@EventBusSubscriber(modid = MystiaIzakaya.MODID)
public class ClickEvent {
    @SubscribeEvent
    public static void onRightClickEvent(PlayerInteractEvent.RightClickBlock event) {
        BlockPos blockPos = event.getPos();
        Level level = event.getLevel();
        BlockState blockState = event.getLevel().getBlockState(blockPos);
        Player player = event.getEntity();
        Inventory inventory = player.getInventory();
        ItemStack stack = player.getMainHandItem();
        //记录厨师帽数据
        if (stack.getItem() instanceof MystiasHatItem && player.level().getBlockEntity(blockPos) instanceof AbstractCookerTE cookerTE) {
            var component = stack.get(ComponentRegistry.COOKER_POS);
            if (component == null) {
                stack.set(ComponentRegistry.COOKER_POS, new CookerPosComponent(List.of(blockPos)));
            } else {
                List<BlockPos> blockPosList = component.posList();
                if (!blockPosList.contains(blockPos) && blockPosList.size() <= 7) {
                    blockPosList.add(blockPos);
                    stack.set(ComponentRegistry.COOKER_POS, new CookerPosComponent(blockPosList));
                }
            }
            event.setCancellationResult(InteractionResult.CONSUME);
            event.setCanceled(true);
        }
        if (level.isClientSide && player.level().getBlockEntity(blockPos) instanceof AbstractCookerTE) {
            event.setCancellationResult(InteractionResult.CONSUME);
            event.setCanceled(true);
        }
        //处理菜谱逻辑
        if (!level.isClientSide()
                && player.level().getBlockEntity(blockPos) instanceof AbstractCookerTE cookerTE
                && stack.is(ItemRegistry.RecipeBook)
                && !blockState.getValue(BlockStateProperties.LIT)) {
            var targetComponent = stack.get(ComponentRegistry.TARGET_ITEM);
            if (targetComponent != null) {
                CookedMealItem cookedMealItem = MealList.getInstance().getCookedMeals().get(targetComponent);
                if (cookedMealItem.cookerTypeEnum == cookerTE.cookerTypeEnum
                        && cookerTE.getItems().stream().allMatch(ItemStack::isEmpty)
                        && isIngredientsMatch(inventory, cookedMealItem)) {
                    //非创造模式玩家背包内对应所需的食材全都减少1个
                    if (!player.isCreative()) {
                        for (int i = 0; i < cookedMealItem.ingredients.length; i++) {
                            Item item = cookedMealItem.ingredients[i];
                            for (int j = 0; j < inventory.getContainerSize(); j++) {
                                ItemStack itemstack1 = inventory.getItem(j);
                                if (itemstack1.is(item)) {
                                    itemstack1.shrink(1);
                                    break;
                                }
                            }
                        }
                    }
                    if (player.isCrouching()) {
                        //消耗材料后直接开始烹饪
                        cookerTE.cookTime = (int) (cookedMealItem.cookingTime * 20);
                        cookerTE.cookTotal = (int) (cookedMealItem.cookingTime * 20);
                        cookerTE.setItem(6, cookedMealItem.getDefaultInstance());
                        cookerTE.lit = true;
                        PacketDistributor.sendToAllPlayers(new CookInfoPacket(cookerTE.getBlockPos(), (int) (cookedMealItem.cookingTime * 20), (int) (cookedMealItem.cookingTime * 20)));
                        PacketDistributor.sendToAllPlayers(
                                new MealInfoPacket((int) (cookedMealItem.cookingTime * 20),
                                        cookerTE.getItems().stream().map(ItemStack::getItem).collect(Collectors.toCollection(ArrayList::new)),
                                        blockPos,
                                        new byte[]{0}));
                    } else {
                        //放入对应的材料
                        for (int i = 0; i < cookedMealItem.ingredients.length; i++) {
                            Item item = cookedMealItem.ingredients[i];
                            cookerTE.setItem(i, item.getDefaultInstance());
                        }
                    }
                    event.setCancellationResult(InteractionResult.CONSUME);
                    event.setCanceled(true);
                }
            }
        }
    }
}
