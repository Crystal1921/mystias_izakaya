package com.crystal.mystia_izakaya.client.item.tooltip;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class MystiaTooltip implements ClientTooltipComponent {
    private final ItemStack stack;

    public MystiaTooltip(RecordMealTooltip tooltip) {
        this.stack = tooltip.itemStack();
    }

    @Override
    public int getHeight() {
        return 20;
    }

    @Override
    public int getWidth(@NotNull Font pFont) {
        return 20;
    }

    @Override
    public void renderImage(@NotNull Font font, int pX, int pY, @NotNull GuiGraphics pGuiGraphics) {
        pGuiGraphics.renderItem(this.stack,pX + 10,pY);
    }
}
