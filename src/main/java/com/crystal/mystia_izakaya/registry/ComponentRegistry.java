package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.component.CookerTypeComponent;
import com.crystal.mystia_izakaya.component.FoodTagComponent;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ComponentRegistry {
    public static final DeferredRegister.DataComponents REGISTRAR = DeferredRegister.createDataComponents(MystiaIzakaya.MODID);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<FoodTagComponent>> FOOD_TAG = REGISTRAR.registerComponentType(
            "food_tags",
            builder -> builder
                    .persistent(FoodTagComponent.CODEC)
                    .networkSynchronized(FoodTagComponent.CODEC_STREAM)
    );
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CookerTypeComponent>> COOKER = REGISTRAR.registerComponentType(
            "cooker_type",
            builder -> builder
                    .persistent(CookerTypeComponent.CODEC)
                    .networkSynchronized(CookerTypeComponent.CODEC_STREAM)
    );
}
