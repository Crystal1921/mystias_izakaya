package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GroupRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MystiaIzakaya.MODID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("mystias_izakaya", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mystias_izakaya"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemRegistry.MystiaFishingRod.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ItemRegistry.MystiaFishingRod);
                output.accept(ItemRegistry.Grill_Block);
                output.accept(ItemRegistry.Boiling_Pot);
                output.accept(ItemRegistry.Frying_Pan);
                output.accept(ItemRegistry.Steamer);
                output.accept(ItemRegistry.Cutting_Board);

                output.accept(ItemRegistry.Trout);
                output.accept(ItemRegistry.Lamprey);
                output.accept(ItemRegistry.Salmon);
                output.accept(ItemRegistry.Tuna);
                output.accept(ItemRegistry.Premium_Tuna);
                output.accept(ItemRegistry.Pufferfish);
                output.accept(ItemRegistry.Shrimp);
                output.accept(ItemRegistry.Octopus);
                output.accept(ItemRegistry.Sea_Urchin);
                output.accept(ItemRegistry.Crab);
            }).build());
}
