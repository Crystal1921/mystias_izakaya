package com.crystal.mystia_izakaya.registry.items;

import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.utils.CookerItemEnum;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class MealItem {
    //烤八目鳗
    public static final DeferredItem<Item> Grilled_Lamprey = ItemRegistry.ITEMS.register("grilled_lamprey",
            () -> new CookedMealItem(CookerItemEnum.Grill, 2, 4.2F, new Item[]{IngredientItem.Lamprey.asItem()}, new FoodTagEnum[]{FoodTagEnum.Aquatic}));

}
