package com.crystal.mystia_izakaya.client.item;

import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class VegetableItem extends AbstractFoodItem{
    public VegetableItem(String name,int level, int price, FoodTagEnum[] tagEnums) {
        super(new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(level)
                .saturationModifier(0.3F)
                .alwaysEdible()
                .build()
        ), level, price, tagEnums,name);
    }
}
