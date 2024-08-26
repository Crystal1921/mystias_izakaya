package com.crystal.mystia_izakaya.client.gui.menu;

import com.crystal.mystia_izakaya.client.blockEntity.GrillTE;
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
import org.jetbrains.annotations.NotNull;

public class GrillMenu extends AbstractCookMenu {
    private final ContainerLevelAccess access;

    public GrillMenu(int pContainerId, Inventory inventory, FriendlyByteBuf buf) {
        this(pContainerId, inventory, new SimpleContainer(6), (GrillTE) inventory.player.level().getBlockEntity(buf.readBlockPos()), new SimpleContainerData(2));
    }

    public GrillMenu(int pContainerId, Inventory inventory, Container container, GrillTE grillTE, ContainerData data) {
        super(MenuRegistry.Grill_Menu.get(), pContainerId, grillTE,data);
        this.access = ContainerLevelAccess.NULL;
        this.cookerType = CookerTypeEnum.Grill;
        addItems(container, grillTE);
        addPlayerInventory(inventory);
        addDataSlots(data);
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return stillValid(access, pPlayer, BlockRegistry.Grill.get());
    }
}
