package com.crystal.mystia_izakaya.data;

import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

import static com.crystal.mystia_izakaya.utils.UtilStaticMethod.resourceLocation;

public class ModItem extends ItemModelProvider {
    public ModItem(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.basicItem(ItemRegistry.MystiaFishingRod.get());
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

        this.basicItem(ItemRegistry.Grilled_Lamprey.get());

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

        this.basicItem(ItemRegistry.Oedo_Boat_Feast.get());
        this.basicItem(ItemRegistry.Dragonsong_Peach.get());
        this.basicItem(ItemRegistry.Planet_Mars.get());
        this.basicItem(ItemRegistry.Two_Flavor_Beef_Hotpot.get());
        this.basicItem(ItemRegistry.Mad_Hatters_Tea_Party.get());
        this.basicItem(ItemRegistry.Scrumptious_Storm.get());
        this.basicItem(ItemRegistry.Buddha_Jump_Over_The_Wall.get());
        this.basicItem(ItemRegistry.Beef_Wellington.get());
        this.basicItem(ItemRegistry.Dragon_Carp.get());
        this.basicItem(ItemRegistry.Eight_Trigram_Fish_Maws.get());
        this.basicItem(ItemRegistry.Supreme_Seafood_Noodles.get());
        this.basicItem(ItemRegistry.Faint_Dream.get());
        this.basicItem(ItemRegistry.Star_Lotus_Ship.get());
        this.basicItem(ItemRegistry.Rainbow_Pan_Fride_Pork_Buns.get());
        this.basicItem(ItemRegistry.Moonlight_over_the_Lotus_Pond.get());
        this.basicItem(ItemRegistry.Urchin_Raindrop_Cake.get());
        this.basicItem(ItemRegistry.Fujis_Lava.get());
        this.basicItem(ItemRegistry.Hourai_Branch.get());
        this.basicItem(ItemRegistry.Against_the_World.get());
        this.basicItem(ItemRegistry.Origin_of_Life.get());
        this.basicItem(ItemRegistry.Imitation_Shirikodama.get());
        this.basicItem(ItemRegistry.Kittens_Water_Play.get());
        this.basicItem(ItemRegistry.Palace_of_the_Han.get());
        this.basicItem(ItemRegistry.All_Meat_Feast.get());
        this.basicItem(ItemRegistry.Urchin_Steamed_Egg.get());
        this.basicItem(ItemRegistry.Mushroom_Maidens_Tip_Tap_Pot.get());
        this.basicItem(ItemRegistry.Caution_Hellish_Spice.get());
        this.basicItem(ItemRegistry.Sea_Urchin_Sashimi.get());
        this.basicItem(ItemRegistry.Daimyos_Feast.get());
        this.basicItem(ItemRegistry.Kabuto_Steamed_Cake.get());
        this.basicItem(ItemRegistry.Bamboo_Spring.get());
        this.basicItem(ItemRegistry.Shirayuki.get());
        this.basicItem(ItemRegistry.Buddhas_Delight.get());
        this.basicItem(ItemRegistry.Lotus_Fish_Lamps.get());
        this.basicItem(ItemRegistry.Agony_Oden.get());
        this.basicItem(ItemRegistry.Seven_Colored_Yokan.get());
        this.basicItem(ItemRegistry.Niten_Ichiryu.get());
        this.basicItem(ItemRegistry.Heart_Trobbing_Surprise.get());
        this.basicItem(ItemRegistry.Sashimi_Platter.get());
        this.basicItem(ItemRegistry.Creamy_Crab.get());
        this.basicItem(ItemRegistry.Little_Sweet_Poision.get());
        this.basicItem(ItemRegistry.Cubic_Kedama_Volcanic_Tofu.get());
        this.basicItem(ItemRegistry.Lunar_Dango.get());
        this.basicItem(ItemRegistry.Molecular_Egg.get());
        this.basicItem(ItemRegistry.Ino_Shika_Chou.get());
        this.basicItem(ItemRegistry.Udumbara_Cake.get());
        this.basicItem(ItemRegistry.Natures_Beauty.get());
        this.basicItem(ItemRegistry.Cubic_Kedama_Ice_Cream.get());
        this.basicItem(ItemRegistry.Kitten_Pizza.get());
        this.basicItem(ItemRegistry.Burn_out_Pudding.get());
        this.basicItem(ItemRegistry.Rice_Powder_Meat.get());
        this.basicItem(ItemRegistry.Tempura_Platter.get());
        this.basicItem(ItemRegistry.White_Deer_Unyielding_Pine.get());
        this.basicItem(ItemRegistry.Italian_Risotto.get());
        this.basicItem(ItemRegistry.Imitation_Bear_Paw.get());
        this.basicItem(ItemRegistry.Cantonese_Char_Siu.get());
        this.basicItem(ItemRegistry.Sichuan_Boiled_Fish.get());
        this.basicItem(ItemRegistry.Lunar_Lover_Biscuit.get());
        this.basicItem(ItemRegistry.Hunters_Casserole.get());
        this.basicItem(ItemRegistry.Ceiling_Longing_Pie.get());
        this.basicItem(ItemRegistry.Kaguya_Hime.get());
        this.basicItem(ItemRegistry.Immortal_Turkey.get());
        this.basicItem(ItemRegistry.Golden_Ribs_Soup.get());
        this.basicItem(ItemRegistry.Golden_Two_Shroom_Wrap.get());
        this.basicItem(ItemRegistry.Instant_Death.get());
        this.basicItem(ItemRegistry.Secret_Savory_Mushroom_Hotpot.get());
        this.basicItem(ItemRegistry.Tonkotsu_Ramen.get());
        this.basicItem(ItemRegistry.Scholars_Ginkyo.get());
        this.basicItem(ItemRegistry.Classic_Steak.get());
        this.basicItem(ItemRegistry.Scarlet_Devil_Cake.get());
        this.basicItem(ItemRegistry.Unconscious_Youkai_Mousse.get());
        this.basicItem(ItemRegistry.Giant_Tamagoyaki.get());
        this.basicItem(ItemRegistry.Peach_Flower_Crystal_Ball.get());
        this.basicItem(ItemRegistry.Hot_Pepper_Soup.get());
        this.basicItem(ItemRegistry.Drunk_Shrimp_in_Bamboo.get());
        this.basicItem(ItemRegistry.Salmon_Steak.get());
        this.basicItem(ItemRegistry.Miasma_Garden.get());
        this.basicItem(ItemRegistry.Smoked_Buccaneer.get());
        this.basicItem(ItemRegistry.Vegetable_Salad.get());
        this.basicItem(ItemRegistry.Pure_White_Lotus.get());
        this.basicItem(ItemRegistry.Ordinary_Eat_Me_Cupcake.get());
        this.basicItem(ItemRegistry.Peach_Yatsuhashi.get());
        this.basicItem(ItemRegistry.Peach_Tapioca.get());
        this.basicItem(ItemRegistry.Real_Seafood_Miso_Soup.get());
        this.basicItem(ItemRegistry.Tianshis_Stewed_Mushrooms.get());
        this.basicItem(ItemRegistry.Shrimp_Stuffed_Pumpkin.get());
        this.basicItem(ItemRegistry.Energy_Skewer.get());
        this.basicItem(ItemRegistry.Falling_Blossoms.get());
        this.basicItem(ItemRegistry.Pine_Nut_Cake.get());
        this.basicItem(ItemRegistry.Yashouma_Dango.get());
        this.basicItem(ItemRegistry.Eel_Bowl_with_Egg.get());
        this.basicItem(ItemRegistry.Kitten_Canele.get());
        this.basicItem(ItemRegistry.Salmon_Tempura.get());
        this.basicItem(ItemRegistry.Kabayaki_Lampreys.get());
        this.basicItem(ItemRegistry.Peach_Braised_Pork.get());
        this.basicItem(ItemRegistry.Bamboo_Meat_Pot.get());
        this.basicItem(ItemRegistry.Crispy_Spirals.get());
        this.basicItem(ItemRegistry.Energy_Pudding.get());
        this.basicItem(ItemRegistry.Flowing_Somen.get());
        this.basicItem(ItemRegistry.Hodgepodge.get());
        this.basicItem(ItemRegistry.Steamed_Egg_Bamboo_Shoots.get());
        this.basicItem(ItemRegistry.Dorayaki.get());
        this.basicItem(ItemRegistry.Golden_Crispy_Fish_Cake.get());
        this.basicItem(ItemRegistry.Gloomy_Fruit_Pie.get());
        this.basicItem(ItemRegistry.Takoyaki.get());
        this.basicItem(ItemRegistry.Long_Hair_Princess.get());
        this.basicItem(ItemRegistry.Tangyuan.get());
        this.basicItem(ItemRegistry.Dumplings.get());
        this.basicItem(ItemRegistry.Eggs_Benedict.get());
        this.basicItem(ItemRegistry.Heart_Warming_Congee.get());
        this.basicItem(ItemRegistry.Power_Soup.get());
        this.basicItem(ItemRegistry.Mapo_Tofu.get());
        this.basicItem(ItemRegistry.Plum_Tea_Rice.get());
        this.basicItem(ItemRegistry.Sakura_Pudding.get());
        this.basicItem(ItemRegistry.Mochi.get());
        this.basicItem(ItemRegistry.Pink_Rice_Ball.get());
        this.basicItem(ItemRegistry.Secret_Dried_Fish_Crisps.get());
        this.basicItem(ItemRegistry.Toon_Pancake.get());
        this.basicItem(ItemRegistry.Candied_Sweet_Potato.get());
        this.basicItem(ItemRegistry.Honeyed_Chestnut.get());
        this.basicItem(ItemRegistry.Red_Bean_Daifuku.get());
        this.basicItem(ItemRegistry.Lions_Head.get());
        this.basicItem(ItemRegistry.Nigiri_Sushi.get());
        this.basicItem(ItemRegistry.Cream_of_Mushroom_Hotpot.get());
        this.basicItem(ItemRegistry.Fried_Lamprey.get());
        this.basicItem(ItemRegistry.Pork_Trout_Kebab.get());
        this.basicItem(ItemRegistry.Tomato_Fries.get());
        this.basicItem(ItemRegistry.Biscay_Biscuits.get());
        this.basicItem(ItemRegistry.Neko_Manma.get());
        this.basicItem(ItemRegistry.Cheese_Omelette.get());
        this.basicItem(ItemRegistry.Peach_Shrimp_Salad.get());
        this.basicItem(ItemRegistry.Pork_Bamboo_Shoots_Stir_Fry.get());
        this.basicItem(ItemRegistry.Fried_Pork_Cutlet.get());
        this.basicItem(ItemRegistry.Baked_Sweet_Potato.get());
        this.basicItem(ItemRegistry.Misery_Cheese_Sticks.get());
        this.basicItem(ItemRegistry.Stinky_Tofu.get());
        this.basicItem(ItemRegistry.Mushroom_Herb_Road.get());
        this.basicItem(ItemRegistry.Okonomiyaki.get());
        this.basicItem(ItemRegistry.Pancakes_With_Syrup.get());
        this.basicItem(ItemRegistry.Potato_Croquettes.get());
        this.basicItem(ItemRegistry.Boiled_Tofu.get());
        this.basicItem(ItemRegistry.Grilled_Lamprey.get());
        this.basicItem(ItemRegistry.Deep_Fried_Shrimp_Tempura.get());
        this.basicItem(ItemRegistry.Fresh_Tofu.get());
        this.basicItem(ItemRegistry.Miso_Tofu.get());
        this.basicItem(ItemRegistry.Carved_Rose_Salad.get());
        this.basicItem(ItemRegistry.Creamy_Vegetable_Chowder.get());
        this.basicItem(ItemRegistry.Pork_Bowl.get());
        this.basicItem(ItemRegistry.Beef_Bawl.get());
        this.basicItem(ItemRegistry.Unzan_Cotton_Candy.get());
        this.basicItem(ItemRegistry.Pork_Mushroom_Stir_Fry.get());
        this.basicItem(ItemRegistry.Fried_Cicada_Sloughs.get());
        this.basicItem(ItemRegistry.Tofu_Stew.get());
        this.basicItem(ItemRegistry.Roasted_Mushroom.get());
        this.basicItem(ItemRegistry.Dew_Runny_Eggs.get());
        this.basicItem(ItemRegistry.Deep_Fried_Tofu.get());
        this.basicItem(ItemRegistry.Pickles.get());
        this.basicItem(ItemRegistry.Pork_Stir_Fry.get());
        this.basicItem(ItemRegistry.Pork_Rice_Ball.get());
        this.basicItem(ItemRegistry.Scones.get());
        this.basicItem(ItemRegistry.Sea_Miso_soup.get());
        this.basicItem(ItemRegistry.Rice_Ball.get());

        this.blockItem(ItemRegistry.Grill_Block.get(), "block/grill");
        this.blockItem(ItemRegistry.Boiling_Pot.get(), "block/boiling_pot");
        this.blockItem(ItemRegistry.Frying_Pan.get(), "block/frying_pan");
        this.blockItem(ItemRegistry.Steamer.get(), "block/steamer");
        this.blockItem(ItemRegistry.Cutting_Board.get(), "block/cutting_board");
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
}
