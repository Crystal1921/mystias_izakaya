package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.ItemRegistry;
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
        this.add(ItemRegistry.Trout.get(), "鳟鱼");
        this.add(ItemRegistry.Lamprey.get(), "八目鳗");
        this.add(ItemRegistry.Salmon.get(), "三文鱼");
        this.add(ItemRegistry.Tuna.get(), "金枪鱼");
        this.add(ItemRegistry.Premium_Tuna.get(), "极上金枪鱼");
        this.add(ItemRegistry.Pufferfish.get(), "河豚");
        this.add(ItemRegistry.Shrimp.get(), "虾");
        this.add(ItemRegistry.Octopus.get(), "章鱼");
        this.add(ItemRegistry.Sea_Urchin.get(), "海胆");
        this.add(ItemRegistry.Crab.get(), "螃蟹");
        this.add(ItemRegistry.Grill_Block.get(), "烤架");
    }
}
