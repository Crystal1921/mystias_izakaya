package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.compat.touhou_little_maid.SeatPoiManager;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class PoiRegistry {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(Registries.POINT_OF_INTEREST_TYPE, MystiaIzakaya.MODID);

    public static final DeferredHolder<PoiType, PoiType> MYSTIAS_SEAT = POI_TYPES.register("mystias_seat", SeatPoiManager::getSeats);
}
