package com.crystal.mystia_izakaya.client.item;

import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class CookedMealItem extends Item {
    public final CookerTypeEnum cookerTypeEnum;
    public final float cookingTime;
    public final int level;
    public final Item[] ingredients;
    public final FoodTagEnum[] foodTagEnum;
    public CookedMealItem(CookerTypeEnum cookerTypeEnum, int level, float cookingTime, Item[] items, FoodTagEnum[] foodTagEnums) {
        super(new Properties().food(new FoodProperties.Builder()
                .saturationModifier(0.5F)
                .nutrition(level * 2)
                .alwaysEdible()
                .build()));
        this.cookerTypeEnum = cookerTypeEnum;
        this.cookingTime = cookingTime;
        this.level = level;
        this.ingredients = items;
        this.foodTagEnum = foodTagEnums;
    }
}
