package com.crystal.mystia_izakaya.network;

import com.crystal.mystia_izakaya.client.blockEntity.AbstractCookerTE;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public record CookInfoPacket(BlockPos blockPos, int cookTime, int cookTotal) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<CookInfoPacket> TYPE = new CustomPacketPayload.Type<>(resourceLocation("cook_info"));
    public static final StreamCodec<ByteBuf, CookInfoPacket> STREAM_CODEC = StreamCodec.composite(
            net.minecraft.core.BlockPos.STREAM_CODEC,
            CookInfoPacket::blockPos,
            ByteBufCodecs.VAR_INT,
            CookInfoPacket::cookTime,
            ByteBufCodecs.VAR_INT,
            CookInfoPacket::cookTotal,
            CookInfoPacket::new
    );

    public static void handle(CookInfoPacket message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            Player player = ctx.player();
            Level level = player.level();
            BlockEntity blockEntity = level.getBlockEntity(message.blockPos);
            if (blockEntity instanceof AbstractCookerTE abstractCookerTE) {
                abstractCookerTE.cookTime = message.cookTime;
                if (message.cookTotal > 0) {
                    abstractCookerTE.cookTotal = message.cookTotal;
                }
            }
        });
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
