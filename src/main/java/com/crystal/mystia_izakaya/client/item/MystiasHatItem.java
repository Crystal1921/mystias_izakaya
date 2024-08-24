package com.crystal.mystia_izakaya.client.item;

import com.crystal.mystia_izakaya.registry.ComponentRegistry;
import com.crystal.mystia_izakaya.registry.ModelLayersRegistry;
import com.crystal.mystia_izakaya.render.model.MystiasHatModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public class MystiasHatItem extends ArmorItem {
    public static final IClientItemExtensions ITEM_EXTENSIONS = FMLEnvironment.dist == Dist.CLIENT ? new IClientItemExtensions() {
        @Override
        public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> model) {
            EntityModelSet models = Minecraft.getInstance().getEntityModels();
            ModelPart root = models.bakeLayer(ModelLayersRegistry.MYSTIAS_HAT);
            return new MystiasHatModel(root);
        }
    } : null;

    public MystiasHatItem(Type type) {
        super(ArmorMaterials.IRON, type, new Item.Properties().stacksTo(1));
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        return InteractionResultHolder.pass(itemstack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        var components = pStack.get(ComponentRegistry.COOKER_POS);
        if (components != null) {
            List<BlockPos> blockPosList = components.posList();
            for (int i = 0; i < blockPosList.size(); i++) {
                pTooltipComponents.add(Component.literal("Pos[" + i + "] : " + blockPosList.get(i).toShortString()));
            }
        }
    }

    @Override
    public ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean innerModel) {
        return resourceLocation("textures/entity/mystias_hat.png");
    }
}
