package com.crystal.mystia_izakaya.render.entity;

import com.crystal.mystia_izakaya.entity.MystiaFishingHook;
import com.crystal.mystia_izakaya.entity.model.MystiaFishingHookModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public class FishingHookRenderer extends EntityRenderer<MystiaFishingHook> {
    private final EntityModel<MystiaFishingHook> model;

    public FishingHookRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        model = new MystiaFishingHookModel<>(pContext.bakeLayer(MystiaFishingHookModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(@NotNull MystiaFishingHook pEntity) {
        return resourceLocation("textures/entity/texture.png");
    }

    @Override
    public void render(@NotNull MystiaFishingHook pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        Player player = pEntity.getPlayerOwner();
        if (player != null) {
            pPoseStack.pushPose();
            pPoseStack.pushPose();
            pPoseStack.mulPose(Axis.YN.rotationDegrees(45));
            pPoseStack.translate(0, -1.4, 0);
            VertexConsumer buffer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(pEntity)));
            this.model.renderToBuffer(pPoseStack, buffer, pPackedLight, OverlayTexture.NO_OVERLAY);
            pPoseStack.popPose();

            float f = player.getAttackAnim(pPartialTick);
            float f1 = Mth.sin(Mth.sqrt(f) * (float) Math.PI);
            Vec3 vec3 = this.getPlayerHandPos(player, f1, pPartialTick).add(0.0, 0.0, 0.0);
            Vec3 vec31 = pEntity.getPosition(pPartialTick).add(0.0, 0.25, 0.0);
            float f2 = (float) (vec3.x - vec31.x);
            float f3 = (float) (vec3.y - vec31.y);
            float f4 = (float) (vec3.z - vec31.z);
            VertexConsumer vertexconsumer1 = pBuffer.getBuffer(RenderType.lineStrip());
            PoseStack.Pose lasted = pPoseStack.last();

            for (int i = 0; i <= 16; i++) {
                stringVertex(f2, f3, f4, vertexconsumer1, lasted, fraction(i, 16), fraction(i + 1, 16));
            }
            pPoseStack.popPose();
            super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
        }
    }

    private Vec3 getPlayerHandPos(Player pPlayer, float v, float pPartialTick) {
        int i = pPlayer.getMainArm() == HumanoidArm.RIGHT ? 1 : -1;
        ItemStack itemstack = pPlayer.getMainHandItem();
        if (!itemstack.canPerformAction(net.neoforged.neoforge.common.ItemAbilities.FISHING_ROD_CAST)) {
            i = -i;
        }

        if (this.entityRenderDispatcher.options.getCameraType().isFirstPerson() && pPlayer == Minecraft.getInstance().player) {
            double d4 = 960.0 / (double) this.entityRenderDispatcher.options.fov().get();
            Vec3 vec3 = this.entityRenderDispatcher
                    .camera
                    .getNearPlane()
                    .getPointOnPlane((float) i * 0.525F, -0.1F)
                    .scale(d4)
                    .yRot(v * 0.5F)
                    .xRot(-v * 0.7F);
            return pPlayer.getEyePosition(pPartialTick).add(vec3);
        } else {
            float f = Mth.lerp(pPartialTick, pPlayer.yBodyRotO, pPlayer.yBodyRot) * (float) (Math.PI / 180.0);
            double d0 = Mth.sin(f);
            double d1 = Mth.cos(f);
            float f1 = pPlayer.getScale();
            double d2 = (double) i * 0.35 * (double) f1;
            double d3 = 0.8 * (double) f1;
            float f2 = pPlayer.isCrouching() ? -0.1875F : 0.0F;
            return pPlayer.getEyePosition(pPartialTick).add(-d1 * d2 - d0 * d3, (double) f2 - 0.45 * (double) f1, -d0 * d2 + d1 * d3);
        }
    }

    private static float fraction(int pNumerator, int pDenominator) {
        return (float) pNumerator / (float) pDenominator;
    }

    private static void stringVertex(
            float pX, float pY, float pZ, VertexConsumer pConsumer, PoseStack.Pose pPose, float pStringFraction, float pNextStringFraction
    ) {
        float f = pX * pStringFraction;
        float f1 = pY * (pStringFraction * pStringFraction + pStringFraction) * 0.5F + 0.25F;
        float f2 = pZ * pStringFraction;
        float f3 = pX * pNextStringFraction - f;
        float f4 = pY * (pNextStringFraction * pNextStringFraction + pNextStringFraction) * 0.5F + 0.25F - f1;
        float f5 = pZ * pNextStringFraction - f2;
        float f6 = Mth.sqrt(f3 * f3 + f4 * f4 + f5 * f5);
        f3 /= f6;
        f4 /= f6;
        f5 /= f6;
        pConsumer.addVertex(pPose, f, f1, f2).setColor(-16777216).setNormal(pPose, f3, f4, f5);
    }
}
