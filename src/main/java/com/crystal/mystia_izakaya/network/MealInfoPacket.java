package com.crystal.mystia_izakaya.network;

import com.crystal.mystia_izakaya.client.blockEntity.AbstractCookerTE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public record MealInfoPacket(int cookTime, ArrayList<Item> cookedMealItems, BlockPos blockPos,
                             byte[] tags) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<MealInfoPacket> TYPE = new CustomPacketPayload.Type<>(resourceLocation("meal_info"));
    public static final StreamCodec<RegistryFriendlyByteBuf, ArrayList<Item>> ITEM_COLLECTION_STREAM_CODEC =
            ByteBufCodecs.collection(
                    ArrayList::new,
                    ByteBufCodecs.registry(Registries.ITEM),
                    7);

    public static final StreamCodec<RegistryFriendlyByteBuf, MealInfoPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, MealInfoPacket::cookTime,
            ITEM_COLLECTION_STREAM_CODEC, MealInfoPacket::cookedMealItems,
            BlockPos.STREAM_CODEC, MealInfoPacket::blockPos,
            ByteBufCodecs.BYTE_ARRAY, MealInfoPacket::tags,
            MealInfoPacket::new);

    public static void handle(MealInfoPacket message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            Player player = ctx.player();
            Level level = player.level();
            if (level.getBlockEntity(message.blockPos) instanceof AbstractCookerTE cookerTE) {
                cookerTE.cookTime = message.cookTime;
                cookerTE.setItems(message.cookedMealItems);
                cookerTE.lit = true;
                cookerTE.setFoodTags(message.tags);
            }
        });
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
