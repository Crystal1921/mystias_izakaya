package com.crystal.mystia_izakaya.network;

import com.crystal.mystia_izakaya.client.blockEntity.AbstractCookerTE;
import com.crystal.mystia_izakaya.client.gui.menu.AbstractCookMenu;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
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

import static com.crystal.mystia_izakaya.utils.UtilStaticMethod.resourceLocation;

public record MealInfoPacket(int cookTime, Holder<Item> cookedMealItem, BlockPos blockPos) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<MealInfoPacket> TYPE = new CustomPacketPayload.Type<>(resourceLocation("meal_info"));
    public static final StreamCodec<RegistryFriendlyByteBuf, MealInfoPacket> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.INT, MealInfoPacket::cookTime,
            ByteBufCodecs.holderRegistry(Registries.ITEM), MealInfoPacket::cookedMealItem,
            BlockPos.STREAM_CODEC, MealInfoPacket::blockPos,
            MealInfoPacket::new);

    public static void handle(MealInfoPacket message, IPayloadContext ctx) {
        ctx.enqueueWork(() -> {
            Player player = ctx.player();
            Level level = player.level();
            if (player.containerMenu instanceof AbstractCookMenu) {
                if(level.getBlockEntity(message.blockPos) instanceof AbstractCookerTE cookerTE) {
                    cookerTE.cookTime = message.cookTime;
                    cookerTE.targetMeal = (CookedMealItem) message.cookedMealItem.value();
                }
            }
        });
    }

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
