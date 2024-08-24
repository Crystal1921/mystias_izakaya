package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.component.CookerPosComponent;
import com.crystal.mystia_izakaya.component.FoodTagComponent;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ComponentRegistry {
    public static final DeferredRegister.DataComponents REGISTRAR = DeferredRegister.createDataComponents(MystiaIzakaya.MODID);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<FoodTagComponent>> FOOD_TAG = REGISTRAR.registerComponentType(
            "food_tags",
            builder -> builder.persistent(FoodTagComponent.CODEC).networkSynchronized(FoodTagComponent.STREAM_CODEC)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> TARGET_ITEM = REGISTRAR.registerComponentType(
            "target_item",
            builder -> builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.VAR_INT)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CookerPosComponent>> COOKER_POS = REGISTRAR.registerComponentType(
            "cooker_pos",
            builder -> builder.persistent(CookerPosComponent.CODEC).networkSynchronized(CookerPosComponent.STREAM_CODEC)
    );
}
