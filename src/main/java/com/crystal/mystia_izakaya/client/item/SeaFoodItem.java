package com.crystal.mystia_izakaya.client.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class SeaFoodItem extends Item {
    int level;
    int price;
    @SuppressWarnings("deprecation")
    public SeaFoodItem( int level, int price) {
        super(new Item.Properties().food(new FoodProperties.Builder()
                        .nutrition(level)
                        .saturationModifier(0.3F)
                        .effect(new MobEffectInstance(MobEffects.HUNGER, 300, 2), 1.0F)
                        .alwaysEdible()
                        .build()));
        this.level = level;
        this.price = price;
    }
}
