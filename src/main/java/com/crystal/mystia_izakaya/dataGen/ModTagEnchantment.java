package com.crystal.mystia_izakaya.dataGen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModTagEnchantment extends EnchantmentTagsProvider {


    public ModTagEnchantment(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, completableFuture, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {

    }
}
