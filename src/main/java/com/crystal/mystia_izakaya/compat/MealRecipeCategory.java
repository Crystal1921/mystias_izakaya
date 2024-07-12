package com.crystal.mystia_izakaya.compat;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.recipe.MealRecipe;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MealRecipeCategory implements IRecipeCategory<MealRecipe> {
    public static final RecipeType<MealRecipe> COOKED_MEAL = RecipeType.create(MystiaIzakaya.MODID, "cooked_meal", MealRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawable slotDraw;
    private final Component localizedName;

    public MealRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createBlankDrawable(160, 125);
        this.slotDraw = guiHelper.getSlotDrawable();
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ItemRegistry.MystiaFishingRod.asItem()));
        this.localizedName = Component.translatable("gui.mystias_izakaya.meal.jei");
    }

    @Override
    public RecipeType<MealRecipe> getRecipeType() {
        return COOKED_MEAL;
    }

    @Override
    public Component getTitle() {
        return localizedName;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MealRecipe recipe, IFocusGroup focuses) {
        List<Ingredient> inputs = new ArrayList<>(recipe.getIngredients());
        ItemStack output = recipe.result;
        for (int i = 0; i < 5; i++) {
            builder.addSlot(RecipeIngredientRole.INPUT, i * 18, 17).addItemStacks(getInput(inputs, i)).setBackground(slotDraw, -1, -1);
        }
        builder.addSlot(RecipeIngredientRole.OUTPUT, 140, 5).addItemStack(output).setBackground(slotDraw, -1, -1);
    }

    private List<ItemStack> getInput(List<Ingredient> inputs, int index) {
        if (index < inputs.size()) {
            return Arrays.asList(inputs.get(index).getItems());
        }
        return Collections.singletonList(ItemStack.EMPTY);
    }
}
