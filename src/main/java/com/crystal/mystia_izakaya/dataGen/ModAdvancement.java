package com.crystal.mystia_izakaya.dataGen;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.utils.LocalMealList;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancement extends AdvancementProvider {
    public ModAdvancement(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new MyAdvancementGenerator()));
    }

    private static final class MyAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper) {
            // Generate your advancements here.
            AdvancementHolder root = Advancement.Builder.advancement().display(
                            ItemRegistry.Rice_Ball.toStack(),
                            Component.translatable("advancement.mystias_izakaya.root"),
                            Component.translatable("advancement.mystias_izakaya.root.desc"),
                            ResourceLocation.withDefaultNamespace("textures/gui/advancements/backgrounds/adventure.png"),
                            AdvancementType.TASK,
                            true, true, false)
                    .addCriterion("recipe_book", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.RecipeBook))
                    .save(saver, MystiaIzakaya.MODID + ":root");

            Advancement.Builder cookerBuilder = Advancement.Builder.advancement().parent(root).display(
                    ItemRegistry.Boiling_Pot.toStack(),
                    Component.translatable("advancement.mystias_izakaya.cooker"),
                    Component.translatable("advancement.mystias_izakaya.cooker.desc"),
                    null,
                    AdvancementType.TASK,
                    true, true, false);
            LocalMealList.getInstance().getCookerTypeMap().forEach((cookerTypeEnum, item) -> cookerBuilder.addCriterion(cookerTypeEnum.getName(), InventoryChangeTrigger.TriggerInstance.hasItems(item)));
            AdvancementHolder cookers = cookerBuilder.save(saver, MystiaIzakaya.MODID + ":cooker");

            AdvancementHolder moesumika = Advancement.Builder.advancement().parent(cookers).display(
                            ItemRegistry.Cubic_Kedama_Ice_Cream.toStack(),
                            Component.translatable("advancement.mystias_izakaya.moesumika"),
                            Component.translatable("advancement.mystias_izakaya.moesumika.desc"),
                            null,
                            AdvancementType.TASK,
                            true, true, false)
                    .addCriterion("cubic_kedama_ice_cream", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.Cubic_Kedama_Ice_Cream))
                    .addCriterion("cubic_kedama_volcanic_tofu", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.Cubic_Kedama_Volcanic_Tofu))
                    .save(saver, MystiaIzakaya.MODID + ":moesumika");

            AdvancementHolder chrome_ball = Advancement.Builder.advancement().parent(cookers).display(
                            ItemRegistry.ChromeBall.toStack(),
                            Component.translatable("advancement.mystias_izakaya.chrome_ball"),
                            Component.translatable("advancement.mystias_izakaya.chrome_ball.desc"),
                            null,
                            AdvancementType.TASK,
                            true, true, true)
                    .addCriterion("chrome_ball", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.ChromeBall))
                    .save(saver, MystiaIzakaya.MODID + ":chrome_ball");
        }
    }
}
