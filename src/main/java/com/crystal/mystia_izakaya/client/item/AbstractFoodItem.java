package com.crystal.mystia_izakaya.client.item;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.Arrays;
import java.util.List;

import static com.crystal.mystia_izakaya.utils.UtilStaticMethod.getRarity;

public abstract class AbstractFoodItem extends Item {
    int level;
    int price;
    String name;
    FoodTagEnum[] tagEnums;

    public AbstractFoodItem(Properties pProperties, int level, int price, FoodTagEnum[] tagEnums,String name) {
        super(pProperties.rarity(getRarity(level)));
        this.level = level;
        this.price = price;
        this.tagEnums = tagEnums;
        this.name = name;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        Arrays.stream(tagEnums).toList()
                .forEach(foodTagEnum -> pTooltipComponents.add(Component.translatable(MystiaIzakaya.MODID + "." + foodTagEnum.name())));
    }

    public List<FoodTagEnum> getTagEnums() {
        return Arrays.stream(tagEnums).toList();
    }
}
