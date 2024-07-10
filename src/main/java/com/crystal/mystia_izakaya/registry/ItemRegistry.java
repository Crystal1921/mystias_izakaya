package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.client.item.MeatItem;
import com.crystal.mystia_izakaya.client.item.MystiaFishingRod;
import com.crystal.mystia_izakaya.client.item.SeaFoodItem;
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

    //螃蟹
    public static final DeferredItem<Item> Crab = ITEMS.register("crab", () -> new SeaFoodItem(3, 10, new FoodTagEnum[]{Fresh, Aquatic, Premium}));
    //海胆
    public static final DeferredItem<Item> Sea_Urchin = ITEMS.register("sea_urchin", () -> new SeaFoodItem(3, 18, new FoodTagEnum[]{Aquatic, Sea_Delicacy, Legendary, Fresh, Premium}));
    //章鱼
    public static final DeferredItem<Item> Octopus = ITEMS.register("octopus", () -> new SeaFoodItem(2, 12, new FoodTagEnum[]{Fresh, Aquatic, Sea_Delicacy}));
    //虾
    public static final DeferredItem<Item> Shrimp = ITEMS.register("shrimp", () -> new SeaFoodItem(2, 30, new FoodTagEnum[]{Fresh, Aquatic}));
    //河豚
    public static final DeferredItem<Item> Pufferfish = ITEMS.register("pufferfish", () -> new SeaFoodItem(5, 42, new FoodTagEnum[]{Fresh, Aquatic, Sea_Delicacy}));
    //极上金枪鱼
    public static final DeferredItem<Item> Premium_Tuna = ITEMS.register("premium_tuna", () -> new SeaFoodItem(5, 34, new FoodTagEnum[]{Aquatic, Sea_Delicacy, Legendary, Fresh, Premium}));
    //金枪鱼
    public static final DeferredItem<Item> Tuna = ITEMS.register("tuna", () -> new SeaFoodItem(3, 30, new FoodTagEnum[]{Fresh, Aquatic, Premium}));
    //三文鱼
    public static final DeferredItem<Item> Salmon = ITEMS.register("salmon", () -> new SeaFoodItem(3, 24, new FoodTagEnum[]{Fresh, Aquatic, Premium}));
    //八目鳗
    public static final DeferredItem<Item> Lamprey = ITEMS.register("lamprey", () -> new SeaFoodItem(2, 14, new FoodTagEnum[]{Fresh, Aquatic, Signature}));
    //烤八目鳗
    public static final DeferredItem<Item> Grilled_Lamprey = ITEMS.register("grilled_lamprey",
            () -> new CookedMealItem(CookerTypeEnum.Grill, 2, 4.2F, new Item[]{Lamprey.asItem()}, new FoodTagEnum[]{Aquatic, Signature, Grilled}));
    //鳟鱼
    public static final DeferredItem<Item> Trout = ITEMS.register("trout", () -> new SeaFoodItem(1, 8, new FoodTagEnum[]{Fresh, Aquatic}));
    //猪肉
    public static final DeferredItem<Item> Pork = ITEMS.register("pork", () -> new MeatItem(1, 10, new FoodTagEnum[]{Meat}));
    //牛肉
    public static final DeferredItem<Item> Beef = ITEMS.register("beef", () -> new MeatItem(2, 15, new FoodTagEnum[]{Meat}));
    //鹿肉
    public static final DeferredItem<Item> Venison = ITEMS.register("venison", () -> new MeatItem(2, 20, new FoodTagEnum[]{Meat}));
    //野猪肉
    public static final DeferredItem<Item> Boar_Meat = ITEMS.register("boar_meat", () -> new MeatItem(3, 25, new FoodTagEnum[]{Meat}));
    //黑毛猪肉
    public static final DeferredItem<Item> Iberico_Pork = ITEMS.register("iberico_pork", () -> new MeatItem(4, 35, new FoodTagEnum[]{Meat, Legendary, Mountain_Delicacy}));
    //和牛
    public static final DeferredItem<Item> Wagyo_Beef = ITEMS.register("wagyo_beef", () -> new MeatItem(5, 40, new FoodTagEnum[]{Meat, Legendary, Premium}));
}
