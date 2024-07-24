package com.crystal.mystia_izakaya.dataGen;

import com.crystal.mystia_izakaya.registry.LootTableRegistry;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;

import java.util.function.BiConsumer;

public class ModLootTableFishing implements LootTableSubProvider {

    public ModLootTableFishing(HolderLookup.Provider provider) {
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> consumer) {
        consumer.accept(LootTableRegistry.FISHING
                ,LootTable.lootTable().withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(ItemRegistry.Trout).setWeight(8))
                        .add(LootItem.lootTableItem(ItemRegistry.Lamprey).setWeight(14))
                        .add(LootItem.lootTableItem(ItemRegistry.Salmon).setWeight(24))
                        .add(LootItem.lootTableItem(ItemRegistry.Tuna).setWeight(30))
                        .add(LootItem.lootTableItem(ItemRegistry.Premium_Tuna).setWeight(34))
                        .add(LootItem.lootTableItem(ItemRegistry.Pufferfish).setWeight(42))
                        .add(LootItem.lootTableItem(ItemRegistry.Shrimp).setWeight(30))
                        .add(LootItem.lootTableItem(ItemRegistry.Octopus).setWeight(12))
                        .add(LootItem.lootTableItem(ItemRegistry.Sea_Urchin).setWeight(18))
                        .add(LootItem.lootTableItem(ItemRegistry.Crab).setWeight(10))));
    }
}
