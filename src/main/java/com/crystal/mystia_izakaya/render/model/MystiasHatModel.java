package com.crystal.mystia_izakaya.render.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.LivingEntity;

public class MystiasHatModel extends HumanoidModel<LivingEntity> {
    public MystiasHatModel(ModelPart root) {
        super(root);
    }
    public static MeshDefinition setup(CubeDeformation deformation) {
        MeshDefinition meshdefinition = HumanoidModel.createMesh(deformation, 0);
        PartDefinition partdefinition = meshdefinition.getRoot();
        var head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0),
                PartPose.offset(0.0F, 0.0F, 0.0F));
        head.addOrReplaceChild("bb_main",
                CubeListBuilder.create().texOffs(0, 9)
                        .addBox(-3.0F, -5.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                        .addBox(-4.0F, -6.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8F, 0.0F));
        return meshdefinition;
    }

    @Override
    public void setupAnim(LivingEntity livingEntity, float v, float v1, float v2, float v3, float v4) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, int i2) {
        this.head.render(poseStack, vertexConsumer, i, i1, i2);
    }
}
