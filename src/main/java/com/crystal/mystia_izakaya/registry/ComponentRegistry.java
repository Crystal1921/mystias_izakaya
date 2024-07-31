package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.component.FoodTagComponent;
import com.crystal.mystia_izakaya.component.TargetItemComponent;
import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ComponentRegistry {
    public static final DeferredRegister.DataComponents REGISTRAR = DeferredRegister.createDataComponents(MystiaIzakaya.MODID);
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<FoodTagComponent>> FOOD_TAG = REGISTRAR.registerComponentType(
            "food_tags",
            builder -> builder
                    .persistent(FoodTagComponent.CODEC)
                    .networkSynchronized(FoodTagComponent.STREAM_CODEC)
    );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<TargetItemComponent>> TARGET_ITEM = REGISTRAR.registerComponentType(
            "target_item",
            builder -> builder
                    .persistent(TargetItemComponent.CODEC)
                    .networkSynchronized(TargetItemComponent.STREAM_CODEC)
    );
}
