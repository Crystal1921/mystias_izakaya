package com.crystal.mystia_izakaya.utils;

import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

import static net.minecraft.world.Containers.dropItemStack;

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

    /**
     * @param inventory 玩家背包
     * @param cookedMealItem 目标菜肴
     * @return 返回玩家身上是否有所有的菜肴原材料
     */
    public static boolean isIngredientsMatch(Inventory inventory, CookedMealItem cookedMealItem){
        for (int i = 0; i < cookedMealItem.ingredients.length; i++) {
            Item item = cookedMealItem.ingredients[i];
            if (!inventory.contains(item.getDefaultInstance())) return false;
        }
        return true;
    }

    public static void dropContents(Level pLevel, BlockPos pPos, Container pInventory, int num) {
        dropContents(pLevel, pPos.getX(), pPos.getY(), pPos.getZ(), pInventory, num);
    }

    private static void dropContents(Level pLevel, double pX, double pY, double pZ, Container pInventory, int num) {
        for (int i = 0; i < num; i++) {
            dropItemStack(pLevel, pX, pY, pZ, pInventory.getItem(i));
        }
    }
}
