package com.crystal.mystia_izakaya.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProviderCN extends LanguageProvider {
    public ModLanguageProviderCN(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.mystias_izakaya", "东方夜雀食堂");
    }
}
