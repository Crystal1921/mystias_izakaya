package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.blockEntity.GrillBlockTE;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MystiaIzakaya.MODID);
    public static final Supplier<BlockEntityType<GrillBlockTE>> GRILL = BLOCK_ENTITY_TYPES.register("grill", () -> BlockEntityType.Builder.of(GrillBlockTE::new,BlockRegistry.Grill.value()).build(null));
}
