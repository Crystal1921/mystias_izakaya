package com.crystal.mystia_izakaya.entity;

import com.crystal.mystia_izakaya.registry.EntityRegistry;
import com.crystal.mystia_izakaya.registry.LootTableRegistry;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MystiaFishingHook extends FishingHook {
    int luck;
    int lureSpeed;

    private MystiaFishingHook(EntityType<? extends MystiaFishingHook> pEntityType, Level pLevel, int pLuck, int pLureSpeed) {
        super(pEntityType, pLevel);
        this.noCulling = true;
        this.luck = Math.max(0, pLuck);
        this.lureSpeed = Math.max(0, pLureSpeed);
    }

    public MystiaFishingHook(EntityType<? extends MystiaFishingHook> pEntityType, Level pLevel) {
        this(pEntityType, pLevel, 0, 0);
    }

    public MystiaFishingHook(Player pPlayer, Level pLevel, int pLuck, int pLureSpeed) {
        this(EntityRegistry.Mystia_Fishing_Hook.get(), pLevel, pLuck, pLureSpeed);
        this.setOwner(pPlayer);
        float f = pPlayer.getXRot();
        float f1 = pPlayer.getYRot();
        float f2 = Mth.cos(-f1 * (float) (Math.PI / 180.0) - (float) Math.PI);
        float f3 = Mth.sin(-f1 * (float) (Math.PI / 180.0) - (float) Math.PI);
        float f4 = -Mth.cos(-f * (float) (Math.PI / 180.0));
        float f5 = Mth.sin(-f * (float) (Math.PI / 180.0));
        double d0 = pPlayer.getX() - (double) f3 * 0.3;
        double d1 = pPlayer.getEyeY();
        double d2 = pPlayer.getZ() - (double) f2 * 0.3;
        this.moveTo(d0, d1, d2, f1, f);
        Vec3 vec3 = new Vec3(-f3, Mth.clamp(-(f5 / f4), -5.0F, 5.0F), -f2);
        double d3 = vec3.length();
        vec3 = vec3.multiply(
                0.6 / d3 + this.random.triangle(0.5, 0.0103365), 0.6 / d3 + this.random.triangle(0.5, 0.0103365), 0.6 / d3 + this.random.triangle(0.5, 0.0103365)
        );
        this.setDeltaMovement(vec3);
        this.setYRot((float) (Mth.atan2(vec3.x, vec3.z) * 180.0F / (float) Math.PI));
        this.setXRot((float) (Mth.atan2(vec3.y, vec3.horizontalDistance()) * 180.0F / (float) Math.PI));
        this.yRotO = this.getYRot();
        this.xRotO = this.getXRot();
    }

    @Override
    public int retrieve(@NotNull ItemStack pStack) {
        Player player = this.getPlayerOwner();
        if (!this.level().isClientSide && player != null && !this.shouldStopFishing(player)) {
            int i = 0;
            if (this.nibble > 0) {
                MinecraftServer server = this.level().getServer();
                if (server == null) {
                    return 0;
                }
                LootParams lootparams = new LootParams.Builder((ServerLevel) this.level())
                        .withParameter(LootContextParams.THIS_ENTITY, player)
                        .withLuck((float) this.luck + player.getLuck())
                        .create(LootContextParamSets.EMPTY);
                LootTable loottable = server.reloadableRegistries().getLootTable(LootTableRegistry.FISHING);
                List<ItemStack> list = loottable.getRandomItems(lootparams);
                CriteriaTriggers.FISHING_ROD_HOOKED.trigger((ServerPlayer) player, pStack, this, list);
                for (ItemStack selectedItem : list) {
                    ItemEntity itementity = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), selectedItem);
                    double d0 = player.getX() - this.getX();
                    double d1 = player.getY() - this.getY();
                    double d2 = player.getZ() - this.getZ();
                    itementity.setDeltaMovement(d0 * 0.1, d1 * 0.1 + Math.sqrt(Math.sqrt(d0 * d0 + d1 * d1 + d2 * d2)) * 0.08, d2 * 0.1);
                    this.level().addFreshEntity(itementity);
                    player.level()
                            .addFreshEntity(new ExperienceOrb(player.level(), player.getX(), player.getY() + 0.5, player.getZ() + 0.5, this.random.nextInt(6) + 1));
                    if (selectedItem.is(ItemTags.FISHES)) {
                        player.awardStat(Stats.FISH_CAUGHT, 1);
                    }
                }
                i = 1;
            }

            if (this.onGround()) {
                i = 2;
            }

            this.discard();
            return i;
        } else {
            return 0;
        }
    }
}
