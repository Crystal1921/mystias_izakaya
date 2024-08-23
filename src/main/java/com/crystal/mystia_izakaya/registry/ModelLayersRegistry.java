package com.crystal.mystia_izakaya.registry;

import net.minecraft.client.model.geom.ModelLayerLocation;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public class ModelLayersRegistry {
    public static final ModelLayerLocation MYSTIAS_HAT;

    static {
        MYSTIAS_HAT = register("mystias_hat");
    }

    private static ModelLayerLocation register(String name) {
        return new ModelLayerLocation(resourceLocation(name), name);
    }
}
