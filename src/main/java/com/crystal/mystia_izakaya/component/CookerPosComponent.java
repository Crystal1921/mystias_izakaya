package com.crystal.mystia_izakaya.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.ArrayList;
import java.util.List;

public record CookerPosComponent(List<BlockPos> posList){

    public static final Codec<CookerPosComponent> CODEC = RecordCodecBuilder.create(ins -> ins.group(
            BlockPos.CODEC.listOf().fieldOf("posList").forGetter(o -> o.posList)
    ).apply(ins, CookerPosComponent::new));

    public static final StreamCodec<ByteBuf, CookerPosComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.collection(ArrayList::new, net.minecraft.core.BlockPos.STREAM_CODEC),
            CookerPosComponent::posList,
            CookerPosComponent::new
    );
}
