package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.items.IngredientItem;
import com.crystal.mystia_izakaya.registry.items.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageCN extends LanguageProvider {
    public ModLanguageCN(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.mystias_izakaya", "东方夜雀食堂");
        this.add(ItemRegistry.MystiaFishingRod.get(), "米斯蒂娅的鱼竿");
        this.add(IngredientItem.Trout.get(), "鳟鱼");
        this.add(IngredientItem.Lamprey.get(), "八目鳗");
        this.add(IngredientItem.Salmon.get(), "三文鱼");
        this.add(IngredientItem.Tuna.get(), "金枪鱼");
        this.add(IngredientItem.Premium_Tuna.get(), "极上金枪鱼");
        this.add(IngredientItem.Pufferfish.get(), "河豚");
        this.add(IngredientItem.Shrimp.get(), "虾");
        this.add(IngredientItem.Octopus.get(), "章鱼");
        this.add(IngredientItem.Sea_Urchin.get(), "海胆");
        this.add(IngredientItem.Crab.get(), "螃蟹");
    }
}
