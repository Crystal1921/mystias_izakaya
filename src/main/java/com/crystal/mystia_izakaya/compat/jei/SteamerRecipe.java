package com.crystal.mystia_izakaya.compat.jei;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.recipe.MealRecipe;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SteamerRecipe extends AbstractMealRecipe {
    public static final RecipeType<MealRecipe> STEAMER_MEAL = RecipeType.create(MystiaIzakaya.MODID, "steamer_meal", MealRecipe.class);

    public SteamerRecipe(IGuiHelper guiHelper) {
        super(guiHelper, guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.Steamer.asItem())));
    }

    @Override
    public @NotNull RecipeType<MealRecipe> getRecipeType() {
        return STEAMER_MEAL;
    }
}
