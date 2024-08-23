package com.crystal.mystia_izakaya.event;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.render.overlay.cookerListOverlay;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;
import static net.neoforged.neoforge.client.gui.VanillaGuiLayers.HOTBAR;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = MystiaIzakaya.MODID)
public class GuiOverlayEvent {
    @SubscribeEvent
    public static void RegisterGuiLayers(RegisterGuiLayersEvent event) {
        event.registerAbove(HOTBAR, resourceLocation("cooker_list"), new cookerListOverlay());
    }
}
