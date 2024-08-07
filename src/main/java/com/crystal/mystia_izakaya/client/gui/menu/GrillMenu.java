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
import net.minecraft.world.inventory.ContainerLevelAccess;
import org.jetbrains.annotations.NotNull;

public class GrillMenu extends AbstractCookMenu {
    private final ContainerLevelAccess access;

    public GrillMenu(int pContainerId, Inventory inventory, FriendlyByteBuf buf) {
        this(pContainerId, inventory, new SimpleContainer(6), (GrillTE) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public GrillMenu(int pContainerId, Inventory inventory, Container container, GrillTE blockEntity) {
        super(MenuRegistry.Grill_Menu.get(), pContainerId, blockEntity);
        this.access = ContainerLevelAccess.NULL;
        this.cookerType = CookerTypeEnum.Grill;
        addItems(container);
        addPlayerInventory(inventory);
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return stillValid(access, pPlayer, BlockRegistry.Grill.get());
    }
}
