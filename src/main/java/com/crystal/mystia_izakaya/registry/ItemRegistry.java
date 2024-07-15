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
    public static final DeferredItem<Item> Red_Toom = ITEMS.register("red_toom",  () -> new VegetableItem("香椿",2,20,new FoodTagEnum[]{Vegetarian,Poison}));
    public static final DeferredItem<Item> Tomato = ITEMS.register("tomato", () -> new VegetableItem("番茄",1,8,new FoodTagEnum[]{Vegetarian}));
    public static final DeferredItem<Item> Broceoli = ITEMS.register("broceoli",  () -> new VegetableItem("西蓝花",2,18,new FoodTagEnum[]{Vegetarian,Homecooking}));
    
    public static final DeferredItem<Item> Grilled_Lamprey = ITEMS.register("grilled_lamprey",
            () -> new CookedMealItem(CookerTypeEnum.Grill, 2, 4.2F, new Item[]{Lamprey.asItem()}, new FoodTagEnum[]{Aquatic, Signature, Grilled}));
}
