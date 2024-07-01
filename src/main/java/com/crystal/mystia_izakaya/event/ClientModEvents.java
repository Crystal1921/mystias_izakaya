package com.crystal.mystia_izakaya.event;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.entity.model.MystiaFishingHookModel;
import com.crystal.mystia_izakaya.registry.EntityRegistry;
import com.crystal.mystia_izakaya.render.entity.FishingHookRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = MystiaIzakaya.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
        MystiaIzakaya.LOGGER.info("HELLO FROM CLIENT SETUP");
        MystiaIzakaya.LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions evt) {
        evt.registerLayerDefinition(MystiaFishingHookModel.LAYER_LOCATION, MystiaFishingHookModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onClientEvent(FMLClientSetupEvent event){
        event.enqueueWork(()->{
            EntityRenderers.register(EntityRegistry.Mystia_Fishing_Hook.get(), FishingHookRenderer::new);
        });
    }
}
