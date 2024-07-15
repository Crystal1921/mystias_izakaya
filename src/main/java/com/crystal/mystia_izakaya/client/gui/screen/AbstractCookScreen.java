package com.crystal.mystia_izakaya.client.gui.screen;

import com.crystal.mystia_izakaya.client.gui.menu.AbstractCookMenu;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import com.crystal.mystia_izakaya.utils.UtilStaticMethod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

import static com.crystal.mystia_izakaya.utils.UtilStaticMethod.resourceLocation;

public abstract class AbstractCookScreen<T extends AbstractCookMenu> extends AbstractContainerScreen<T> {
    ResourceLocation BACKGROUND = resourceLocation("textures/gui/cooker_bg.png");
    AbstractCookMenu abstractCookMenu;
    final int yellow = Color.YELLOW.getRGB();
    final int black = Color.BLACK.getRGB();
    final int minX = 120;
    final int minY = 10;
    final int maxX = 215;
    final int maxY = 90;

    public AbstractCookScreen(T pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.abstractCookMenu = pMenu;
        this.imageWidth = 230;
        this.imageHeight = 219;
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        int dx = (int) (pMouseX - i);
        int dy = (int) (pMouseY - j);
        int x = dx - (dx) % 20 + i;
        int y = dy - (dy - 11) % 20 + j;
        int index = (x - i - 120) / 20 + (y - j - 10) / 20 * 5;
        if (pMouseX > (i + minX) && pMouseX < (i + maxX) && pMouseY > (j + minY) && pMouseY < (j + maxY)){
            if (this.minecraft != null && this.minecraft.player != null) {
                this.menu.clickMenuButton(this.minecraft.player, index);
            }
        }
        return super.mouseClicked(pMouseX, pMouseY, pButton);
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
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        renderMealItem(guiGraphics, pMouseX, pMouseY, i, j);
    }

    protected void renderMealItem(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int i, int j) {
        int index = 0;
        if (pMouseX > (i + minX) && pMouseX < (i + maxX) && pMouseY > (j + minY) && pMouseY < (j + maxY)) {
            int dx = pMouseX - i;
            int dy = pMouseY - j;
            int x = dx - (dx) % 20 + i;
            int y = dy - (dy - 11) % 20 + j;
            guiGraphics.fill(x, y, x + 20, y + 2, yellow);
            guiGraphics.fill(x, y, x + 2, y + 20, yellow);
            guiGraphics.fill(x + 18, y, x + 20, y + 20, yellow);
            guiGraphics.fill(x, y + 18, x + 20, y + 20, yellow);
            index = (x - i - 120) / 20 + (y - j - 10) / 20 * 5;
        }
        List<Item> items = UtilStaticMethod.getItems(menu.getItems(),menu.list.getMeals(),menu.cookerType);
        if (!items.isEmpty()) {
            for (int k = 0; k < items.size(); k++) {
                guiGraphics.renderItem(items.get(k).getDefaultInstance(), i + 122 + k * 20, j + 13);
            }
            if (index < items.size()) {
                CookedMealItem cookedMealItem = (CookedMealItem) items.get(index);
                FoodTagEnum[] foodTagEnums = cookedMealItem.positiveTag;
                guiGraphics.drawString(font, Component.translatable("gui.mystias_izakaya.level").append(": " + cookedMealItem.level), i + 15, j + 10, black, false);
                guiGraphics.drawString(font, Component.translatable("gui.mystias_izakaya.cooking_time").append(": " + cookedMealItem.cookingTime), i + 15, j + 20, black, false);
                guiGraphics.drawString(font, Component.translatable("gui.mystias_izakaya.tags").append(":"), i + 15, j + 30, black, false);
                for (int i1 = 0; i1 < foodTagEnums.length; i1++) {
                    guiGraphics.drawString(font, Component.translatable("mystia_izakaya." + foodTagEnums[i1].name()), i + 15 + i1 * 25, j + 40, black, false);
                }
            }
        }
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
    }
}
