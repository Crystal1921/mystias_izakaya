package com.crystal.mystia_izakaya.client.item;

import com.crystal.mystia_izakaya.registry.ModelLayersRegistry;
import com.crystal.mystia_izakaya.render.model.MystiasHatModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public class MystiasHat extends ArmorItem {
    public static final IClientItemExtensions ITEM_EXTENSIONS = FMLEnvironment.dist == Dist.CLIENT? new IClientItemExtensions() {
        @Override
        public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> model) {
            EntityModelSet models = Minecraft.getInstance().getEntityModels();
            ModelPart root = models.bakeLayer(ModelLayersRegistry.MYSTIAS_HAT);
            return new MystiasHatModel(root);
        }
    }: null;
    public MystiasHat(Type type) {
        super(ArmorMaterials.IRON, type, new Item.Properties().stacksTo(1));
    }

    @Override
    public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        return resourceLocation("textures/entity/mystias_hat.png");
    }
}
