package com.crystal.mystia_izakaya.render.overlay;

import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class cookerListOverlay implements LayeredDraw.Layer{
    @Override
    public void render(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker) {
        Minecraft minecraft = Minecraft.getInstance();
        Options options = minecraft.options;
        Player player = minecraft.player;
        if (player == null || options.hideGui) {
            return;
        }
        if (player.getInventory().getArmor(3).is(ItemRegistry.MystiasHat)) {

        }
    }
}
