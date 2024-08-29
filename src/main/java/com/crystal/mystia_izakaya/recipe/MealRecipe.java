package com.crystal.mystia_izakaya.recipe;

import com.crystal.mystia_izakaya.registry.BlockRegistry;
import com.crystal.mystia_izakaya.registry.RecipeTypeRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;

public class MealRecipe extends ShapelessRecipe {
    public static final CookerTypeEnum[] cookers = CookerTypeEnum.values();
    public CraftingBookCategory category;
    public ItemStack result;
    public CookerTypeEnum cookerTypeEnum;
    String group;

    public MealRecipe(String pGroup, CraftingBookCategory pCategory, ItemStack pResult, NonNullList<Ingredient> pIngredients, int ordinary) {
        super(pGroup, pCategory, pResult, pIngredients);
        this.category = pCategory;
        this.result = pResult;
        this.group = pGroup;
        this.cookerTypeEnum = cookers[ordinary];
    }

    @Override
    public @NotNull ItemStack getToastSymbol() {
        return new ItemStack(BlockRegistry.Grill.asItem());
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegistry.COOKING_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return RecipeTypeRegistry.COOKED_MEAL_RECIPE.get();
    }
}
