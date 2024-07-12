package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.crystal.mystia_izakaya.utils.UtilStaticMethod.resourceLocation;

public class ModTagItem extends ItemTagsProvider {
    public static final TagKey<Item> COOKED_MEAL = TagKey.create(Registries.ITEM,resourceLocation("cooked_meal"));
    public static final TagKey<Item> FOOD_INGREDIENTS = TagKey.create(Registries.ITEM,resourceLocation("food_ingredients"));

    public ModTagItem(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(ItemTags.FISHING_ENCHANTABLE).add(ItemRegistry.MystiaFishingRod.value());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Crab.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Grill_Block.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Trout.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Lamprey.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Salmon.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Tuna.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Premium_Tuna.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Pufferfish.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Shrimp.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Octopus.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Sea_Urchin.get());

        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Pork.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Beef.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Venison.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Boar_Meat.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Iberico_Pork.get());
        this.tag(FOOD_INGREDIENTS).add(ItemRegistry.Wagyo_Beef.get());

        //this.tag(COOKED_MEAL).add(ItemRegistry.Grilled_Lamprey.getKey());
    }
}
