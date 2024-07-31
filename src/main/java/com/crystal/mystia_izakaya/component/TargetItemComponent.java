package com.crystal.mystia_izakaya.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record TargetItemComponent(Integer target) {
    public static final Codec<TargetItemComponent> CODEC = RecordCodecBuilder.create(ins -> ins.group(
            Codec.INT.fieldOf("target").forGetter(o -> o.target)
    ).apply(ins, TargetItemComponent::new));

    public static final StreamCodec<ByteBuf, TargetItemComponent> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT,
            TargetItemComponent::target,
            TargetItemComponent::new
    );
}
