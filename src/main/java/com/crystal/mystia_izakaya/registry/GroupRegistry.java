package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
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
            }).build());

    public static void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(BlockRegistry.EXAMPLE_BLOCK_ITEM);
    }
}
