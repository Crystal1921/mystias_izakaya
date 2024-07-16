package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.item.*;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.crystal.mystia_izakaya.utils.FoodTagEnum.*;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MystiaIzakaya.MODID);
    public static final DeferredItem<Item> MystiaFishingRod = ITEMS.register("mystia_fishing_rod", MystiaFishingRod::new);
    public static final DeferredItem<Item> Grill_Block = ITEMS.register("grill", () -> new BlockItem(BlockRegistry.Grill.get(), new Item.Properties()));
    public static final DeferredItem<Item> Boiling_Pot = ITEMS.register("boiling_pot", () -> new BlockItem(BlockRegistry.Boiling_Pot.get(), new Item.Properties()));
    public static final DeferredItem<Item> Frying_Pan = ITEMS.register("frying_pan", () -> new BlockItem(BlockRegistry.Frying_Pan.get(), new Item.Properties()));
    public static final DeferredItem<Item> Steamer = ITEMS.register("steamer", () -> new BlockItem(BlockRegistry.Steamer.get(), new Item.Properties()));
    public static final DeferredItem<Item> Cutting_Board = ITEMS.register("cutting_board", () -> new BlockItem(BlockRegistry.Cutting_Board.get(), new Item.Properties()));

    public static final DeferredItem<Item> Crab = ITEMS.register("crab", () -> new SeaFoodItem("螃蟹",3, 10, new FoodTagEnum[]{Fresh, Aquatic, Premium}));
    public static final DeferredItem<Item> Sea_Urchin = ITEMS.register("sea_urchin", () -> new SeaFoodItem("海胆",3, 18, new FoodTagEnum[]{Aquatic, Sea_Delicacy, Legendary, Fresh, Premium}));
    public static final DeferredItem<Item> Octopus = ITEMS.register("octopus", () -> new SeaFoodItem("章鱼",2, 12, new FoodTagEnum[]{Fresh, Aquatic, Sea_Delicacy}));
    public static final DeferredItem<Item> Shrimp = ITEMS.register("shrimp", () -> new SeaFoodItem("虾",2, 30, new FoodTagEnum[]{Fresh, Aquatic}));
    public static final DeferredItem<Item> Pufferfish = ITEMS.register("pufferfish", () -> new SeaFoodItem("河豚",5, 42, new FoodTagEnum[]{Fresh, Aquatic, Sea_Delicacy}));
    public static final DeferredItem<Item> Premium_Tuna = ITEMS.register("premium_tuna", () -> new SeaFoodItem("极上金枪鱼",5, 34, new FoodTagEnum[]{Aquatic, Sea_Delicacy, Legendary, Fresh, Premium}));
    public static final DeferredItem<Item> Tuna = ITEMS.register("tuna", () -> new SeaFoodItem("金枪鱼",3, 30, new FoodTagEnum[]{Fresh, Aquatic, Premium}));
    public static final DeferredItem<Item> Salmon = ITEMS.register("salmon", () -> new SeaFoodItem("三文鱼",3, 24, new FoodTagEnum[]{Fresh, Aquatic, Premium}));
    public static final DeferredItem<Item> Lamprey = ITEMS.register("lamprey", () -> new SeaFoodItem("八目鳗",2, 14, new FoodTagEnum[]{Fresh, Aquatic, Signature}));
    public static final DeferredItem<Item> Trout = ITEMS.register("trout", () -> new SeaFoodItem("鳟鱼",1, 8, new FoodTagEnum[]{Fresh, Aquatic}));

    public static final DeferredItem<Item> Pork = ITEMS.register("pork", () -> new MeatItem("猪肉",1, 10, new FoodTagEnum[]{Meat}));
    public static final DeferredItem<Item> Beef = ITEMS.register("beef", () -> new MeatItem("牛肉",2, 15, new FoodTagEnum[]{Meat}));
    public static final DeferredItem<Item> Venison = ITEMS.register("venison", () -> new MeatItem("鹿肉",2, 20, new FoodTagEnum[]{Meat}));
    public static final DeferredItem<Item> Boar_Meat = ITEMS.register("boar_meat", () -> new MeatItem("野猪肉",3, 25, new FoodTagEnum[]{Meat}));
    public static final DeferredItem<Item> Iberico_Pork = ITEMS.register("iberico_pork", () -> new MeatItem("黑毛猪肉",4, 35, new FoodTagEnum[]{Meat, Legendary, Mountain_Delicacy}));
    public static final DeferredItem<Item> Wagyo_Beef = ITEMS.register("wagyo_beef", () -> new MeatItem("和牛",5, 40, new FoodTagEnum[]{Meat, Legendary, Premium}));
    
    public static final DeferredItem<Item> Tofu = ITEMS.register("tofu", () -> new VegetableItem("豆腐",1,8, new FoodTagEnum[]{Vegetarian,Homecooking,Mild}));
    public static final DeferredItem<Item> Potato = ITEMS.register("potato", () -> new VegetableItem("土豆",2,10,new FoodTagEnum[]{Vegetarian,Homecooking}));
    public static final DeferredItem<Item> Onion = ITEMS.register("onion",  () -> new VegetableItem("洋葱",2,12,new FoodTagEnum[]{Vegetarian,Fresh}));
    public static final DeferredItem<Item> Pumpkin = ITEMS.register("pumpkin",  () -> new VegetableItem("南瓜",2,14,new FoodTagEnum[]{Vegetarian,Filling}));
    public static final DeferredItem<Item> Radish = ITEMS.register("radish",  () -> new VegetableItem("萝卜",2,16,new FoodTagEnum[]{Vegetarian,Good_Alcohol}));
    public static final DeferredItem<Item> Seaweed = ITEMS.register("seaweed",  () -> new VegetableItem("海苔",1,3,new FoodTagEnum[]{Vegetarian,Fresh}));
    public static final DeferredItem<Item> Mushroom = ITEMS.register("mushroom", () -> new VegetableItem("蘑菇",3,18,new FoodTagEnum[]{Vegetarian,Fresh,Fungus}));
    public static final DeferredItem<Item> Truffle = ITEMS.register("truffle", () -> new VegetableItem("松露",5,50,new FoodTagEnum[]{Vegetarian,Legendary,Mountain_Delicacy,Fresh,Fungus,Premium}));
    public static final DeferredItem<Item> Bamboo_Shoot = ITEMS.register("bamboo_shoot", () -> new VegetableItem("竹笋",3,40,new FoodTagEnum[]{Vegetarian,Mild}));
    public static final DeferredItem<Item> Cucumber = ITEMS.register("cucumber", () -> new VegetableItem("黄瓜",1,7,new FoodTagEnum[]{Vegetarian,Homecooking,Mild}));
    public static final DeferredItem<Item> Chestnut = ITEMS.register("chestnut",  () -> new VegetableItem("板栗",2,10,new FoodTagEnum[]{Vegetarian,Homecooking}));
    public static final DeferredItem<Item> Red_Toon = ITEMS.register("red_toon",  () -> new VegetableItem("香椿",2,20,new FoodTagEnum[]{Vegetarian,Poison}));
    public static final DeferredItem<Item> Tomato = ITEMS.register("tomato", () -> new VegetableItem("番茄",1,8,new FoodTagEnum[]{Vegetarian}));
    public static final DeferredItem<Item> Broceoli = ITEMS.register("broceoli",  () -> new VegetableItem("西蓝花",2,18,new FoodTagEnum[]{Vegetarian,Homecooking}));

    public static final DeferredItem<Item> Egg = ITEMS.register("egg", () -> new VegetableItem("鸡蛋",1,4,new FoodTagEnum[]{Raw}));
    public static final DeferredItem<Item> Ginko_Nut = ITEMS.register("ginko_nut", () -> new VegetableItem("白果",2,7,new FoodTagEnum[]{Photogenic}));
    public static final DeferredItem<Item> Cicada_Slough = ITEMS.register("cicada_slough", () -> new VegetableItem("蝉蜕",1,5,new FoodTagEnum[]{Peculiar}));
    public static final DeferredItem<Item> Dew = ITEMS.register("dew", () -> new VegetableItem("露水",1,10,new FoodTagEnum[]{Mild}));
    public static final DeferredItem<Item> Flour = ITEMS.register("flour", () -> new VegetableItem("面粉",2,10,new FoodTagEnum[]{Filling}));
    public static final DeferredItem<Item> Sticky_Rice = ITEMS.register("sticky_rice", () -> new VegetableItem("糯米",3,15,new FoodTagEnum[]{Empty}));
    public static final DeferredItem<Item> Ice_Cube = ITEMS.register("ice_cube", () -> new VegetableItem("冰块",1,2,new FoodTagEnum[]{Refreshing}));
    public static final DeferredItem<Item> Grapes = ITEMS.register("grapes", () -> new VegetableItem("葡萄",1,5,new FoodTagEnum[]{Fruity}));
    public static final DeferredItem<Item> Cream = ITEMS.register("cream", () -> new VegetableItem("奶油",1,9,new FoodTagEnum[]{Homecooking,Sweet,Western}));
    public static final DeferredItem<Item> Lemon = ITEMS.register("lemon", () -> new VegetableItem("柠檬",1,8,new FoodTagEnum[]{Sour,Fruity}));
    public static final DeferredItem<Item> Lotus_Seed = ITEMS.register("lotus_seed", () -> new VegetableItem("莲子",3,22,new FoodTagEnum[]{Signature,Mild,Culture_Heritage}));
    public static final DeferredItem<Item> Pine_Nut = ITEMS.register("pine_nut", () -> new VegetableItem("松子",2,15,new FoodTagEnum[]{Signature,Mild,Premium}));
    public static final DeferredItem<Item> Red_Bean = ITEMS.register("red_bean", () -> new VegetableItem("红豆",2,18,new FoodTagEnum[]{Homecooking}));
    public static final DeferredItem<Item> Cocoa_Bean = ITEMS.register("cocoa_bean", () -> new VegetableItem("可可豆",3,22,new FoodTagEnum[]{Sweet,Wonderful}));
    public static final DeferredItem<Item> Snow_Fungus = ITEMS.register("snow_fungus", () -> new VegetableItem("银耳",3,14,new FoodTagEnum[]{Fungus,Mild}));
    public static final DeferredItem<Item> Peach = ITEMS.register("peach", () -> new VegetableItem("桃子",3,10,new FoodTagEnum[]{Fruity,Sweet}));
    public static final DeferredItem<Item> Honey = ITEMS.register("honey", () -> new VegetableItem("蜂蜜",2,15,new FoodTagEnum[]{Sweet}));
    public static final DeferredItem<Item> Udunmbara = ITEMS.register("udunmbara", () -> new VegetableItem("幻昙华",5,70,new FoodTagEnum[]{Legendary,Dreamy,Wonderful,Premium}));
    public static final DeferredItem<Item> Butter = ITEMS.register("butter", () -> new VegetableItem("黄油",2,8,new FoodTagEnum[]{Greasy}));
    public static final DeferredItem<Item> Bamboo = ITEMS.register("bamboo", () -> new VegetableItem("竹子",3,15,new FoodTagEnum[]{Photogenic}));
    public static final DeferredItem<Item> Lunar_Herb = ITEMS.register("lunar_herb", () -> new VegetableItem("月光草",5,70,new FoodTagEnum[]{Wonderful,Mild,Dreamy,Culture_Heritage}));
    public static final DeferredItem<Item> Chili = ITEMS.register("chili", () -> new VegetableItem("辣椒",1,2,new FoodTagEnum[]{Spicy}));
    public static final DeferredItem<Item> Black_Salt = ITEMS.register("black_salt", () -> new VegetableItem("黑盐",1,3,new FoodTagEnum[]{Salty}));
    public static final DeferredItem<Item> Bingdi_Lotus = ITEMS.register("bingdi_lotus", () -> new VegetableItem("并蒂莲",3,36,new FoodTagEnum[]{Culture_Heritage,Premium,Legendary,Mild,Dreamy}));
    public static final DeferredItem<Item> Cheese = ITEMS.register("cheese", () -> new VegetableItem("芝士",2,18,new FoodTagEnum[]{Premium,Salty,Fresh}));
    public static final DeferredItem<Item> Sweet_Potato = ITEMS.register("sweet_potato", () -> new VegetableItem("地瓜",1,8,new FoodTagEnum[]{Filling}));
    public static final DeferredItem<Item> Plum = ITEMS.register("plum", () -> new VegetableItem("梅子",1,12,new FoodTagEnum[]{Salty,Small_Portion}));
    public static final DeferredItem<Item> Flower = ITEMS.register("flower", () -> new VegetableItem("鲜花",3,45,new FoodTagEnum[]{Dreamy,Photogenic}));
    public static final DeferredItem<Item> Creeping_Fig = ITEMS.register("creeping_fig", () -> new VegetableItem("薜荔",2,21,new FoodTagEnum[]{Dreamy,Refreshing}));


    public static final DeferredItem<Item> Grilled_Lamprey = ITEMS.register("grilled_lamprey",
            () -> new CookedMealItem(CookerTypeEnum.Grill, 2, 4.2F, new Item[]{Lamprey.asItem()}, new FoodTagEnum[]{Aquatic, Signature, Grilled}));
}
