package com.crystal.mystia_izakaya.dataGen;

import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.utils.MealList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

public class ModItem extends ItemModelProvider {
    public ModItem(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(ItemRegistry.MystiaFishingRod.get());
        this.basicItem(ItemRegistry.MystiasHat.get());
        this.basicItem(ItemRegistry.RecipeBook.get());
        this.basicItem(ItemRegistry.ChromeBall.get());

        this.basicItem(ItemRegistry.Trout.get());
        this.basicItem(ItemRegistry.Lamprey.get());
        this.basicItem(ItemRegistry.Salmon.get());
        this.basicItem(ItemRegistry.Tuna.get());
        this.basicItem(ItemRegistry.Premium_Tuna.get());
        this.basicItem(ItemRegistry.Pufferfish.get());
        this.basicItem(ItemRegistry.Shrimp.get());
        this.basicItem(ItemRegistry.Octopus.get());
        this.basicItem(ItemRegistry.Sea_Urchin.get());
        this.basicItem(ItemRegistry.Crab.get());

        this.basicItem(ItemRegistry.Pork.get());
        this.basicItem(ItemRegistry.Beef.get());
        this.basicItem(ItemRegistry.Venison.get());
        this.basicItem(ItemRegistry.Boar_Meat.get());
        this.basicItem(ItemRegistry.Iberico_Pork.get());
        this.basicItem(ItemRegistry.Wagyo_Beef.get());

        this.basicItem(ItemRegistry.Tofu.get());
        this.basicItem(ItemRegistry.Potato.get());
        this.basicItem(ItemRegistry.Onion.get());
        this.basicItem(ItemRegistry.Pumpkin.get());
        this.basicItem(ItemRegistry.Radish.get());
        this.basicItem(ItemRegistry.Seaweed.get());
        this.basicItem(ItemRegistry.Mushroom.get());
        this.basicItem(ItemRegistry.Truffle.get());
        this.basicItem(ItemRegistry.Bamboo_Shoot.get());
        this.basicItem(ItemRegistry.Cucumber.get());
        this.basicItem(ItemRegistry.Chestnut.get());
        this.basicItem(ItemRegistry.Red_Toon.get());
        this.basicItem(ItemRegistry.Tomato.get());
        this.basicItem(ItemRegistry.Broceoli.get());

        this.basicItem(ItemRegistry.Egg.get());
        this.basicItem(ItemRegistry.Ginko_Nut.get());
        this.basicItem(ItemRegistry.Cicada_Slough.get());
        this.basicItem(ItemRegistry.Dew.get());
        this.basicItem(ItemRegistry.Flour.get());
        this.basicItem(ItemRegistry.Sticky_Rice.get());
        this.basicItem(ItemRegistry.Ice_Cube.get());
        this.basicItem(ItemRegistry.Grapes.get());
        this.basicItem(ItemRegistry.Cream.get());
        this.basicItem(ItemRegistry.Lemon.get());
        this.basicItem(ItemRegistry.Lotus_Seed.get());
        this.basicItem(ItemRegistry.Pine_Nut.get());
        this.basicItem(ItemRegistry.Red_Bean.get());
        this.basicItem(ItemRegistry.Cocoa_Bean.get());
        this.basicItem(ItemRegistry.Snow_Fungus.get());
        this.basicItem(ItemRegistry.Peach.get());
        this.basicItem(ItemRegistry.Honey.get());
        this.basicItem(ItemRegistry.Udunmbara.get());
        this.basicItem(ItemRegistry.Butter.get());
        this.basicItem(ItemRegistry.Bamboo.get());
        this.basicItem(ItemRegistry.Lunar_Herb.get());
        this.basicItem(ItemRegistry.Chili.get());
        this.basicItem(ItemRegistry.Black_Salt.get());
        this.basicItem(ItemRegistry.Bingdi_Lotus.get());
        this.basicItem(ItemRegistry.Cheese.get());
        this.basicItem(ItemRegistry.Sweet_Potato.get());
        this.basicItem(ItemRegistry.Plum.get());
        this.basicItem(ItemRegistry.Flower.get());
        this.basicItem(ItemRegistry.Creeping_Fig.get());

        MealList.getInstance().getMeals().forEach(meal -> localItem(meal, "recipe/"));

        this.localItem(ItemRegistry.Grill.get(), "cooker/");
        this.localItem(ItemRegistry.Boiling_Pot.get(), "cooker/");
        this.localItem(ItemRegistry.Frying_Pan.get(), "cooker/");
        this.localItem(ItemRegistry.Steamer.get(), "cooker/");
        this.localItem(ItemRegistry.Cutting_Board.get(), "cooker/");
    }

    public void blockItem(Item item, String path) {
        blockItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)), path);
    }

    public void blockItem(ResourceLocation item, String path) {
        getBuilder(item.toString())
                .transforms()
                .transform(ItemDisplayContext.GUI).rotation(30, 45, 0).scale(0.6F, 0.6F, 0.6F).end()
                .transform(ItemDisplayContext.GROUND).scale(0.23F, 0.25F, 0.25F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0, 45, 0).translation(0, 0, -8).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0, 45, 0).translation(0, 0, -8).end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(75, 135, 0).scale(0.4F, 0.4F, 0.4F).translation(0, 0, 0).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(75, 135, 0).scale(0.4F, 0.4F, 0.4F).translation(0, 0, 0).end()
                .end()
                .parent(new ModelFile.UncheckedModelFile(resourceLocation(path)));
    }

    public ItemModelBuilder localItem(Item item, String filePath) {
        return localItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)),filePath);
    }

    public ItemModelBuilder localItem(ResourceLocation item, String filePath) {
        return getBuilder(item.toString())
                .parent(new ModelFile.UncheckedModelFile("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + filePath + item.getPath()));
    }
}
