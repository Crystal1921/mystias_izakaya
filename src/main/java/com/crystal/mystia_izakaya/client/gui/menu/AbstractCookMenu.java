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
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.crystal.mystia_izakaya.data.ModTagItem.FOOD_INGREDIENTS;

public abstract class AbstractCookMenu extends AbstractContainerMenu {
    protected static final int INV_SIZE = 36;
    public final MealList list = MealList.getInstance();
    public final AbstractCookerTE cookerTE;
    protected final int INV_START = 6;
    public CookerTypeEnum cookerType = CookerTypeEnum.EMPTY;

    protected AbstractCookMenu(@Nullable MenuType<?> pMenuType, int pContainerId, AbstractCookerTE pCookerTE) {
        super(pMenuType, pContainerId);
        this.cookerTE = pCookerTE;
    }

    public boolean clickMenuButton(@NotNull Player pPlayer, int pId) {
        List<Item> items = UtilStaticMethod.getItems(this.getItems(), this.list.getMeals(), this.cookerType);
        boolean isCook = pPlayer.level().getBlockState(this.cookerTE.getBlockPos()).getValue(AbstractFurnaceBlock.LIT);
        if (pId < items.size() && !isCook && this.getItems().get(5).isEmpty()) {
            CookedMealItem item = (CookedMealItem) items.get(pId);
            this.cookerTE.getItems().clear();
            this.cookerTE.setItem(6, item.getDefaultInstance());
            PacketDistributor.sendToServer(new MealInfoPacket((int) item.cookingTime * 20, cookerTE.getItems().stream().map(ItemStack::getItem).collect(Collectors.toCollection(ArrayList::new)), cookerTE.getBlockPos()));
            pPlayer.closeContainer();
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

    public Stream<ItemStack> getIngredientStream() {
        return this.getItems().stream().limit(5);
    }

    public boolean isFull() {
        return this.getItems().stream().limit(5).filter(itemStack -> !itemStack.isEmpty()).toList().size() == 5;
    }
}
