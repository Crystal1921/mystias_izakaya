package com.crystal.mystia_izakaya.client.gui.screen;

import com.crystal.mystia_izakaya.client.gui.menu.SteamerMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SteamerScreen extends AbstractCookScreen<SteamerMenu>{
    public SteamerScreen(SteamerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
