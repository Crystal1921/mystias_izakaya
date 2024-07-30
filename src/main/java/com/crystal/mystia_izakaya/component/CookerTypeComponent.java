package com.crystal.mystia_izakaya.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

public record CookerTypeComponent(int cookerType) {
    public static final Codec<CookerTypeComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("cooker_type").forGetter(CookerTypeComponent::cookerType)).apply(instance, instance.stable(CookerTypeComponent::new)));
    public static final StreamCodec<ByteBuf,CookerTypeComponent> CODEC_STREAM = StreamCodec.composite(
            ByteBufCodecs.INT, CookerTypeComponent::cookerType,
            CookerTypeComponent::new
    );
}
