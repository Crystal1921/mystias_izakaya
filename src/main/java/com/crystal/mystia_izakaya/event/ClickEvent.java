package com.crystal.mystia_izakaya.event;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.gui.screen.RecipeBookScreen;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = MystiaIzakaya.MODID, value = Dist.CLIENT)
public class ClickEvent {
    @SubscribeEvent
    public static void onClickEvent(PlayerInteractEvent.RightClickItem event) {
        if (event.getLevel().isClientSide()) {
            Player player = event.getEntity();
            ItemStack stack = player.getItemInHand(event.getHand());
            if (stack.is(ItemRegistry.RecipeBook)) {
                if (player.isCrouching()) {
                    player.setItemInHand(InteractionHand.MAIN_HAND,ItemRegistry.RecipeBook.get().getDefaultInstance());
                } else {
                    Minecraft.getInstance().setScreen(new RecipeBookScreen(stack));
                }
            }
        }
    }
}
