package com.crystal.mystia_izakaya.client.item;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.component.FoodTagComponent;
import com.crystal.mystia_izakaya.registry.ComponentRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import com.crystal.mystia_izakaya.utils.LocalMealList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CookedMealItem extends Item {
    public final CookerTypeEnum cookerTypeEnum;
    public final float cookingTime;
    public final int level;
    public final List<Ingredient> ingredients;
    public final List<FoodTagEnum> positiveTag;
    public final List<FoodTagEnum> negativeTag;

    public CookedMealItem(CookerTypeEnum cookerTypeEnum, int level, float cookingTime, List<TagKey<Item>> items, FoodTagEnum[] positiveTag, FoodTagEnum[] negativeTag) {
        super(new Properties().food(new FoodProperties.Builder()
                .saturationModifier(0.5F)
                .nutrition(level * 2)
                .alwaysEdible()
                .build()));
        this.cookerTypeEnum = cookerTypeEnum;
        this.cookingTime = cookingTime;
        this.level = level;
        this.ingredients = items.stream().map(Ingredient::of).toList();
        this.positiveTag = Arrays.stream(positiveTag).toList();
        this.negativeTag = Arrays.stream(negativeTag).toList();
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        FoodTagComponent foodTagComponent = pStack.get(ComponentRegistry.FOOD_TAG);
        FoodTagEnum[] foodTagEnums = LocalMealList.getInstance().getFoodTags();
        if (foodTagComponent != null) {
            IntList intList = foodTagComponent.intList();
            intList.intStream().mapToObj(integer -> foodTagEnums[integer])
                    .filter(Objects::nonNull)
                    .forEach(foodTagEnum -> pTooltipComponents.add(Component.translatable(MystiaIzakaya.MODID + "." + foodTagEnum.name()).withColor(Color.GREEN.getRGB())));
        } else {
            positiveTag.stream()
                    .filter(Objects::nonNull)
                    .forEach(foodTagEnum -> pTooltipComponents.add(Component.translatable(MystiaIzakaya.MODID + "." + foodTagEnum.name()).withColor(Color.GREEN.getRGB())));
        }
        if (!negativeTag.isEmpty()) {
            negativeTag.stream()
                    .filter(Objects::nonNull)
                    .forEach(foodTagEnum -> pTooltipComponents.add(Component.translatable(MystiaIzakaya.MODID + "." + foodTagEnum.name()).withColor(Color.RED.getRGB())));
        }
    }
}
