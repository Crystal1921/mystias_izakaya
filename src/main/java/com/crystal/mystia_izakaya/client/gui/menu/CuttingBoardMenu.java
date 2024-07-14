package com.crystal.mystia_izakaya.client.gui.menu;

import com.crystal.mystia_izakaya.client.blockEntity.CuttingBoardTE;
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

public class CuttingBoardMenu extends AbstractCookMenu {
    private final ContainerLevelAccess access;

    public CuttingBoardMenu(int pContainerId, Inventory inventory, FriendlyByteBuf buf) {
        this(pContainerId, inventory, new SimpleContainer(6),(CuttingBoardTE) inventory.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public CuttingBoardMenu(int pContainerId, Inventory inventory, Container container, CuttingBoardTE cuttingBoardTE) {
        super(MenuRegistry.Cutting_Board_Menu.get(), pContainerId,cuttingBoardTE);
        this.access = ContainerLevelAccess.NULL;
        this.cookerType = CookerTypeEnum.Cutting_Board;
        addItems(container);
        addPlayerInventory(inventory);
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return stillValid(access,pPlayer, BlockRegistry.Cutting_Board.get());
    }
}
