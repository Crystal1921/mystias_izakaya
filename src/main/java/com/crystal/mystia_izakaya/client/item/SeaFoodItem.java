package com.crystal.mystia_izakaya.client.item;

import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class SeaFoodItem extends AbstractFoodItem {
    @SuppressWarnings("deprecation")
    public SeaFoodItem(String name,int level, int price, FoodTagEnum[] tagEnums) {
        super(new Item.Properties().food(new FoodProperties.Builder()
                        .nutrition(level)
                        .saturationModifier(0.3F)
                        .effect(new MobEffectInstance(MobEffects.HUNGER, 300, 2), 1.0F)
                        .alwaysEdible()
                        .build())
                , level, price, tagEnums,name);}

}
