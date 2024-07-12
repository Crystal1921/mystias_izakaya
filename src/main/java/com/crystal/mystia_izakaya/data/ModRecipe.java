package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.data.builder.MealRecipeBuilder;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipe extends RecipeProvider {
    public ModRecipe(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MystiaFishingRod.asItem())
                .pattern("  a")
                .pattern(" ab")
                .pattern("a b")
                .define('a', Items.STICK) // Define what the symbol represents
                .define('b', Items.WHITE_WOOL)
                .unlockedBy("mystia_fishing_rod", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MystiaFishingRod))
                .save(output); // Add data to builder
        CookeMealRecipe((CookedMealItem) ItemRegistry.Grilled_Lamprey.get(),output);
    }

    private void CookeMealRecipe(CookedMealItem item, RecipeOutput output ) {
        MealRecipeBuilder.shapelessMeal(RecipeCategory.FOOD, item)
                .requires(item.ingredients)
                .save(output);
    }
}
