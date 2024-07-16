package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Arrays;

public class ModLanguageEN extends LanguageProvider {
    public ModLanguageEN(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.mystias_izakaya", "Mystia's Izakaya");
        this.add("gui.mystias_izakaya.level", "Level");
        this.add("gui.mystias_izakaya.cooking_time", "Cooking Time");
        this.add("gui.mystias_izakaya.tags", "Tags");
        this.add("gui.mystias_izakaya.meal.jei", "Mystia's Izakaya");
        this.add("gui.mystias_izakaya.progress", "Progress");

        this.add(ItemRegistry.MystiaFishingRod.get(), "Mystia's Fishing Rod");
        this.add(ItemRegistry.Grill_Block.get(), "Grill Block");
        this.add(ItemRegistry.Boiling_Pot.get(), "Boiling Pot");
        this.add(ItemRegistry.Frying_Pan.get(), "Frying Pan");
        this.add(ItemRegistry.Steamer.get(), "Steamer");
        this.add(ItemRegistry.Cutting_Board.get(), "Cutting Board");

        this.add(ItemRegistry.Trout.get(), "Trout");
        this.add(ItemRegistry.Lamprey.get(), "Lamprey");
        this.add(ItemRegistry.Salmon.get(), "Salmon");
        this.add(ItemRegistry.Tuna.get(), "Tuna");
        this.add(ItemRegistry.Premium_Tuna.get(), "Premium Tuna");
        this.add(ItemRegistry.Pufferfish.get(), "Pufferfish");
        this.add(ItemRegistry.Shrimp.get(), "Shrimp");
        this.add(ItemRegistry.Octopus.get(), "Octopus");
        this.add(ItemRegistry.Sea_Urchin.get(), "Sea Urchin");
        this.add(ItemRegistry.Crab.get(), "Crab");

        this.add(ItemRegistry.Pork.get(),"Pork");
        this.add(ItemRegistry.Beef.get(),"Beef");
        this.add(ItemRegistry.Venison.get(),"Venison");
        this.add(ItemRegistry.Boar_Meat.get(),"Boar Meat");
        this.add(ItemRegistry.Iberico_Pork.get(),"Iberico Pork");
        this.add(ItemRegistry.Wagyo_Beef.get(),"Wagyo Beef");

        this.add(ItemRegistry.Tofu.get(), "Tofu");
        this.add(ItemRegistry.Potato.get(), "Potato");
        this.add(ItemRegistry.Onion.get(), "Onion");
        this.add(ItemRegistry.Pumpkin.get(), "Pumpkin");
        this.add(ItemRegistry.Radish.get(), "Radish");
        this.add(ItemRegistry.Seaweed.get(), "Seaweed");
        this.add(ItemRegistry.Mushroom.get(), "Mushroom");
        this.add(ItemRegistry.Truffle.get(), "Truffle");
        this.add(ItemRegistry.Bamboo_Shoot.get(),"Bamboo Shoot");
        this.add(ItemRegistry.Cucumber.get(), "Cucumber");
        this.add(ItemRegistry.Chestnut.get(), "Chestnut");
        this.add(ItemRegistry.Red_Toon.get(), "Red Toon");
        this.add(ItemRegistry.Tomato.get(), "Tomato");
        this.add(ItemRegistry.Broceoli.get(), "Broceoli");

        this.add(ItemRegistry.Egg.get(),"Egg");
        this.add(ItemRegistry.Ginko_Nut.get(),"Ginko Nut");
        this.add(ItemRegistry.Cicada_Slough.get(),"Cicada Slough");
        this.add(ItemRegistry.Dew.get(),"Dew");
        this.add(ItemRegistry.Flour.get(),"Flour");
        this.add(ItemRegistry.Sticky_Rice.get(),"Sticky Rice");
        this.add(ItemRegistry.Ice_Cube.get(),"Ice Cube");
        this.add(ItemRegistry.Grapes.get(),"Grapes");
        this.add(ItemRegistry.Cream.get(),"Cream");
        this.add(ItemRegistry.Lemon.get(),"Lemon");
        this.add(ItemRegistry.Lotus_Seed.get(),"Lotus Seed");
        this.add(ItemRegistry.Pine_Nut.get(),"Pine Nut");
        this.add(ItemRegistry.Red_Bean.get(),"Red Bean");
        this.add(ItemRegistry.Cocoa_Bean.get(),"Cocoa Bean");
        this.add(ItemRegistry.Snow_Fungus.get(),"Snow Fungus");
        this.add(ItemRegistry.Peach.get(),"Peach");
        this.add(ItemRegistry.Honey.get(),"Honey");
        this.add(ItemRegistry.Udunmbara.get(),"Udunmbara");
        this.add(ItemRegistry.Butter.get(),"Butter");
        this.add(ItemRegistry.Bamboo.get(),"Bamboo");
        this.add(ItemRegistry.Lunar_Herb.get(),"Lunar Herb");
        this.add(ItemRegistry.Chili.get(),"Chili");
        this.add(ItemRegistry.Black_Salt.get(),"Black Salt");
        this.add(ItemRegistry.Bingdi_Lotus.get(),"Bingdi Lotus");
        this.add(ItemRegistry.Cheese.get(),"Cheese");
        this.add(ItemRegistry.Sweet_Potato.get(),"Sweet Potato");
        this.add(ItemRegistry.Plum.get(),"Plum");
        this.add(ItemRegistry.Flower.get(),"Flower");
        this.add(ItemRegistry.Creeping_Fig.get(),"Creeping Fig");

        this.add(ItemRegistry.Grilled_Lamprey.get(),"Grilled Lamprey");

        Arrays.stream(FoodTagEnum.values()).toList()
                .forEach(foodTagEnum -> this.add(MystiaIzakaya.MODID + "." + foodTagEnum.name(), foodTagEnum.name()));
    }
}
