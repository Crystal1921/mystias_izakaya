package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.entity.MystiaFishingHook;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, MystiaIzakaya.MODID);
    public static final Supplier<EntityType<MystiaFishingHook>> Mystia_Fishing_Hook = ENTITY_TYPES.register("mystia_fishing_hook",
            () -> EntityType.Builder.of((EntityType<MystiaFishingHook> type, Level level) -> new MystiaFishingHook(type, level),MobCategory.MISC).sized(0.2F,0.2F).build("mystia_fishing_hook"));
}
