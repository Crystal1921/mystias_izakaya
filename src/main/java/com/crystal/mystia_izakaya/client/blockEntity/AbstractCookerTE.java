package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractCookerTE extends RandomizableContainerBlockEntity {
    NonNullList<ItemStack> items = NonNullList.withSize(6, ItemStack.EMPTY);
    public int cookTime;
    public CookedMealItem targetMeal;

    protected AbstractCookerTE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, AbstractCookerTE pBlockEntity) {
        boolean lit = pBlockEntity.isCook();
        CookedMealItem cookedMealItem = pBlockEntity.targetMeal;
        boolean flag = false;
        if (lit) {
            pBlockEntity.cookTime--;
        }

        if (lit != pBlockEntity.isCook()) {
            flag = true;
            pState = pState.setValue(AbstractFurnaceBlock.LIT, pBlockEntity.isCook());
            pLevel.setBlock(pPos, pState, 3);
        }

        if (flag) {
            setChanged(pLevel, pPos, pState);
        }
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(pTag)) {
            ContainerHelper.loadAllItems(pTag, this.items, pRegistries);
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        if (!this.trySaveLootTable(pTag)) {
            ContainerHelper.saveAllItems(pTag, this.items, pRegistries);
        }
    }

    private boolean isCook() {
        return this.cookTime > 0;
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> pItems) {
        this.items = pItems;
    }

    @Override
    public int getContainerSize() {
        return 6;
    }
}
