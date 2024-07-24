package com.crystal.mystia_izakaya.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;

import java.util.ArrayList;

public record FoodTagComponent(IntList intList) {
    public static final Codec<IntList> INT_LIST_CODEC = Codec.INT.listOf().xmap(IntArrayList::new, ArrayList::new);
    private static final StreamCodec<ByteBuf, IntList> INT_LIST_STREAM_CODEC = ByteBufCodecs.INT
            .apply(ByteBufCodecs.list())
            .map(IntArrayList::new, ArrayList::new);
    public static final Codec<FoodTagComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            INT_LIST_CODEC.fieldOf("food_tags").forGetter(FoodTagComponent::intList)).apply(instance, instance.stable(FoodTagComponent::new)));
    public static final StreamCodec<ByteBuf,FoodTagComponent> CODEC_STREAM = StreamCodec.composite(
            INT_LIST_STREAM_CODEC, FoodTagComponent::intList,
            FoodTagComponent::new
    );
}
