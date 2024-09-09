package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.client.blockEntity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MystiaIzakaya.MODID);
    public static final Supplier<BlockEntityType<MystiaSeatTE>> MYSTIAS_SEAT = BLOCK_ENTITY_TYPES.register("mystias_seat", () -> BlockEntityType.Builder.of(MystiaSeatTE::new, BlockRegistry.Mystias_Seat.value()).build(null));
    public static final Supplier<BlockEntityType<BoilingPotTE>> BOILING_POT = BLOCK_ENTITY_TYPES.register("boiling_pot", () -> BlockEntityType.Builder.of(BoilingPotTE::new, BlockRegistry.Boiling_Pot.value()).build(null));
    public static final Supplier<BlockEntityType<GrillTE>> GRILL = BLOCK_ENTITY_TYPES.register("grill", () -> BlockEntityType.Builder.of(GrillTE::new,BlockRegistry.Grill.value()).build(null));
    public static final Supplier<BlockEntityType<FryingPanTE>> FRYING_PAN = BLOCK_ENTITY_TYPES.register("frying_pan", () -> BlockEntityType.Builder.of(FryingPanTE::new, BlockRegistry.Frying_Pan.value()).build(null));
    public static final Supplier<BlockEntityType<SteamerTE>> STEAMER = BLOCK_ENTITY_TYPES.register("steamer", () -> BlockEntityType.Builder.of(SteamerTE::new,BlockRegistry.Steamer.value()).build(null));
    public static final Supplier<BlockEntityType<CuttingBoardTE>> CUTTING_BOARD = BLOCK_ENTITY_TYPES.register("cutting_board", () -> BlockEntityType.Builder.of(CuttingBoardTE::new, BlockRegistry.Cutting_Board.value()).build(null));
}
