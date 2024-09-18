package com.crystal.mystia_izakaya.event;

import com.crystal.mystia_izakaya.Config;
import com.crystal.mystia_izakaya.MystiaIzakaya;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

public class CommonEvent {
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        MystiaIzakaya.LOGGER.info("HELLO from server starting");
    }

    @SubscribeEvent
    public static void commonSetup(final FMLCommonSetupEvent event)
    {
        MystiaIzakaya.LOGGER.info("Do you have \"Cultural Heritage\"");
        // Some common setup code
//        MystiaIzakaya.LOGGER.info("HELLO FROM COMMON SETUP");
//
//        if (Config.logDirtBlock)
//            MystiaIzakaya.LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
//
//        MystiaIzakaya.LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
//
//        Config.items.forEach((item) -> MystiaIzakaya.LOGGER.info("ITEM >> {}", item.toString()));
    }
}
