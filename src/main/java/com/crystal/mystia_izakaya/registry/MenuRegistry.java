package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.gui.menu.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MenuRegistry {
    public static final DeferredRegister<MenuType<?>> MENU_TYPE = DeferredRegister.create(Registries.MENU, MystiaIzakaya.MODID);
    public static final Supplier<MenuType<GrillMenu>> Grill_Menu = MENU_TYPE.register("grill", () -> new MenuType<>(GrillMenu::new, FeatureFlags.DEFAULT_FLAGS));
    public static final Supplier<MenuType<BoilingPotMenu>> Boiling_Pot_Menu = MENU_TYPE.register("boiling_pot", () -> new MenuType<>(BoilingPotMenu::new, FeatureFlags.DEFAULT_FLAGS));
    public static final Supplier<MenuType<CuttingBoardMenu>> Cutting_Board_Menu = MENU_TYPE.register("cutting_board", () -> new MenuType<>(CuttingBoardMenu::new, FeatureFlags.DEFAULT_FLAGS));
    public static final Supplier<MenuType<FryingPanMenu>> Frying_Pan_Menu = MENU_TYPE.register("frying_pan", () -> new MenuType<>(FryingPanMenu::new, FeatureFlags.DEFAULT_FLAGS));
    public static final Supplier<MenuType<SteamerMenu>> Steamer_Menu = MENU_TYPE.register("steamer", () -> new MenuType<>(SteamerMenu::new, FeatureFlags.DEFAULT_FLAGS));
}
