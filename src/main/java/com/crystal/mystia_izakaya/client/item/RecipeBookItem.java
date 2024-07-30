package com.crystal.mystia_izakaya.client.item;

import com.crystal.mystia_izakaya.client.gui.screen.RecipeBookScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class RecipeBookItem extends Item {
    public RecipeBookItem() {
        super(new Item.Properties().rarity(Rarity.COMMON).stacksTo(1));
    }
}
