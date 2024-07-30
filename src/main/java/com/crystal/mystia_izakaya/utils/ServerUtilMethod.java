package com.crystal.mystia_izakaya.utils;

import net.minecraft.world.item.Rarity;

public class ServerUtilMethod {
    public static Rarity getRarity(int level) {
        return switch (level) {
            case 2 -> Rarity.UNCOMMON;
            case 3 -> Rarity.RARE;
            case 4 -> Rarity.EPIC;
            case 5 -> Rarity.valueOf("MYSTIA_IZAKAYA_LEGEND");
            default -> Rarity.COMMON;
        };
    }
}
