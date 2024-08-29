package com.crystal.mystia_izakaya.compat.jei;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.recipe.MealRecipe;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;

public class BoilingPotRecipe extends AbstractMealRecipe {
    public static final RecipeType<MealRecipe> BOILING_POT_MEAL = RecipeType.create(MystiaIzakaya.MODID, "boiling_pot_meal", MealRecipe.class);
    public BoilingPotRecipe(IGuiHelper guiHelper) {
        super(guiHelper, guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.Boiling_Pot.asItem())));
    }

    @Override
    public RecipeType<MealRecipe> getRecipeType() {
        return BOILING_POT_MEAL;
    }
}
