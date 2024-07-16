package com.crystal.mystia_izakaya.render.block;

import com.crystal.mystia_izakaya.client.blockEntity.AbstractCookerTE;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;

public class CookerRender implements BlockEntityRenderer<AbstractCookerTE> {
    private final ItemRenderer itemRenderer;

    public CookerRender(BlockEntityRendererProvider.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    public void render(AbstractCookerTE pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (pBlockEntity.getItems().get(6).getItem() instanceof CookedMealItem cookedMealItem) {
            int tick = 0;
            if (pBlockEntity.getLevel() != null) {
                tick = (int) (pBlockEntity.getLevel().getGameTime() * 4) % 360;
            }
            pPoseStack.pushPose();
            pPoseStack.translate(0.5, 0.5, 0.5);
            pPoseStack.mulPose(Axis.YP.rotationDegrees(tick));
            pPoseStack.scale(1.2F, 1.2F, 1.2F);
            this.itemRenderer
                    .renderStatic(
                            cookedMealItem.getDefaultInstance(),
                            ItemDisplayContext.GROUND,
                            pPackedLight,
                            OverlayTexture.NO_OVERLAY,
                            pPoseStack,
                            pBuffer,
                            pBlockEntity.getLevel(),
                            (int) pBlockEntity.getBlockPos().asLong()
                    );
            pPoseStack.popPose();
        }
    }
}
