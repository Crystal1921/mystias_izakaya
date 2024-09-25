package com.crystal.mystia_izakaya.dataGen;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import net.minecraft.data.DataProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = MystiaIzakaya.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        var efh = event.getExistingFileHelper();
        var generator = event.getGenerator();
        var registries = event.getLookupProvider();
        var vanillaPack = generator.getVanillaPack(true);
        var existingFileHelper = event.getExistingFileHelper();
        var pack = generator.getPackOutput();
        var completableFuture = event.getLookupProvider();

        //Language
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModLanguageEN>) pOutput -> new ModLanguageEN(pOutput, MystiaIzakaya.MODID, "en_us"));
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModLanguageCN>) pOutput -> new ModLanguageCN(pOutput, MystiaIzakaya.MODID, "zh_cn"));
        //ItemModel
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModItem>) pOutput -> new ModItem(pOutput, MystiaIzakaya.MODID, efh));
        //BlockState
        event.getGenerator().addProvider(
                event.includeClient(),
                (DataProvider.Factory<ModBlockState>) pOutput -> new ModBlockState(pOutput, MystiaIzakaya.MODID, efh)
        );
        //Enchantment
        event.getGenerator().addProvider(
                event.includeServer(),
                (DataProvider.Factory<ModTagEnchantment>) pOutput -> new ModTagEnchantment(pOutput, completableFuture, MystiaIzakaya.MODID, efh));
        //LootTable
        event.getGenerator().addProvider(
                event.includeServer(),
                (DataProvider.Factory<LootTableProvider>) pOutput -> new LootTableProvider(pOutput, Collections.emptySet(), getLootTableList(), completableFuture)
        );
        //Recipe
        event.getGenerator().addProvider(
                event.includeServer(),
                (DataProvider.Factory<RecipeProvider>) pOutput -> new ModRecipe(pOutput, registries)
        );
        //Advancement
        event.getGenerator().addProvider(
                event.includeServer(),
                (DataProvider.Factory<AdvancementProvider>) pOutput -> new ModAdvancement(pOutput, registries, existingFileHelper)
        );

        //Tags
        var blockTagsProvider = vanillaPack.addProvider(packOutput -> new ModTagBlock(packOutput, registries, MystiaIzakaya.MODID, existingFileHelper));

        vanillaPack.addProvider(packOutput -> new ModTagItem(packOutput, registries, blockTagsProvider.contentsGetter(), MystiaIzakaya.MODID, existingFileHelper));
    }

    public static List<LootTableProvider.SubProviderEntry> getLootTableList() {
        return List.of(new LootTableProvider.SubProviderEntry(
                ModLootTableFishing::new,
                // Loot table generator for the 'empty' param set
                LootContextParamSets.EMPTY
        ));
    }
}
