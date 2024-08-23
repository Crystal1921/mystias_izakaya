package com.crystal.mystia_izakaya.event;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.registry.ModelLayersRegistry;
import com.crystal.mystia_izakaya.render.model.MystiasHatModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = MystiaIzakaya.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class LayerRegistryEvent {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelLayersRegistry.MYSTIAS_HAT, () -> LayerDefinition.create(MystiasHatModel.setup(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 32, 32));
    }
}
