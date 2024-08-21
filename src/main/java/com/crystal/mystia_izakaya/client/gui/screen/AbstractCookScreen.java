package com.crystal.mystia_izakaya.client.gui.screen;

import com.crystal.mystia_izakaya.client.gui.menu.AbstractCookMenu;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.utils.UtilMethod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public abstract class AbstractCookScreen<T extends AbstractCookMenu> extends AbstractContainerScreen<T> {
    final int yellow = Color.YELLOW.getRGB();
    final int black = Color.BLACK.getRGB();
    final int positiveInColor = new Color(230, 180, 166).getRGB();
    final int positiveOutColor = new Color(157, 84, 55).getRGB();
    final int negativeInColor = new Color(93, 69, 58).getRGB();
    final int negativeOutColor = new Color(0, 0, 0).getRGB();
    final int minX = 120;
    final int minY = 10;
    final int maxX = 215;
    final int maxY = 90;
    ResourceLocation BACKGROUND = resourceLocation("textures/gui/cooker_bg.png");
    AbstractCookMenu abstractCookMenu;

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
        if (pMouseX > (i + minX) && pMouseX < (i + maxX) && pMouseY > (j + minY) && pMouseY < (j + maxY)) {
            if (this.minecraft != null && this.minecraft.player != null) {
                this.menu.clickMenuButton(this.minecraft.player, index);
            }
        }
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }


    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(BACKGROUND, i, j, 0, 0, this.imageWidth, this.imageHeight);
        renderCookProgress(guiGraphics, pMouseX, pMouseY, i, j);
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(guiGraphics, pMouseX, pMouseY);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        renderMealItem(guiGraphics, pMouseX, pMouseY, i, j);
    }

    protected void renderCookProgress(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int i, int j) {
        if (this.menu instanceof AbstractCookMenu cookMenu) {
            float cookTime = (float) cookMenu.getCookTime() / 20;
            float totalTime = (float) cookMenu.getTotalTime() / 20;
            float process = (totalTime - cookTime);
            if (cookTime > 0) {
                guiGraphics.drawString(font, Component.translatable("gui.mystia_izakaya.progress").append(" : " + String.format("%.2f / %.2f s", process, totalTime)), i + 120, j + 10, black, false);
                guiGraphics.drawString(font, Component.literal((int) ((1 - cookTime / totalTime) * 100) + " %"), i + 120, j + 25, black, false);
            }
        }
    }

    protected void renderMealItem(GuiGraphics guiGraphics, int pMouseX, int pMouseY, int i, int j) {
        if (this.menu instanceof AbstractCookMenu cookMenu) {
            ItemStack target = cookMenu.cookerTE.getItem(6);
            Item item = ItemStack.EMPTY.getItem();
            if (target.isEmpty()) {
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
                List<Item> items = UtilMethod.getItems(menu.getItems(), menu.list.getMeals(), menu.cookerType);
                if (!items.isEmpty()) {
                    for (int k = 0; k < items.size(); k++) {
                        guiGraphics.renderItem(items.get(k).getDefaultInstance(), i + 122 + k % 5 * 20, j + 13 + k / 5 * 20);
                    }
                    if (index < items.size()) {
                        item = items.get(index);
                    }
                }
            } else {
                item = target.getItem();
            }
            if (item instanceof CookedMealItem cookedMealItem) {
                ArrayList<String> negativeStrings = cookedMealItem.negativeTag.stream()
                        .map(foodTagEnum -> Component.translatable("mystia_izakaya." + foodTagEnum.name()).getString())
                        .collect(Collectors.toCollection(ArrayList::new));
                ArrayList<String> positiveStings = UtilMethod.getPositiveStings(cookMenu, cookedMealItem);
                guiGraphics.drawString(font, Component.translatable(cookedMealItem.getDescriptionId()), i + 15, j + 10, black, false);
                guiGraphics.drawString(font, Component.translatable("gui.mystia_izakaya.level").append(": " + cookedMealItem.level), i + 15, j + 20, black, false);
                guiGraphics.drawString(font, Component.translatable("gui.mystia_izakaya.cooking_time").append(": " + cookedMealItem.cookingTime), i + 15, j + 30, black, false);
                guiGraphics.drawString(font, Component.translatable("gui.mystia_izakaya.tags").append(":"), i + 15, j + 40, black, false);

                int stringLength = 0;
                int stringHeight = 0;
                for (int k = 0; k < positiveStings.size(); k++) {
                    //guiGraphics.fill(i + 15 + stringLength * 10 - 2, j + 50 + stringHeight * 10 - 1,i + 15 + stringLength * 10 + positiveStings.get(k).length() * 9 + 1, j + 50 + stringHeight * 10 + 9,positiveOutColor);
                    //guiGraphics.fill(i + 15 + stringLength * 10 - 1, j + 50 + stringHeight * 10,i + 15 + stringLength * 10 + positiveStings.get(k).length() * 9, j + 50 + stringHeight * 10 + 8,positiveInColor);
                    guiGraphics.drawString(font, positiveStings.get(k), i + 15 + stringLength * 10, j + 50 + stringHeight * 10, positiveOutColor, false);
                    stringLength += positiveStings.get(k).length();
                    if (positiveStings.size() > k + 1) {
                        if (stringLength + positiveStings.get(k + 1).length() > 10) {
                            stringLength = 0;
                            stringHeight++;
                        }
                    }
                }
                if (!negativeStrings.isEmpty()) {
                    if (stringLength + negativeStrings.getFirst().length() > 10) {
                        stringLength = 0;
                        stringHeight++;
                    }
                    for (int k = 0; k < negativeStrings.size(); k++) {
                        guiGraphics.drawString(font, negativeStrings.get(k), i + 15 + stringLength * 10, j + 50 + stringHeight * 10, negativeInColor, false);
                        stringLength += negativeStrings.get(k).length();
                        if (negativeStrings.size() > k + 1) {
                            if (stringLength + negativeStrings.get(k + 1).length() > 10) {
                                stringLength = 0;
                                stringHeight++;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void renderLabels(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
    }
}
