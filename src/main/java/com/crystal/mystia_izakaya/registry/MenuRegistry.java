package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.gui.menu.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MenuRegistry {
    public static final DeferredRegister<MenuType<?>> MENU_TYPE = DeferredRegister.create(Registries.MENU, MystiaIzakaya.MODID);
    public static final Supplier<MenuType<GrillMenu>> Grill_Menu = MENU_TYPE.register("grill", () -> IMenuTypeExtension.create(GrillMenu::new));
    public static final Supplier<MenuType<BoilingPotMenu>> Boiling_Pot_Menu = MENU_TYPE.register("boiling_pot", () -> IMenuTypeExtension.create(BoilingPotMenu::new));
    public static final Supplier<MenuType<CuttingBoardMenu>> Cutting_Board_Menu = MENU_TYPE.register("cutting_board", () -> IMenuTypeExtension.create(CuttingBoardMenu::new));
    public static final Supplier<MenuType<FryingPanMenu>> Frying_Pan_Menu = MENU_TYPE.register("frying_pan", () -> IMenuTypeExtension.create(FryingPanMenu::new));
    public static final Supplier<MenuType<SteamerMenu>> Steamer_Menu = MENU_TYPE.register("steamer", () -> IMenuTypeExtension.create(SteamerMenu::new));
}
