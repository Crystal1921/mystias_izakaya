package com.crystal.mystia_izakaya.event;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.item.MystiasHat;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(modid = MystiaIzakaya.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ClientExtensionsEvent {
    @SubscribeEvent
    public static void RegisterClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(MystiasHat.ITEM_EXTENSIONS, ItemRegistry.MystiasHat.get());
    }
}
