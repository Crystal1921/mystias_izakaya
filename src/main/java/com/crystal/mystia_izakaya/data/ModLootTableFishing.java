package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.items.IngredientItem;
import com.crystal.mystia_izakaya.registry.LootTableRegistry;
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
                        .add(LootItem.lootTableItem(IngredientItem.Trout).setWeight(8))
                        .add(LootItem.lootTableItem(IngredientItem.Lamprey).setWeight(14))
                        .add(LootItem.lootTableItem(IngredientItem.Salmon).setWeight(24))
                        .add(LootItem.lootTableItem(IngredientItem.Tuna).setWeight(30))
                        .add(LootItem.lootTableItem(IngredientItem.Premium_Tuna).setWeight(34))
                        .add(LootItem.lootTableItem(IngredientItem.Pufferfish).setWeight(42))
                        .add(LootItem.lootTableItem(IngredientItem.Shrimp).setWeight(30))
                        .add(LootItem.lootTableItem(IngredientItem.Octopus).setWeight(12))
                        .add(LootItem.lootTableItem(IngredientItem.Sea_Urchin).setWeight(18))
                        .add(LootItem.lootTableItem(IngredientItem.Crab).setWeight(10))));
    }
}
