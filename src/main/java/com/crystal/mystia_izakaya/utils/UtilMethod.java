package com.crystal.mystia_izakaya.utils;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import net.minecraft.resources.ResourceLocation;

public class UtilMethod {
    public static ResourceLocation resourceLocation(String name) {
        return ResourceLocation.parse(MystiaIzakaya.MODID + ":" + name);
    }
}
