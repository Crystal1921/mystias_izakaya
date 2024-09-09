package com.crystal.mystia_izakaya.compat.touhou_little_maid;

import com.crystal.mystia_izakaya.registry.BlockRegistry;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;

public class SeatPoiManager {
    private static final Set<BlockState> SEATS = ImmutableList.of(BlockRegistry.Mystias_Seat.get())
            .stream().flatMap(block -> block.getStateDefinition().getPossibleStates().stream())
            .collect(ImmutableSet.toImmutableSet());

    public static PoiType getSeats() {
        return new PoiType(SEATS, 0, 1);
    }
}
