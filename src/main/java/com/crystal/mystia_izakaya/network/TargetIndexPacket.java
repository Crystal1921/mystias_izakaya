package com.crystal.mystia_izakaya.network;

import com.crystal.mystia_izakaya.registry.ComponentRegistry;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public record TargetIndexPacket(int target) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<TargetIndexPacket> TYPE = new CustomPacketPayload.Type<>(resourceLocation("target_item"));
    public static final StreamCodec<ByteBuf, TargetIndexPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.VAR_INT,
            TargetIndexPacket::target,
            TargetIndexPacket::new
    );

    public static void handle(TargetIndexPacket message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            Player player = ctx.player();
            ItemStack itemStack = player.getMainHandItem();
            if (itemStack.is(ItemRegistry.RecipeBook)) {
                itemStack.set(ComponentRegistry.TARGET_ITEM, message.target);
            }
        });
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
