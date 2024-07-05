package com.crystal.mystia_izakaya.registry.items;

import com.crystal.mystia_izakaya.client.item.SeaFoodItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class IngredientItem {
    //鳟鱼
    public static final DeferredItem<Item> Trout = ItemRegistry.ITEMS.register("trout", () -> new SeaFoodItem(1, 8));
    //八目鳗
    public static final DeferredItem<Item> Lamprey = ItemRegistry.ITEMS.register("lamprey", () -> new SeaFoodItem(2, 14));
    //三文鱼
    public static final DeferredItem<Item> Salmon = ItemRegistry.ITEMS.register("salmon", () -> new SeaFoodItem(3, 24));
    //金枪鱼
    public static final DeferredItem<Item> Tuna = ItemRegistry.ITEMS.register("tuna", () -> new SeaFoodItem(3, 30));
    //极上金枪鱼
    public static final DeferredItem<Item> Premium_Tuna = ItemRegistry.ITEMS.register("premium_tuna", () -> new SeaFoodItem(5, 34));
    //河豚
    public static final DeferredItem<Item> Pufferfish = ItemRegistry.ITEMS.register("pufferfish", () -> new SeaFoodItem(5, 42));
    //虾
    public static final DeferredItem<Item> Shrimp = ItemRegistry.ITEMS.register("shrimp", () -> new SeaFoodItem(2, 30));
    //章鱼
    public static final DeferredItem<Item> Octopus = ItemRegistry.ITEMS.register("octopus", () -> new SeaFoodItem(2, 12));
    //海胆
    public static final DeferredItem<Item> Sea_Urchin = ItemRegistry.ITEMS.register("sea_urchin", () -> new SeaFoodItem(3, 18));
    //螃蟹
    public static final DeferredItem<Item> Crab = ItemRegistry.ITEMS.register("crab", () -> new SeaFoodItem(3, 10));
}
