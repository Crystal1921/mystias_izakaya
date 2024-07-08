package com.crystal.mystia_izakaya.client.gui.menu;

import com.crystal.mystia_izakaya.registry.BlockRegistry;
import com.crystal.mystia_izakaya.registry.MenuRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;

public class SteamerMenu extends AbstractCookMenu {
    private final ContainerLevelAccess access;

    public SteamerMenu(int pContainerId, Inventory inventory) {
        this(pContainerId, inventory, new SimpleContainer(6));
    }

    public SteamerMenu(int pContainerId, Inventory inventory, Container container) {
        super(MenuRegistry.Steamer_Menu.get(), pContainerId);
        this.access = ContainerLevelAccess.NULL;
        this.cookerType = CookerTypeEnum.Steamer;
        addItems(container);
        addPlayerInventory(inventory);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(access,pPlayer, BlockRegistry.Steamer.get());
    }
}
