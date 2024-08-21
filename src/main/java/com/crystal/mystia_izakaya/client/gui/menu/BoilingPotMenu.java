package com.crystal.mystia_izakaya.client.gui.menu;

import com.crystal.mystia_izakaya.client.blockEntity.BoilingPotTE;
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

import static com.crystal.mystia_izakaya.client.blockEntity.AbstractCookerTE.DATA_COUNT;

public class BoilingPotMenu extends AbstractCookMenu {
    private final ContainerLevelAccess access;
    public BoilingPotMenu(int pContainerId, Inventory inventory, FriendlyByteBuf buf) {
        this(pContainerId, inventory, new SimpleContainer(6), (BoilingPotTE) inventory.player.level().getBlockEntity(buf.readBlockPos()), new SimpleContainerData(DATA_COUNT));
    }

    public BoilingPotMenu(int pContainerId, Inventory inventory, Container container, BoilingPotTE boilingPotTE, ContainerData data) {
        super(MenuRegistry.Boiling_Pot_Menu.get(), pContainerId,boilingPotTE,data);
        this.access = ContainerLevelAccess.NULL;
        this.cookerType = CookerTypeEnum.Boiling_Pot;
        addItems(container);
        addPlayerInventory(inventory);
        this.addDataSlots(data);
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return stillValid(access,pPlayer, BlockRegistry.Boiling_Pot.get());
    }
}
