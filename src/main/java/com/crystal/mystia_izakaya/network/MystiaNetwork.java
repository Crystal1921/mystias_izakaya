package com.crystal.mystia_izakaya.network;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class MystiaNetwork {
    public static void registerPacket(final RegisterPayloadHandlersEvent event) {
        // Sets the current network version
        final PayloadRegistrar registrar = event.registrar(MystiaIzakaya.MODID).versioned("1").optional();
        registrar.playBidirectional(MealInfoPacket.TYPE,MealInfoPacket.STREAM_CODEC,MealInfoPacket::handle);
        registrar.playBidirectional(TagsPacket.TYPE, TagsPacket.STREAM_CODEC, TagsPacket::handle);
        registrar.playBidirectional(TargetIndexPacket.TYPE, TargetIndexPacket.STREAM_CODEC, TargetIndexPacket::handle);
    }
}
