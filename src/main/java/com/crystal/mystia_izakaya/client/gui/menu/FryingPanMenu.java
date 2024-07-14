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
import net.minecraft.world.inventory.ContainerLevelAccess;

public class FryingPanMenu extends AbstractCookMenu {
    private final ContainerLevelAccess access;

    public FryingPanMenu(int pContainerId, Inventory inventory, FriendlyByteBuf buf) {
        this(pContainerId, inventory, new SimpleContainer(6),(FryingPanTE) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public FryingPanMenu(int pContainerId, Inventory inventory, Container container, FryingPanTE fryingPanTE) {
        super(MenuRegistry.Frying_Pan_Menu.get(), pContainerId,fryingPanTE);
        this.access = ContainerLevelAccess.NULL;
        this.cookerType = CookerTypeEnum.Frying_Pan;
        addItems(container);
        addPlayerInventory(inventory);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(access,pPlayer, BlockRegistry.Frying_Pan.get());
    }
}
