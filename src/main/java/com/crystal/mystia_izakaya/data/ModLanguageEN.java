package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.items.IngredientItem;
import com.crystal.mystia_izakaya.registry.items.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageEN extends LanguageProvider {
    public ModLanguageEN(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.mystias_izakaya", "Mystia's Izakaya");
        this.add(ItemRegistry.MystiaFishingRod.get(), "Mystia's Fishing Rod");
        this.add(IngredientItem.Trout.get(), "Trout");
        this.add(IngredientItem.Lamprey.get(), "Lamprey");
        this.add(IngredientItem.Salmon.get(), "Salmon");
        this.add(IngredientItem.Tuna.get(), "Tuna");
        this.add(IngredientItem.Premium_Tuna.get(), "Premium Tuna");
        this.add(IngredientItem.Pufferfish.get(), "Pufferfish");
        this.add(IngredientItem.Shrimp.get(), "Shrimp");
        this.add(IngredientItem.Octopus.get(), "Octopus");
        this.add(IngredientItem.Sea_Urchin.get(), "Sea Urchin");
        this.add(IngredientItem.Crab.get(), "Crab");
    }
}
