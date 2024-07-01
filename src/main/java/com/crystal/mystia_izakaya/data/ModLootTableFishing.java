package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.LootTableRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
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
                        .add(LootItem.lootTableItem(Items.NAME_TAG).setWeight(10))
                        .add(LootItem.lootTableItem(Items.SADDLE).setWeight(20))));
    }
}
