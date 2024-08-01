package com.crystal.mystia_izakaya.dataGen;

import com.crystal.mystia_izakaya.client.item.SeaFoodItem;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.registry.LootTableRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.function.BiConsumer;

public class ModLootTableFishing implements LootTableSubProvider {

    public ModLootTableFishing(HolderLookup.Provider provider) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> consumer) {
        consumer.accept(LootTableRegistry.FISHING
                , LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ItemRegistry.Trout).setWeight(getFishWeight(ItemRegistry.Trout)))
                        .add(LootItem.lootTableItem(ItemRegistry.Lamprey).setWeight(getFishWeight(ItemRegistry.Lamprey)))
                        .add(LootItem.lootTableItem(ItemRegistry.Salmon).setWeight(getFishWeight(ItemRegistry.Salmon)))
                        .add(LootItem.lootTableItem(ItemRegistry.Tuna).setWeight(getFishWeight(ItemRegistry.Tuna)))
                        .add(LootItem.lootTableItem(ItemRegistry.Premium_Tuna).setWeight(getFishWeight(ItemRegistry.Premium_Tuna)))
                        .add(LootItem.lootTableItem(ItemRegistry.Pufferfish).setWeight(getFishWeight(ItemRegistry.Pufferfish)))
                        .add(LootItem.lootTableItem(ItemRegistry.Shrimp).setWeight(getFishWeight(ItemRegistry.Shrimp)))
                        .add(LootItem.lootTableItem(ItemRegistry.Octopus).setWeight(getFishWeight(ItemRegistry.Octopus)))
                        .add(LootItem.lootTableItem(ItemRegistry.Sea_Urchin).setWeight(getFishWeight(ItemRegistry.Sea_Urchin)))
                        .add(LootItem.lootTableItem(ItemRegistry.Crab).setWeight(getFishWeight(ItemRegistry.Crab)))));
    }

    private int getFishWeight(DeferredItem<Item> item) {
        SeaFoodItem seaFoodItem = (SeaFoodItem) item.get();
        return (6 - seaFoodItem.getLevel());
    }
}
