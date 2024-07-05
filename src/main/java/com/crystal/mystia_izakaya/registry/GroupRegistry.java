package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.registry.items.IngredientItem;
import com.crystal.mystia_izakaya.registry.items.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GroupRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MystiaIzakaya.MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("mystias_izakaya", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mystias_izakaya"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemRegistry.MystiaFishingRod.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ItemRegistry.MystiaFishingRod.get());
                output.accept(IngredientItem.Trout.get());
                output.accept(IngredientItem.Lamprey.get());
                output.accept(IngredientItem.Salmon.get());
                output.accept(IngredientItem.Tuna.get());
                output.accept(IngredientItem.Premium_Tuna.get());
                output.accept(IngredientItem.Pufferfish.get());
                output.accept(IngredientItem.Shrimp.get());
                output.accept(IngredientItem.Octopus.get());
                output.accept(IngredientItem.Sea_Urchin.get());
                output.accept(IngredientItem.Crab.get());
            }).build());

    public static void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(BlockRegistry.EXAMPLE_BLOCK_ITEM);
    }
}
