package com.crystal.mystia_izakaya.render.block;

import com.crystal.mystia_izakaya.client.blockEntity.MystiaSeatTE;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;

public class MystiasSeatRender implements BlockEntityRenderer<MystiaSeatTE> {
    private final ItemRenderer itemRenderer;
    private final EntityRenderDispatcher entityRenderDispatcher;
    public MystiasSeatRender(BlockEntityRendererProvider.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
        this.entityRenderDispatcher = ctx.getEntityRenderer();
    }
    @Override
    public void render(MystiaSeatTE blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (blockEntity.getItem().getItem() instanceof CookedMealItem cookedMealItem) {
            poseStack.pushPose();
            poseStack.translate(0.5, 1, 0.5);
            poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
            poseStack.scale(1.2F, 1.2F, 1.2F);
            this.itemRenderer
                    .renderStatic(
                            cookedMealItem.getDefaultInstance(),
                            ItemDisplayContext.GROUND,
                            packedLight,
                            OverlayTexture.NO_OVERLAY,
                            poseStack,
                            bufferSource,
                            blockEntity.getLevel(),
                            (int) blockEntity.getBlockPos().asLong()
                    );
            poseStack.popPose();
        }
    }
}
