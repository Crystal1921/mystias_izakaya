package com.crystal.mystia_izakaya.utils;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Style;

import java.util.function.UnaryOperator;

import static com.crystal.mystia_izakaya.utils.UtilStaticMethod.prefix;

public class RarityEnumExtend {
    public static Object MystiasRarity(int idx, Class<?> type) {
        return type.cast(switch (idx) {
            case 0 -> -1;
            case 1 -> prefix("legend");
            case 2 -> (UnaryOperator<Style>) style -> style.withColor(ChatFormatting.GOLD);
            default -> throw new IllegalArgumentException("Unexpected parameter index: " + idx);
        });
    }
}
