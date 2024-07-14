package com.crystal.mystia_izakaya.utils;

import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public enum CookerTypeEnum {
    //煮锅
    Boiling_Pot(ItemRegistry.Boiling_Pot.get()),
    //烤架
    Grill(ItemRegistry.Grill_Block.get()),
    //油锅
    Frying_Pan(ItemRegistry.Frying_Pan.get()),
    //蒸锅
    Steamer(ItemRegistry.Steamer.get()),
    //料理台
    Cutting_Board(ItemRegistry.Cutting_Board.get()),
    //空
    EMPTY(ItemStack.EMPTY.getItem());

    final Item item;
    public Item getItem() {
        return item;
    }
    CookerTypeEnum(Item itemStack) {
        this.item = itemStack;
    }
}
