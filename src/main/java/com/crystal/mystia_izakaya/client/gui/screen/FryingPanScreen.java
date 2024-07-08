package com.crystal.mystia_izakaya.client.gui.screen;

import com.crystal.mystia_izakaya.client.gui.menu.FryingPanMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class FryingPanScreen extends AbstractCookScreen<FryingPanMenu>{
    public FryingPanScreen(FryingPanMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }
}
