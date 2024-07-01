package com.crystal.mystia_izakaya.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LootTableRegistry {
    private static final Set<ResourceKey<LootTable>> LOCATIONS = new HashSet<>();
    private static final Set<ResourceKey<LootTable>> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);

    public static final ResourceKey<LootTable> FISHING = register("mystia/fishing");

    private static ResourceKey<LootTable> register(String pName) {
        return register(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace(pName)));
    }

    private static ResourceKey<LootTable> register(ResourceKey<LootTable> pName) {
        if (LOCATIONS.add(pName)) {
            return pName;
        } else {
            throw new IllegalArgumentException(pName.location() + " is already a registered built-in loot table");
        }
    }
}
