package com.crystal.mystia_izakaya.compat.jei;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.recipe.MealRecipe;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;

public class MealRecipeType extends AbstractMealRecipe {
    public static final RecipeType<MealRecipe> MEAL_RECIPE_RECIPE_TYPE = RecipeType.create(MystiaIzakaya.MODID, "meal_recipe", MealRecipe.class);
    public MealRecipeType(IGuiHelper guiHelper) {
        super(guiHelper,guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.Grill.asItem())));
    }

    @Override
    public RecipeType<MealRecipe> getRecipeType() {
        return MEAL_RECIPE_RECIPE_TYPE;
    }
}
