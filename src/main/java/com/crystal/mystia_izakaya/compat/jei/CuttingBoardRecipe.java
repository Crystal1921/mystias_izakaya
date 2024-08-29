package com.crystal.mystia_izakaya.compat.jei;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.recipe.MealRecipe;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;

public class CuttingBoardRecipe extends AbstractMealRecipe{
    public static final RecipeType<MealRecipe> CUTTING_BOARD_MEAL = RecipeType.create(MystiaIzakaya.MODID, "cutting_board_meal", MealRecipe.class);
    public CuttingBoardRecipe(IGuiHelper guiHelper) {
        super(guiHelper, guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.Cutting_Board.asItem())));
    }

    @Override
    public RecipeType<MealRecipe> getRecipeType() {
        return CUTTING_BOARD_MEAL;
    }
}
