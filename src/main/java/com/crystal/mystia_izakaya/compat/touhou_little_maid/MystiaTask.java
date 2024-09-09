package com.crystal.mystia_izakaya.compat.touhou_little_maid;

import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.github.tartaricacid.touhoulittlemaid.api.task.IMaidTask;
import com.github.tartaricacid.touhoulittlemaid.entity.passive.EntityMaid;
import com.github.tartaricacid.touhoulittlemaid.init.InitSounds;
import com.github.tartaricacid.touhoulittlemaid.util.SoundUtil;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.behavior.BehaviorControl;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public class MystiaTask implements IMaidTask {
    @Override
    public @NotNull ResourceLocation getUid() {
        return resourceLocation("mystia_meal");
    }

    @Override
    public @NotNull ItemStack getIcon() {
        return ItemRegistry.Rice_Ball.toStack();
    }

    @Nullable
    @Override
    public SoundEvent getAmbientSound(EntityMaid entityMaid) {
        return SoundUtil.environmentSound(entityMaid, InitSounds.MAID_IDLE.get(), 0.5f);
    }

    @Override
    public List<Pair<Integer, BehaviorControl<? super EntityMaid>>> createBrainTasks(EntityMaid entityMaid) {
        Pair<Integer, BehaviorControl<? super EntityMaid>> maidMealTask = Pair.of(5, new MaidMealTask(0.6f, 2));
        return Lists.newArrayList(maidMealTask);
    }
}
