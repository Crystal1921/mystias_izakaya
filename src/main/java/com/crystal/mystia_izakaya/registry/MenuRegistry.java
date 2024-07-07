package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.gui.menu.GrillMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MenuRegistry {
    public static final DeferredRegister<MenuType<?>> MENU_TYPE = DeferredRegister.create(Registries.MENU, MystiaIzakaya.MODID);
    public static final Supplier<MenuType<GrillMenu>> Grill_Menu = MENU_TYPE.register("grill_menu", () -> new MenuType<>(GrillMenu::new, FeatureFlags.DEFAULT_FLAGS));
}
