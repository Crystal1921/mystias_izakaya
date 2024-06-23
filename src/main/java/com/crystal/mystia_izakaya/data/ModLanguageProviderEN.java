package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProviderEN extends LanguageProvider {
    public ModLanguageProviderEN(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.mystias_izakaya", "Mystia's Izakaya");
        this.add(ItemRegistry.MystiaFishingRod.get(), "Mystia's Fishing Rod");
    }
}
