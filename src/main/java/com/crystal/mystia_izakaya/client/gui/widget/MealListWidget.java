package com.crystal.mystia_izakaya.client.gui.widget;

import com.crystal.mystia_izakaya.client.gui.screen.RecipeBookScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.ObjectSelectionList;

public class MealListWidget extends ObjectSelectionList<MealEntry> {
    RecipeBookScreen recipeBookScreen;
    int listWidth;

    public MealListWidget(RecipeBookScreen recipeBookScreen, int listWidth, int top, int bottom) {
        super(recipeBookScreen.getMinecraftInstance(), listWidth, bottom, top, recipeBookScreen.getFontRenderer().lineHeight * 2 + 8);
        this.recipeBookScreen = recipeBookScreen;
        this.listWidth = listWidth;
        this.refreshList();
    }

    protected void renderListBackground(GuiGraphics pGuiGraphics) {
    }

    public void refreshList() {
        this.clearEntries();
        recipeBookScreen.buildImageList(this::addEntry, item -> new MealEntry(item, this.recipeBookScreen));
    }

    @Override
    protected int getScrollbarPosition() {
        return this.getDefaultScrollbarPosition() - 80;
    }
}
