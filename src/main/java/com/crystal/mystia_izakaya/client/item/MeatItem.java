package com.crystal.mystia_izakaya.client.item;

import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class MeatItem extends AbstractFoodItem {
    public MeatItem(int level, int price, FoodTagEnum[] tagEnums) {
        super(new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(level + 1)
                .saturationModifier(0.5F)
                .alwaysEdible()
                .build()
        ), level, price, tagEnums);
    }
}
