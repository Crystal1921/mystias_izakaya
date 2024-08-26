package com.crystal.mystia_izakaya.client.gui.menu;

import com.crystal.mystia_izakaya.client.blockEntity.SteamerTE;
import com.crystal.mystia_izakaya.registry.BlockRegistry;
import com.crystal.mystia_izakaya.registry.MenuRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.SimpleContainerData;

public class SteamerMenu extends AbstractCookMenu {
    private final ContainerLevelAccess access;

    public SteamerMenu(int pContainerId, Inventory inventory, FriendlyByteBuf buf) {
        this(pContainerId, inventory, new SimpleContainer(6),(SteamerTE) inventory.player.level().getBlockEntity(buf.readBlockPos()), new SimpleContainerData(2));
    }

    public SteamerMenu(int pContainerId, Inventory inventory, Container container, SteamerTE steamerTE, ContainerData data) {
        super(MenuRegistry.Steamer_Menu.get(), pContainerId,steamerTE,data);
        this.access = ContainerLevelAccess.NULL;
        this.cookerType = CookerTypeEnum.Steamer;
        addItems(container, steamerTE);
        addPlayerInventory(inventory);
        addDataSlots(data);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(access,pPlayer, BlockRegistry.Steamer.get());
    }
}
