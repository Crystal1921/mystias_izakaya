package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GrillBlockTE extends BlockEntity {
    public GrillBlockTE( BlockPos pPos, BlockState pBlockState) {
        super(BlockEntityRegistry.GRILL.get(), pPos, pBlockState);
    }
}
