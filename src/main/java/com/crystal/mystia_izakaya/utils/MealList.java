package com.crystal.mystia_izakaya.utils;

import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.world.item.Item;

import java.util.List;

public class MealList {
    private static MealList instance;
    private final List<Item> meals;

    private MealList() {
        meals = List.of(ItemRegistry.Grilled_Lamprey.asItem());
    }

    // 提供公共的访问方法
    public static synchronized MealList getInstance() {
        if (instance == null) {
            instance = new MealList();
        }
        return instance;
    }

    public List<Item> getMeals() {
        return meals;
    }
}
