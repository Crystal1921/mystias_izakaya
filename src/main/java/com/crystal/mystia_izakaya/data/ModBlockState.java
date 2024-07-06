package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.crystal.mystia_izakaya.utils.UtilMethod.resourceLocation;

public class ModBlockState extends BlockStateProvider {
    public ModBlockState(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.horizontalBlock(BlockRegistry.Grill.get(), new ModelFile.UncheckedModelFile(resourceLocation("block/grill")));
    }
}
