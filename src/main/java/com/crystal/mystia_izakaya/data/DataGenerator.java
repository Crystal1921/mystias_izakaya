package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import net.minecraft.data.DataProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = MystiaIzakaya.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        ExistingFileHelper efh = event.getExistingFileHelper();
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModLanguageProviderEN>) pOutput -> new ModLanguageProviderEN(pOutput,MystiaIzakaya.MODID,"en_us"));
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModLanguageProviderCN>) pOutput -> new ModLanguageProviderCN(pOutput,MystiaIzakaya.MODID,"zh_cn"));
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModItemProvider>) pOutput -> new ModItemProvider(pOutput,MystiaIzakaya.MODID,efh)
        );
    }
}
