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
        this.add("gui.mystias_izakaya.meal.jei", "夜雀食堂");
        this.add("gui.mystias_izakaya.progress", "进度");

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

        this.add(ItemRegistry.Tofu.get(), "豆腐");
        this.add(ItemRegistry.Potato.get(), "土豆");
        this.add(ItemRegistry.Onion.get(), "洋葱");
        this.add(ItemRegistry.Pumpkin.get(), "南瓜");
        this.add(ItemRegistry.Radish.get(), "萝卜");
        this.add(ItemRegistry.Seaweed.get(), "海苔");
        this.add(ItemRegistry.Mushroom.get(), "蘑菇");
        this.add(ItemRegistry.Truffle.get(), "松露");
        this.add(ItemRegistry.Bamboo_Shoot.get(),"竹笋");
        this.add(ItemRegistry.Cucumber.get(), "黄瓜");
        this.add(ItemRegistry.Chestnut.get(), "板栗");
        this.add(ItemRegistry.Red_Toon.get(), "香椿");
        this.add(ItemRegistry.Tomato.get(), "番茄");
        this.add(ItemRegistry.Broceoli.get(), "西蓝花");

        this.add(ItemRegistry.Egg.get(),"鸡蛋");
        this.add(ItemRegistry.Ginko_Nut.get(),"白果");
        this.add(ItemRegistry.Cicada_Slough.get(),"蝉蜕");
        this.add(ItemRegistry.Dew.get(),"露珠");
        this.add(ItemRegistry.Flour.get(),"面粉");
        this.add(ItemRegistry.Sticky_Rice.get(),"糯米");
        this.add(ItemRegistry.Ice_Cube.get(),"冰块");
        this.add(ItemRegistry.Grapes.get(),"葡萄");
        this.add(ItemRegistry.Cream.get(),"奶油");
        this.add(ItemRegistry.Lemon.get(),"柠檬");
        this.add(ItemRegistry.Lotus_Seed.get(),"莲子");
        this.add(ItemRegistry.Pine_Nut.get(),"松子");
        this.add(ItemRegistry.Red_Bean.get(),"红豆");
        this.add(ItemRegistry.Cocoa_Bean.get(),"可可豆");
        this.add(ItemRegistry.Snow_Fungus.get(),"银耳");
        this.add(ItemRegistry.Peach.get(),"桃子");
        this.add(ItemRegistry.Honey.get(),"蜂蜜");
        this.add(ItemRegistry.Udunmbara.get(),"幻昙华");
        this.add(ItemRegistry.Butter.get(),"黄油");
        this.add(ItemRegistry.Bamboo.get(),"竹子");
        this.add(ItemRegistry.Lunar_Herb.get(),"月光草");
        this.add(ItemRegistry.Chili.get(),"辣椒");
        this.add(ItemRegistry.Black_Salt.get(),"黑盐");
        this.add(ItemRegistry.Bingdi_Lotus.get(),"并蒂莲");
        this.add(ItemRegistry.Cheese.get(),"芝士");
        this.add(ItemRegistry.Sweet_Potato.get(),"地瓜");
        this.add(ItemRegistry.Plum.get(),"梅子");
        this.add(ItemRegistry.Flower.get(),"鲜花");
        this.add(ItemRegistry.Creeping_Fig.get(),"薜荔");

        this.add(ItemRegistry.Grilled_Lamprey.get(),"烤八目鳗");

        Arrays.stream(FoodTagEnum.values()).toList()
                .forEach(foodTagEnum -> this.add(MystiaIzakaya.MODID + "." + foodTagEnum.name(), foodTagEnum.getCn()));
    }
}
