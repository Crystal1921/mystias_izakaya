package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.ItemRegistry;
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
    }
}
