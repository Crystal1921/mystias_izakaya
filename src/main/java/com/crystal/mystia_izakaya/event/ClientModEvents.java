package com.crystal.mystia_izakaya.event;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.gui.screen.*;
import com.crystal.mystia_izakaya.entity.model.MystiaFishingHookModel;
import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import com.crystal.mystia_izakaya.registry.EntityRegistry;
import com.crystal.mystia_izakaya.registry.MenuRegistry;
import com.crystal.mystia_izakaya.render.block.CookerRender;
import com.crystal.mystia_izakaya.render.block.MystiasSeatRender;
import com.crystal.mystia_izakaya.render.entity.FishingHookRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = MystiaIzakaya.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> EntityRenderers.register(EntityRegistry.Mystia_Fishing_Hook.get(), FishingHookRenderer::new));

    }

    @SubscribeEvent
    private static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(MenuRegistry.Grill_Menu.get(), GrillScreen::new);
        event.register(MenuRegistry.Boiling_Pot_Menu.get(), BoilingPotScreen::new);
        event.register(MenuRegistry.Cutting_Board_Menu.get(), CuttingBoardScreen::new);
        event.register(MenuRegistry.Frying_Pan_Menu.get(), FryingPanScreen::new);
        event.register(MenuRegistry.Steamer_Menu.get(), SteamerScreen::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntityRegistry.GRILL.get(), CookerRender::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.BOILING_POT.get(), CookerRender::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.CUTTING_BOARD.get(), CookerRender::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.FRYING_PAN.get(), CookerRender::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.STEAMER.get(), CookerRender::new);
        event.registerBlockEntityRenderer(BlockEntityRegistry.MYSTIAS_SEAT.get(), MystiasSeatRender::new);
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions evt) {
        evt.registerLayerDefinition(MystiaFishingHookModel.LAYER_LOCATION, MystiaFishingHookModel::createBodyLayer);
    }
}
