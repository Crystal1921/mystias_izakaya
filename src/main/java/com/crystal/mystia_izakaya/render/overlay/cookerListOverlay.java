package com.crystal.mystia_izakaya.render.overlay;

import com.crystal.mystia_izakaya.client.blockEntity.AbstractCookerTE;
import com.crystal.mystia_izakaya.registry.ComponentRegistry;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FastColor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class cookerListOverlay implements LayeredDraw.Layer {
    public static final int BLACK = Color.BLACK.getRGB();
    public static final int WHITE = FastColor.ARGB32.color(128,Color.WHITE.getRGB());
    public static final int PADDING = 6;
    private final List<CookerInfo> containers = new ArrayList<>();

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker) {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel world = minecraft.level;
        Font font = minecraft.font;
        Options options = minecraft.options;
        Player player = minecraft.player;
        if (player == null || world == null || options.hideGui) {
            return;
        }
        ItemStack stack = player.getInventory().getArmor(3);
        if (stack.is(ItemRegistry.MystiasHat)) {
            if (world.dayTime() % 5 == 0) {
                var component = stack.get(ComponentRegistry.COOKER_POS);
                if (component != null) {
                    containers.clear();
                    List<BlockPos> blockPosList = component.posList();
                    blockPosList.forEach(pos -> {
                        BlockEntity be = world.getBlockEntity(pos);
                        BlockState state = world.getBlockState(pos);
                        if (be instanceof AbstractCookerTE cookerTE) {
                            ItemStack cooker = world.getBlockState(pos).getBlock().asItem().getDefaultInstance();
                            ItemStack cookedMeal = cookerTE.getTargetItem();
                            float progress = (float) cookerTE.cookTime / cookerTE.cookTotal;
                            boolean isLit = state.getValue(BlockStateProperties.LIT);
                            containers.add(new CookerInfo(cooker, cookedMeal, progress, isLit));
                        }
                    });
                }
            }

            for (int i = 0; i < containers.size(); i++) {
                CookerInfo cookerInfo = containers.get(i);
                ItemStack cooker = cookerInfo.cooker;
                ItemStack cookedMeal = cookerInfo.cookedMeal;
                if (!cooker.isEmpty()) {
                    int height = i * 18 + PADDING;
                    guiGraphics.renderItem(cooker, 6, height - 6);
                    guiGraphics.renderItem(cookedMeal, 24, height - 4);
                    guiGraphics.fill(6,height - 4,80,height + 12,WHITE);
                    if (cookerInfo.isLit){
                        guiGraphics.drawString(font, Component.literal((int) ((1 - cookerInfo.progress) * 100) + " %"), 48, height, BLACK, false);
                    }
                }

            }
        }
    }

    private record CookerInfo(ItemStack cooker, ItemStack cookedMeal, float progress, boolean isLit) {
    }
}
