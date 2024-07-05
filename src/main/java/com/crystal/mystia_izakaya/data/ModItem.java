package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.items.IngredientItem;
import com.crystal.mystia_izakaya.registry.items.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItem extends ItemModelProvider {
    public ModItem(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(ItemRegistry.MystiaFishingRod.get());
        this.basicItem(IngredientItem.Trout.get());
        this.basicItem(IngredientItem.Lamprey.get());
        this.basicItem(IngredientItem.Salmon.get());
        this.basicItem(IngredientItem.Tuna.get());
        this.basicItem(IngredientItem.Premium_Tuna.get());
        this.basicItem(IngredientItem.Pufferfish.get());
        this.basicItem(IngredientItem.Shrimp.get());
        this.basicItem(IngredientItem.Octopus.get());
        this.basicItem(IngredientItem.Sea_Urchin.get());
        this.basicItem(IngredientItem.Crab.get());
    }
}
