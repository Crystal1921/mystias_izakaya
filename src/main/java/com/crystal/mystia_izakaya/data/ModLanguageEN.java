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

        Arrays.stream(FoodTagEnum.values()).toList()
                .forEach(foodTagEnum -> this.add(MystiaIzakaya.MODID + "." + foodTagEnum.name(), foodTagEnum.name()));
    }
}
