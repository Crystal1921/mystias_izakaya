package com.crystal.mystia_izakaya.client.gui.screen;

import com.crystal.mystia_izakaya.client.gui.menu.AbstractCookMenu;
import com.crystal.mystia_izakaya.utils.MealList;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.crystal.mystia_izakaya.utils.UtilMethod.getMatchedItems;
import static com.crystal.mystia_izakaya.utils.UtilMethod.resourceLocation;

public abstract class AbstractCookScreen<T extends AbstractCookMenu> extends AbstractContainerScreen<T> {
    ResourceLocation BACKGROUND = resourceLocation("textures/gui/cooker_bg.png");
    AbstractCookMenu abstractCookMenu;
    MealList list;

    public AbstractCookScreen(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.list = MealList.getInstance();
        this.abstractCookMenu = pMenu;
        this.imageWidth = 230;
        this.imageHeight = 219;
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        pGuiGraphics.blit(BACKGROUND, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(guiGraphics, pMouseX, pMouseY);
        renderMealItem(guiGraphics, pMouseX, pMouseY);
    }

    protected void renderMealItem(GuiGraphics guiGraphics, int pMouseX, int pMouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        List<Item> ingredients = menu.getItems()
                .stream()
                .limit(5)//限定前五个格子为材料格
                .filter(itemStack -> !itemStack.isEmpty())
                .map(ItemStack::getItem)
                .toList();
        List<Item> items = getMatchedItems(list.getMeals(), ingredients.toArray(new Item[0]), menu.cookerType);
        for (int k = 0; k < items.size(); k++) {
            guiGraphics.renderItem(items.get(k).getDefaultInstance(), i + 120 + k * 20, j + 10);
        }
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
    }
}
