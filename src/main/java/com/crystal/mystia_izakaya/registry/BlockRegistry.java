package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.block.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MystiaIzakaya.MODID);
    public static final DeferredBlock<Block> Mystias_Seat = BLOCKS.register("mystias_seat", MystiasSeatBlock::new);
    public static final DeferredBlock<Block> Boiling_Pot = BLOCKS.register("boiling_pot", BoilingPotBlock::new);
    public static final DeferredBlock<Block> Grill = BLOCKS.register("grill", GrillBlock::new);
    public static final DeferredBlock<Block> Frying_Pan = BLOCKS.register("frying_pan", FryingPanBlock::new);
    public static final DeferredBlock<Block> Steamer = BLOCKS.register("steamer", SteamerBlock::new);
    public static final DeferredBlock<Block> Cutting_Board = BLOCKS.register("cutting_board", CuttingBoardBlock::new);
}
