package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.behavior.PositionTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;
import java.util.function.Supplier;

public class MemoryTypeRegister {
    public static final DeferredRegister<MemoryModuleType<?>> MEMORY_MODULE_TYPES = DeferredRegister.create(Registries.MEMORY_MODULE_TYPE, MystiaIzakaya.MODID);
    public static Supplier<MemoryModuleType<PositionTracker>> TARGET_POS = MEMORY_MODULE_TYPES.register("seat_pos", () -> new MemoryModuleType<>(Optional.empty()));

}
