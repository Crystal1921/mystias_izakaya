package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.client.block.AbstractHorizontalBlock;
import com.crystal.mystia_izakaya.component.FoodTagComponent;
import com.crystal.mystia_izakaya.network.MealInfoPacket;
import com.crystal.mystia_izakaya.registry.ComponentRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import com.crystal.mystia_izakaya.utils.MealList;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class AbstractCookerTE extends RandomizableContainerBlockEntity {
    private final FoodTagEnum[] foodTagEnums = MealList.getInstance().getFood();
    public CookerTypeEnum cookerTypeEnum;
    public int cookTime = 0;
    public boolean isCook = false;
    public boolean lit = false;
    public ArrayList<FoodTagEnum> foodTags = new ArrayList<>();
    NonNullList<ItemStack> items = NonNullList.withSize(7, ItemStack.EMPTY);

    protected AbstractCookerTE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, AbstractCookerTE pBlockEntity) {
        if (pBlockEntity.lit) {
            pBlockEntity.lit = false;
            pBlockEntity.isCook = true;
            for (int i = 0; i < 5; i++) {
                pBlockEntity.items.set(i, ItemStack.EMPTY);
            }
            ItemStack stack = pBlockEntity.items.get(6);
            IntList list = new IntArrayList();
            if (!pBlockEntity.foodTags.isEmpty()) {
                pBlockEntity.foodTags.forEach(foodTagEnum -> list.add(foodTagEnum.ordinal()));
                stack.set(ComponentRegistry.FOOD_TAG, new FoodTagComponent(list));
            }
            pBlockEntity.setItem(6, stack);
            pState = pState.setValue(AbstractHorizontalBlock.LIT, true);
            pLevel.setBlock(pPos, pState, 3);
        }
        if (pBlockEntity.isCook) {
            pBlockEntity.cookTime--;
            if (pBlockEntity.cookTime <= 0) {
                pBlockEntity.isCook = false;
                pBlockEntity.foodTags = new ArrayList<>();
                pState = pState.setValue(AbstractHorizontalBlock.LIT, false);
                pLevel.setBlock(pPos, pState, 3);
                pBlockEntity.items.set(5, pBlockEntity.getItem(6));
                pBlockEntity.setItem(6, ItemStack.EMPTY);
                setChanged(pLevel, pPos, pState);
                PacketDistributor.sendToAllPlayers(
                        new MealInfoPacket(0,
                                pBlockEntity.items.stream().map(ItemStack::getItem).collect(Collectors.toCollection(ArrayList::new)),
                                pPos,
                                new byte[]{0}));
            }
        }
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(pTag)) {
            ContainerHelper.loadAllItems(pTag, this.items, pRegistries);
            pTag.putInt("CookTime", this.cookTime);
            pTag.putBoolean("IsCook", this.isCook);
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        if (!this.trySaveLootTable(pTag)) {
            ContainerHelper.saveAllItems(pTag, this.items, pRegistries);
            pTag.putInt("CookTime", this.cookTime);
            pTag.putBoolean("IsCook", this.isCook);
        }
    }

    @Override
    @NotNull
    public NonNullList<ItemStack> getItems() {
        return items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> pItems) {
        this.items = pItems;
    }

    public void setItems(ArrayList<Item> pItems) {
        for (int i = 0; i < pItems.size(); i++) {
            this.setItem(i, pItems.get(i).getDefaultInstance());
        }
    }

    @Override
    public int getContainerSize() {
        return 7;
    }

    public void setFoodTags(byte[] tags) {
        if (tags != null) {
            for (byte tag : tags) {
                this.foodTags.add(foodTagEnums[tag]);
            }
        }
    }
}
