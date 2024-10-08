package com.crystal.mystia_izakaya.render.block;

import com.crystal.mystia_izakaya.client.blockEntity.AbstractCookerTE;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public class CookerRender implements BlockEntityRenderer<AbstractCookerTE> {
    private static final ResourceLocation TEXTURE_IN = resourceLocation("textures/entity/process_in.png");
    private static final ResourceLocation TEXTURE_OUT = resourceLocation("textures/entity/process_out.png");
    private static final RenderType RENDER_TYPE_IN = RenderType.entityCutoutNoCull(TEXTURE_IN);
    private static final RenderType RENDER_TYPE_OUT = RenderType.entityCutoutNoCull(TEXTURE_OUT);
    private final ItemRenderer itemRenderer;
    private final EntityRenderDispatcher entityRenderDispatcher;

    public CookerRender(BlockEntityRendererProvider.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
        this.entityRenderDispatcher = ctx.getEntityRenderer();
    }

    private static void renderImage(int pPackedLight, VertexConsumer vertexconsumer, PoseStack.Pose pose, float length) {
        vertex(vertexconsumer, pose, pPackedLight, 0.0F, 0, 0, 1);
        vertex(vertexconsumer, pose, pPackedLight, length, 0, 1, 1);
        vertex(vertexconsumer, pose, pPackedLight, length, 0.125F, 1, 0);
        vertex(vertexconsumer, pose, pPackedLight, 0.0F, 0.125F, 0, 0);
    }

    private static void vertex(VertexConsumer pConsumer, PoseStack.Pose pPose, int pPackedLight, float pX, float pY, float pU, float pV) {
        pConsumer.addVertex(pPose, pX - 0.5F, pY - 0.25F, 0.0F)
                .setColor(-1)
                .setUv(pU, pV)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(pPackedLight)
                .setNormal(pPose, 0.0F, 1.0F, 0.0F);
    }

    @Override
    public void render(AbstractCookerTE pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (!pBlockEntity.getItems().get(6).isEmpty()) {
            pPoseStack.pushPose();
            pPoseStack.translate(0.5, 0.7, 0.5);
            pPoseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            pPoseStack.scale(1.2F, 1.2F, 1.2F);
            this.itemRenderer
                    .renderStatic(
                            pBlockEntity.getItems().get(6),
                            ItemDisplayContext.GROUND,
                            pPackedLight,
                            OverlayTexture.NO_OVERLAY,
                            pPoseStack,
                            pBuffer,
                            pBlockEntity.getLevel(),
                            (int) pBlockEntity.getBlockPos().asLong()
                    );
            pPoseStack.translate(0, 0.8, 0);
            PoseStack.Pose poseStack = pPoseStack.last();
            float process = 1 - (float) pBlockEntity.cookTime / pBlockEntity.cookTotal;
            VertexConsumer vertexconsumerIn = pBuffer.getBuffer(RENDER_TYPE_IN);
            renderImage(pPackedLight, vertexconsumerIn, poseStack, process);
            VertexConsumer vertexconsumerOut = pBuffer.getBuffer(RENDER_TYPE_OUT);
            renderImage(pPackedLight, vertexconsumerOut, poseStack, 1);
            pPoseStack.popPose();
        }
    }
}
