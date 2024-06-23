package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.item.MystiaFishingRod;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MystiaIzakaya.MODID);
    public static final DeferredItem<Item> MystiaFishingRod = ITEMS.register("mystia_fishing_rod", MystiaFishingRod::new);
}
