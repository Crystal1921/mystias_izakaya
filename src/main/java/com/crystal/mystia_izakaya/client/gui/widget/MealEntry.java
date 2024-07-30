package com.crystal.mystia_izakaya.client.gui.widget;

import com.crystal.mystia_izakaya.client.gui.screen.RecipeBookScreen;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ObjectSelectionList;
import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import org.jetbrains.annotations.NotNull;

public class MealEntry extends ObjectSelectionList.Entry<MealEntry>{
    CookedMealItem cookedMealItem;
    RecipeBookScreen recipeBookScreen;

    public MealEntry(CookedMealItem cookedMealItem, RecipeBookScreen recipeBookScreen) {
        this.cookedMealItem = cookedMealItem;
        this.recipeBookScreen = recipeBookScreen;
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton)
    {
        recipeBookScreen.setSelected(this);
        recipeBookScreen.getMealListWidget().setSelected(this);
        return false;
    }

    @Override
    public void render(@NotNull GuiGraphics pGuiGraphics, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean isMouseOver, float pPartialTick) {
        Font font = this.recipeBookScreen.getFontRenderer();
        Component name = Component.translatable(cookedMealItem.getDescriptionId());
        pGuiGraphics.drawString(font, Language.getInstance().getVisualOrder(FormattedText.composite(font.substrByWidth(name,this.recipeBookScreen.listWidth))), pLeft + 85, pTop + 5, 0xFFFFFF, false);
        pGuiGraphics.renderItem(this.cookedMealItem.getDefaultInstance(),pLeft + 65, pTop + 2);
    }

    @Override
    public @NotNull Component getNarration() {
        return Component.translatable("narrator.select");
    }

    public CookedMealItem getCookedMealItem() {
        return cookedMealItem;
    }
}
