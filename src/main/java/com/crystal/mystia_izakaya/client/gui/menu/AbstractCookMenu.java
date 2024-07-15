package com.crystal.mystia_izakaya.client.gui.menu;

import com.crystal.mystia_izakaya.client.blockEntity.AbstractCookerTE;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.network.MealInfoPacket;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import com.crystal.mystia_izakaya.utils.MealList;
import com.crystal.mystia_izakaya.utils.UtilStaticMethod;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.crystal.mystia_izakaya.data.ModTagItem.FOOD_INGREDIENTS;

public abstract class AbstractCookMenu extends AbstractContainerMenu {
    protected static final int INV_SIZE = 36;
    protected final int INV_START = 6;
    public CookerTypeEnum cookerType = CookerTypeEnum.EMPTY;
    public MealList list = MealList.getInstance();
    protected AbstractCookerTE cookerTE;

    protected AbstractCookMenu(@Nullable MenuType<?> pMenuType, int pContainerId, AbstractCookerTE pCookerTE) {
        super(pMenuType, pContainerId);
        this.cookerTE = pCookerTE;
    }

    public boolean clickMenuButton(@NotNull Player pPlayer, int pId) {
        List<Item> items = UtilStaticMethod.getItems(this.getItems(), this.list.getMeals(), this.cookerType);
        if (pId < items.size()) {
            System.out.println(pId);
            CookedMealItem targetMeal = (CookedMealItem) items.get(pId);
            this.cookerTE.cookTime = (int) (targetMeal.cookingTime * 20);
            this.cookerTE.targetMeal = targetMeal;
            PacketDistributor.sendToServer(new MealInfoPacket((int) (targetMeal.cookingTime * 20),targetMeal.builtInRegistryHolder(),cookerTE.getBlockPos()));
            return true;
        }
        return false;
    }

    protected void addItems(Container items) {
        for (int i = 0; i < 5; ++i) {
            addSlot(new Slot(items, i, 17 + i * 25, 110) {
                @Override
                public int getMaxStackSize(@NotNull ItemStack pStack) {
                    return 1;
                }

                @Override
                public boolean mayPlace(@NotNull ItemStack pStack) {
                    return pStack.getTags().toList().contains(FOOD_INGREDIENTS);
                }
            });
        }
        addSlot(new Slot(items, 5, 180, 110) {
            @Override
            public boolean mayPlace(@NotNull ItemStack pStack) {
                return false;
            }
        });
    }

    protected void addPlayerInventory(Inventory inv) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 9; j++)
                addSlot(new Slot(inv, j + i * 9 + 9, 36 + j * 18, 137 + i * 18));
        for (int i = 0; i < 9; i++)
            addSlot(new Slot(inv, i, 36 + i * 18, 195));
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack slotStack = slot.getItem();
            itemStack = slotStack.copy();
            if (index < INV_START) {
                if (!this.moveItemStackTo(slotStack, INV_START, INV_SIZE + INV_START, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(slotStack, itemStack);
            } else {
                if (index < INV_SIZE + INV_START && !this.moveItemStackTo(slotStack, 0, INV_START, false))
                    return ItemStack.EMPTY;
            }
            if (slotStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (slotStack.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(playerIn, slotStack);
        }
        return itemStack;
    }
}
