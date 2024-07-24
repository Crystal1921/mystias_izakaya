package com.crystal.mystia_izakaya.dataGen;

import com.crystal.mystia_izakaya.registry.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.crystal.mystia_izakaya.utils.UtilStaticMethod.resourceLocation;

public class ModBlockState extends BlockStateProvider {
    public ModBlockState(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.horizontalBlock(BlockRegistry.Grill.get(), new ModelFile.UncheckedModelFile(resourceLocation("block/grill")));
        this.horizontalBlock(BlockRegistry.Boiling_Pot.get(), new ModelFile.UncheckedModelFile(resourceLocation("block/boiling_pot")));
        this.horizontalBlock(BlockRegistry.Frying_Pan.get(), new ModelFile.UncheckedModelFile(resourceLocation("block/frying_pan")));
        this.horizontalBlock(BlockRegistry.Steamer.get(), new ModelFile.UncheckedModelFile(resourceLocation("block/steamer")));
        this.horizontalBlock(BlockRegistry.Cutting_Board.get(), new ModelFile.UncheckedModelFile(resourceLocation("block/cutting_board")));
    }
}
