package com.crystal.mystia_izakaya.utils;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.gui.menu.AbstractCookMenu;
import com.crystal.mystia_izakaya.client.item.AbstractFoodItem;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class UtilStaticMethod {
    public static ResourceLocation resourceLocation(String name) {
        return ResourceLocation.parse(prefix(name));
    }

    public static String prefix(String string) {
        return MystiaIzakaya.MODID + ":" + string;
    }

    public static boolean containsAll(Item[] array1, Item[] array2) {
        // 使用HashMap记录第一个数组中的每个元素及其出现的次数
        Map<Item, Integer> itemCountMap = new HashMap<>();
        for (Item item : array1) {
            itemCountMap.put(item, itemCountMap.getOrDefault(item, 0) + 1);
        }

        // 检查第二个数组的每个元素是否在第一个数组中
        for (Item item : array2) {
            if (!itemCountMap.containsKey(item) || itemCountMap.get(item) <= 0) {
                return false; // 若不存在或者次数不够，返回false
            }
            // 减少计数
            itemCountMap.put(item, itemCountMap.get(item) - 1);
        }

        return true;
    }

    public static Rarity getRarity(int level) {
        return switch (level) {
            case 2 -> Rarity.UNCOMMON;
            case 3 -> Rarity.RARE;
            case 4 -> Rarity.EPIC;
            case 5 -> Rarity.valueOf("MYSTIA_IZAKAYA_LEGEND");
            default -> Rarity.COMMON;
        };
    }

    public static List<Item> getItems(NonNullList<ItemStack> itemStacks, List<Item> meals, CookerTypeEnum cookerType) {
        List<Item> ingredients = itemStacks
                .stream()
                .limit(5)//限定前五个格子为材料格
                .filter(itemStack -> !itemStack.isEmpty())
                .map(ItemStack::getItem)
                .toList();
        return meals.stream()
                .parallel()
                .map(item -> (CookedMealItem) item)
                .filter(item -> item.cookerTypeEnum == cookerType)
                .filter(item -> containsAll(ingredients.toArray(new Item[0]), item.ingredients))
                .collect(Collectors.toList());
    }

    public static @NotNull ArrayList<FoodTagEnum> getPositiveTags(AbstractCookMenu cookMenu, CookedMealItem cookedMealItem) {
        TagModify tagModify = new TagModify();
        tagModify.setFull(cookMenu.isFull());
        ArrayList<FoodTagEnum> positiveTags = new ArrayList<>(cookedMealItem.positiveTag);
        List<ItemStack> ingredients = Arrays
                .stream(cookedMealItem.ingredients)
                .map(Item::getDefaultInstance)
                .toList();
        //将多余食材的标签加入展示列表，并标记冲突
        cookMenu.getIngredientStream()
                .filter(itemStack -> !itemStack.isEmpty())
                .filter(itemStack -> !ingredients.contains(itemStack))
                .map(itemStack -> ((AbstractFoodItem) itemStack.getItem()).getTagEnums())
                .flatMap(List::stream)
                .forEach(foodTagEnum -> {
                    positiveTags.add(foodTagEnum);
                    tagModify.markConflict(foodTagEnum);
                });
        //清除重复标签
        return positiveTags.stream()
                .distinct()
                .filter(foodTagEnum -> !tagModify.isConflict(foodTagEnum))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static @NotNull ArrayList<String> getPositiveStings(AbstractCookMenu cookMenu, CookedMealItem cookedMealItem) {
        return getPositiveTags(cookMenu, cookedMealItem).stream()
                .map(foodTagEnum -> Component.translatable("mystia_izakaya." + foodTagEnum.name()).getString())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static @NotNull IntList getPositiveIntList(AbstractCookMenu cookMenu, CookedMealItem cookedMealItem) {
        IntList list = new IntArrayList();
        getPositiveTags(cookMenu, cookedMealItem).forEach(foodTagEnum -> list.add(foodTagEnum.ordinal()));
        return list;
    }
}
