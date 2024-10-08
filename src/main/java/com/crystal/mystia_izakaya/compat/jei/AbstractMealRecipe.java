package com.crystal.mystia_izakaya.compat.jei;

import com.crystal.mystia_izakaya.recipe.MealRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractMealRecipe implements IRecipeCategory<MealRecipe> {
    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawable slotDraw;
    private final Component localizedName;

    public AbstractMealRecipe(IGuiHelper guiHelper, IDrawable icon) {
        this.background = guiHelper.createBlankDrawable(160, 48);
        this.slotDraw = guiHelper.getSlotDrawable();
        this.icon = icon;
        this.localizedName = Component.translatable("gui.mystia_izakaya.meal.jei");
    }

    @Override
    public @NotNull Component getTitle() {
        return localizedName;
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MealRecipe recipe, IFocusGroup focuses) {
        List<Ingredient> inputs = new ArrayList<>(recipe.getIngredients());
        ItemStack output = recipe.result;
        for (int i = 0; i < 5; i++) {
            builder.addSlot(RecipeIngredientRole.INPUT, i * 24 + 4, 5).addItemStacks(getInput(inputs, i)).setBackground(slotDraw, -1, -1);
        }
        builder.addSlot(RecipeIngredientRole.OUTPUT, 140, 5).addItemStack(output).setBackground(slotDraw, -1, -1);
    }

    @Override
    public void draw(MealRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, GuiGraphics graphics, double mouseX, double mouseY) {
        ItemStack cookerItem = recipe.cookerTypeEnum.getItem().getDefaultInstance();
        Font font = Minecraft.getInstance().font;
        float time = recipe.cookingTime;
        int darkGray = 0x555555;
        graphics.drawString(font, String.format("%.1f min", time), 16, 25, darkGray, false);
        graphics.renderItem(cookerItem, 64, 25);
    }

    private List<ItemStack> getInput(List<Ingredient> inputs, int index) {
        if (index < inputs.size()) {
            return Arrays.asList(inputs.get(index).getItems());
        }
        return Collections.singletonList(ItemStack.EMPTY);
    }
}
