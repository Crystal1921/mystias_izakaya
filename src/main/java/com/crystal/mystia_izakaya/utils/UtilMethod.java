package com.crystal.mystia_izakaya.utils;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UtilMethod {
    public static ResourceLocation resourceLocation(String name) {
        return ResourceLocation.parse(prefix(name));
    }

    public static String prefix(String string) {
        return MystiaIzakaya.MODID + ":" + string;
    }

    public static List<Item> getMatchedItems(List<Item> meals, Item[] items, CookerTypeEnum cookerType) {
        return meals.stream()
                .parallel()
                .map(item -> (CookedMealItem) item)
                .filter(item -> item.cookerTypeEnum == cookerType)
                .filter(item -> containsAll(items, item.ingredients))
                .collect(Collectors.toList());
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
}
