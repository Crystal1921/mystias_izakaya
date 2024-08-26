package com.crystal.mystia_izakaya.client.gui.menu;

import com.crystal.mystia_izakaya.client.blockEntity.FryingPanTE;
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

public class FryingPanMenu extends AbstractCookMenu {
    private final ContainerLevelAccess access;

    public FryingPanMenu(int pContainerId, Inventory inventory, FriendlyByteBuf buf) {
        this(pContainerId, inventory, new SimpleContainer(6),(FryingPanTE) inventory.player.level().getBlockEntity(buf.readBlockPos()), new SimpleContainerData(2));
    }

    public FryingPanMenu(int pContainerId, Inventory inventory, Container container, FryingPanTE fryingPanTE, ContainerData data) {
        super(MenuRegistry.Frying_Pan_Menu.get(), pContainerId,fryingPanTE,data);
        this.access = ContainerLevelAccess.NULL;
        this.cookerType = CookerTypeEnum.Frying_Pan;
        addItems(container, fryingPanTE);
        addPlayerInventory(inventory);
        addDataSlots(data);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(access,pPlayer, BlockRegistry.Frying_Pan.get());
    }
}
