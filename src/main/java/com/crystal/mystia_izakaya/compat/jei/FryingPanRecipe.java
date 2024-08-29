package com.crystal.mystia_izakaya.compat.jei;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.recipe.MealRecipe;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;

public class FryingPanRecipe extends AbstractMealRecipe{
    public static final RecipeType<MealRecipe> FRYING_PAN_MEAL = RecipeType.create(MystiaIzakaya.MODID, "frying_pan_meal", MealRecipe.class);
    public FryingPanRecipe(IGuiHelper guiHelper) {
        super(guiHelper, guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.Frying_Pan.asItem())));
    }

    @Override
    public RecipeType<MealRecipe> getRecipeType() {
        return FRYING_PAN_MEAL;
    }
}
