package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Arrays;

public class ModLanguageCN extends LanguageProvider {
    public ModLanguageCN(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.mystias_izakaya", "东方夜雀食堂");
        this.add("gui.mystias_izakaya.level", "等级");
        this.add("gui.mystias_izakaya.cooking_time", "烹饪时间");
        this.add("gui.mystias_izakaya.tags", "标签");

        this.add(ItemRegistry.MystiaFishingRod.get(), "米斯蒂娅的鱼竿");
        this.add(ItemRegistry.Grill_Block.get(), "烤架");
        this.add(ItemRegistry.Boiling_Pot.get(), "煮锅");
        this.add(ItemRegistry.Frying_Pan.get(), "油锅");
        this.add(ItemRegistry.Steamer.get(), "蒸锅");
        this.add(ItemRegistry.Cutting_Board.get(), "料理台");

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

        this.add(ItemRegistry.Pork.get(),"猪肉");
        this.add(ItemRegistry.Beef.get(),"牛肉");
        this.add(ItemRegistry.Venison.get(),"鹿肉");
        this.add(ItemRegistry.Boar_Meat.get(),"野猪肉");
        this.add(ItemRegistry.Iberico_Pork.get(),"黑毛猪肉");
        this.add(ItemRegistry.Wagyo_Beef.get(),"和牛");

        Arrays.stream(FoodTagEnum.values()).toList()
                .forEach(foodTagEnum -> this.add(MystiaIzakaya.MODID + "." + foodTagEnum.name(), foodTagEnum.getCn()));
    }
}
