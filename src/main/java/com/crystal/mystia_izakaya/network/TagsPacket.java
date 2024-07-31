package com.crystal.mystia_izakaya.network;

import com.crystal.mystia_izakaya.component.FoodTagComponent;
import com.crystal.mystia_izakaya.registry.ComponentRegistry;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public record TagsPacket(byte[] tags) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<TagsPacket> TYPE = new CustomPacketPayload.Type<>(resourceLocation("meal_tags"));

    public static final StreamCodec<ByteBuf, TagsPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.BYTE_ARRAY, TagsPacket::tags,
            TagsPacket::new
    );

    public static void handle(TagsPacket message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            Player player = ctx.player();
            ItemStack itemStack = player.getMainHandItem();
            if (itemStack.is(ItemRegistry.RecipeBook)){
                IntList intList = new IntArrayList();
                for (byte tag : message.tags) {
                    intList.add(tag);
                }
                itemStack.set(ComponentRegistry.FOOD_TAG,new FoodTagComponent(intList));
            }
        });
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
