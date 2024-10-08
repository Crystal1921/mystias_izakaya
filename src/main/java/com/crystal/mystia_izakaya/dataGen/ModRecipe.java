package com.crystal.mystia_izakaya.dataGen;

import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.dataGen.builder.MealRecipeBuilder;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.hiedacamellia.mystiasizakaya.registries.MIItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.crystal.mystia_izakaya.utils.FoodTagEnum.*;
import static com.crystal.mystia_izakaya.utils.UtilMethod.*;

public class ModRecipe extends RecipeProvider {
    public ModRecipe(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.MystiaFishingRod.asItem())
                .pattern("  a")
                .pattern(" ab")
                .pattern("a b")
                .define('a', Items.STICK) // Define what the symbol represents
                .define('b', Items.WHITE_WOOL)
                .unlockedBy("mystia_fishing_rod", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.MystiaFishingRod))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.RecipeBook.asItem())
                .requires(Items.BOOK)
                .requires(Items.WHEAT)
                .unlockedBy("mystia_recipe_book", InventoryChangeTrigger.TriggerInstance.hasItems(ItemRegistry.RecipeBook))
                .save(output);

        CookedMealRecipe((CookedMealItem) ItemRegistry.Oedo_Boat_Feast.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Dragonsong_Peach.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Planet_Mars.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Two_Flavor_Beef_Hotpot.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Mad_Hatters_Tea_Party.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Scrumptious_Storm.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Buddha_Jump_Over_The_Wall.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Beef_Wellington.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Dragon_Carp.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Eight_Trigram_Fish_Maws.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Supreme_Seafood_Noodles.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Faint_Dream.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Star_Lotus_Ship.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Rainbow_Pan_Fride_Pork_Buns.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Moonlight_over_the_Lotus_Pond.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Urchin_Raindrop_Cake.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Fujis_Lava.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Hourai_Branch.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Against_the_World.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Origin_of_Life.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Imitation_Shirikodama.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Kittens_Water_Play.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Palace_of_the_Han.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.All_Meat_Feast.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Urchin_Steamed_Egg.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Mushroom_Maidens_Tip_Tap_Pot.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Caution_Hellish_Spice.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Sea_Urchin_Sashimi.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Daimyos_Feast.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Kabuto_Steamed_Cake.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Bamboo_Spring.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Shirayuki.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Buddhas_Delight.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Lotus_Fish_Lamps.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Agony_Oden.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Seven_Colored_Yokan.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Niten_Ichiryu.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Heart_Trobbing_Surprise.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Sashimi_Platter.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Creamy_Crab.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Little_Sweet_Poision.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Cubic_Kedama_Volcanic_Tofu.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Lunar_Dango.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Molecular_Egg.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Ino_Shika_Chou.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Udumbara_Cake.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Natures_Beauty.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Cubic_Kedama_Ice_Cream.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Kitten_Pizza.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Burn_out_Pudding.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Rice_Powder_Meat.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Tempura_Platter.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.White_Deer_Unyielding_Pine.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Italian_Risotto.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Imitation_Bear_Paw.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Cantonese_Char_Siu.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Sichuan_Boiled_Fish.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Lunar_Lover_Biscuit.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Hunters_Casserole.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Ceiling_Longing_Pie.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Kaguya_Hime.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Immortal_Turkey.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Golden_Ribs_Soup.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Golden_Two_Shroom_Wrap.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Instant_Death.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Secret_Savory_Mushroom_Hotpot.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Tonkotsu_Ramen.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Scholars_Ginkyo.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Classic_Steak.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Scarlet_Devil_Cake.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Unconscious_Youkai_Mousse.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Giant_Tamagoyaki.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Peach_Flower_Crystal_Ball.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Hot_Pepper_Soup.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Drunk_Shrimp_in_Bamboo.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Salmon_Steak.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Miasma_Garden.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Smoked_Buccaneer.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Vegetable_Salad.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Pure_White_Lotus.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Ordinary_Eat_Me_Cupcake.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Peach_Yatsuhashi.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Peach_Tapioca.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Real_Seafood_Miso_Soup.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Tianshis_Stewed_Mushrooms.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Shrimp_Stuffed_Pumpkin.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Energy_Skewer.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Falling_Blossoms.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Pine_Nut_Cake.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Yashouma_Dango.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Eel_Bowl_with_Egg.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Kitten_Canele.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Salmon_Tempura.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Kabayaki_Lampreys.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Peach_Braised_Pork.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Bamboo_Meat_Pot.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Crispy_Spirals.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Energy_Pudding.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Flowing_Somen.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Hodgepodge.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Steamed_Egg_Bamboo_Shoots.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Dorayaki.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Golden_Crispy_Fish_Cake.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Gloomy_Fruit_Pie.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Takoyaki.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Long_Hair_Princess.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Tangyuan.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Dumplings.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Eggs_Benedict.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Heart_Warming_Congee.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Power_Soup.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Mapo_Tofu.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Plum_Tea_Rice.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Sakura_Pudding.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Mochi.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Pink_Rice_Ball.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Secret_Dried_Fish_Crisps.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Toon_Pancake.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Candied_Sweet_Potato.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Honeyed_Chestnut.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Red_Bean_Daifuku.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Lions_Head.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Nigiri_Sushi.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Cream_of_Mushroom_Hotpot.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Fried_Lamprey.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Pork_Trout_Kebab.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Tomato_Fries.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Biscay_Biscuits.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Neko_Manma.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Cheese_Omelette.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Peach_Shrimp_Salad.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Pork_Bamboo_Shoots_Stir_Fry.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Fried_Pork_Cutlet.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Baked_Sweet_Potato.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Misery_Cheese_Sticks.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Stinky_Tofu.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Mushroom_Herb_Road.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Okonomiyaki.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Pancakes_With_Syrup.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Potato_Croquettes.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Boiled_Tofu.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Grilled_Lamprey.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Deep_Fried_Shrimp_Tempura.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Fresh_Tofu.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Miso_Tofu.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Carved_Rose_Salad.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Creamy_Vegetable_Chowder.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Pork_Bowl.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Beef_Bawl.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Unzan_Cotton_Candy.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Pork_Mushroom_Stir_Fry.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Fried_Cicada_Sloughs.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Tofu_Stew.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Roasted_Mushroom.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Dew_Runny_Eggs.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Deep_Fried_Tofu.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Pickles.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Pork_Stir_Fry.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Pork_Rice_Ball.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Scones.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Sea_Miso_soup.get(), output);
        CookedMealRecipe((CookedMealItem) ItemRegistry.Rice_Ball.get(), output);

        CookedMealRecipe((CookedMealItem) ItemRegistry.Dark_Matter.get(), output);

        CookedMealRecipe(MIItem.DA_JIANG_HU_CHUAN_JI.get(), new Item[]{MIItem.SAN_WEN_YU.asItem(), MIItem.JIN_QIANG_YU.asItem(), MIItem.JI_SHANG_JIN_QIANG_YU.asItem(), MIItem.ZUN_YU.asItem(), MIItem.BING_KUAI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Aquatic,Premium,Legendary,Good_Alcohol,Sea_Delicacy,Japanese,Fresh,Raw,Signature,Photogenic,Cultural_Heritage), List.of(Empty), 24, output);
        CookedMealRecipe(MIItem.LONG_YIN_TAO_ZI.get(), new Item[]{MIItem.KE_KE_DOU.asItem(), MIItem.TAO_ZI.asItem(), MIItem.TAO_ZI.asItem(), MIItem.TAO_ZI.asItem(), MIItem.TAO_ZI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Premium,Legendary,Mild,Sweet,Refreshing,Wonderful,Fruity,Specialty), List.of(Fungus,Meat,Sea_Delicacy,Peculiar,Raw), 18, output);
        CookedMealRecipe(MIItem.HUO_XING.get(), new Item[]{MIItem.PANG_XIE.asItem(), MIItem.XU_LI.asItem(), MIItem.PU_TAO.asItem(), MIItem.LU_SHUI.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Aquatic,Premium,Legendary,Sea_Delicacy,Photogenic,Cultural_Heritage,Wonderful,Fruity), List.of(Mountain_Delicacy), 24, output);
        CookedMealRecipe(MIItem.NIU_ROU_YUAN_YANG_HUO_GUO.get(), new Item[]{MIItem.NIU_ROU.asItem(), MIItem.HE_NIU.asItem(), MIItem.LA_JIAO.asItem(), MIItem.LUO_BU.asItem(), MIItem.SONG_LU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Meat,Homecooking,Mountain_Delicacy,Chinese,Hot,Strength_Boosting,Fungus,Spicy), List.of(Refreshing,Dreamy), 5, output);
        CookedMealRecipe(MIItem.FENG_MAO_ZI_CHA_HUI.get(), new Item[]{MIItem.KE_KE_DOU.asItem(), MIItem.NAI_YOU.asItem(), MIItem.MIAN_FEN.asItem(), MIItem.XI_LAN_HUA.asItem(), MIItem.MO_GU.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Western,Sweet,Photogenic,Fungus,Wonderful,Dreamy,Specialty), List.of(Greasy), 15, output);
        CookedMealRecipe(MIItem.HUAN_XIANG_FENG_MI.get(), new Item[]{MIItem.YANG_CONG.asItem(), MIItem.YE_ZHU_ROU.asItem(), MIItem.NIU_ROU.asItem(), MIItem.SONG_LU.asItem(), MIItem.XI_HONG_SHI.asItem()},CookerTypeEnum.Grill, List.of(Expensive,Meat,Greasy,Filling,Raw,Signature,Photogenic,Strength_Boosting), List.of(Refreshing,Mild), 18, output);
        CookedMealRecipe(MIItem.HUAN_XIANG_FOU_TIAO_QIANG.get(), new Item[]{MIItem.HE_NIU.asItem(), MIItem.JI_SHANG_JIN_QIANG_YU.asItem(), MIItem.HEI_MAO_ZHU_ROU.asItem(), MIItem.HE_TUN.asItem(), MIItem.SONG_LU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Meat,Aquatic,Premium,Legendary,Mountain_Delicacy,Chinese,Photogenic,Strength_Boosting,Cultural_Heritage,Fungus,Specialty), List.of(Empty), 18, output);
        CookedMealRecipe(MIItem.HUI_LING_DUN_NIU_PAI.get(), new Item[]{MIItem.HE_NIU.asItem(), MIItem.JI_DAN.asItem(), MIItem.MIAN_FEN.asItem(), MIItem.HUANG_YOU.asItem(), MIItem.SONG_LU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Expensive,Meat,Premium,Legendary,Mountain_Delicacy,Western), List.of(Sweet,Refreshing), 14, output);
        CookedMealRecipe(MIItem.YU_YUE_LONG_MEN.get(), new Item[]{MIItem.JI_SHANG_JIN_QIANG_YU.asItem(), MIItem.LU_ROU.asItem(), MIItem.FENG_MI.asItem(), MIItem.YUE_GUANG_CAO.asItem(), MIItem.SONG_LU.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Large_Portion,Meat,Aquatic,Premium,Sea_Delicacy,Chinese,Fresh,Sweet,Cultural_Heritage,Fungus,Dreamy), List.of(Empty), 12, output);
        CookedMealRecipe(MIItem.TAI_JI_BA_GUA_YU_DU.get(), new Item[]{MIItem.JI_SHANG_JIN_QIANG_YU.asItem(), MIItem.MO_GU.asItem(), MIItem.LUO_BU.asItem(), MIItem.JI_DAN.asItem(), MIItem.BAI_GUO.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Aquatic,Premium,Mild,Fresh,Refreshing,Cultural_Heritage), List.of(Empty), 14, output);
        CookedMealRecipe(MIItem.ZHI_ZHUNG_HAI_XIAN_MIAN.get(), new Item[]{MIItem.JI_SHANG_JIN_QIANG_YU.asItem(), MIItem.HAI_TAI.asItem(), MIItem.XIA.asItem(), MIItem.ZHANG_YU.asItem(), MIItem.PANG_XIE.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Aquatic,Homecooking,Premium,Filling,Sea_Delicacy,Fresh), List.of(Empty), 10, output);
        CookedMealRecipe(MIItem.YOU_MENG.get(), new Item[]{MIItem.XIAN_HUA.asItem(), MIItem.HUAN_TAN_HUA.asItem(), MIItem.YUE_GUANG_CAO.asItem(), MIItem.LU_SHUI.asItem(), MIItem.NAI_YOU.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Premium,Mild,Western,Sweet,Photogenic,Refreshing,Dreamy), List.of(Meat,Good_Alcohol,Aquatic), 12, output);
        CookedMealRecipe(MIItem.HUAN_XIANG_XING_LIAN_CHUAN.get(), new Item[]{MIItem.NAN_GUA.asItem(), MIItem.LIAN_ZI.asItem(), MIItem.JIN_QIANG_YU.asItem(), MIItem.BING_DI_LIAN.asItem(), MIItem.YUE_GUANG_CAO.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Premium,Fresh,Raw,Signature,Photogenic,Refreshing,Wonderful,Dreamy,Specialty), List.of(Peculiar), 13, output);
        CookedMealRecipe(MIItem.HUA_GUANG_YU_JIAN_BAO.get(), new Item[]{MIItem.HEI_MAO_ZHU_ROU.asItem(), MIItem.MO_GU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Expensive,Meat,Premium,Legendary,Chinese,Fungus,Dreamy), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.HE_TANG_YUE_SHE.get(), new Item[]{MIItem.PU_TAO.asItem(), MIItem.XU_LI.asItem(), MIItem.NAI_YOU.asItem(), MIItem.YIN_ER.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Premium,Mild,Chinese,Sweet,Photogenic,Cultural_Heritage,Refreshing), List.of(Meat,Peculiar,Good_Alcohol,Hot), 12, output);
        CookedMealRecipe(MIItem.HAI_DAN_XIN_XUAN_BING.get(), new Item[]{MIItem.HAI_DAN.asItem(), MIItem.YIN_ER.asItem(), MIItem.JIN_QIANG_YU.asItem(), MIItem.LU_SHUI.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Aquatic,Premium,Small_Portion,Refreshing,Dreamy), List.of(Filling), 12, output);
        CookedMealRecipe(MIItem.YAN_JIANG.get(), new Item[]{MIItem.NIU_ROU.asItem(), MIItem.HE_TUN.asItem(), MIItem.HE_NIU.asItem(), MIItem.SONG_LU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Meat,Aquatic,Premium,Filling,Hot,Strength_Boosting,Fungus), List.of(Refreshing), 8, output);
        CookedMealRecipe(MIItem.PENG_LAI_YU_ZHI.get(), new Item[]{MIItem.ZHU_ZI.asItem(), MIItem.ZHU_ROU.asItem(), MIItem.SAN_WEN_YU.asItem(), MIItem.HE_NIU.asItem(), MIItem.LU_ROU.asItem()},CookerTypeEnum.Grill, List.of(Expensive,Meat,Premium,Legendary,Cultural_Heritage,Grilled), List.of(Empty), 13, output);
        CookedMealRecipe(MIItem.NI_ZHUAN_TIAN_DI.get(), new Item[]{MIItem.ZHU_ZI.asItem(), MIItem.XIAN_HUA.asItem(), MIItem.MEI_ZI.asItem(), MIItem.HEI_MAO_ZHU_ROU.asItem(), MIItem.SONG_LU.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Mountain_Delicacy,Refreshing,Peculiar,Fungus,Wonderful,Dreamy,Aura_Bursting), List.of(Empty), 12, output);
        CookedMealRecipe(MIItem.SHENG_MING_ZHI_YUAN.get(), new Item[]{MIItem.KE_KE_DOU.asItem(), MIItem.YIN_ER.asItem(), MIItem.NAN_GUA.asItem(), MIItem.LU_SHUI.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Premium,Legendary,Mild,Raw,Fungus,Wonderful,Soup), List.of(Mountain_Delicacy), 13, output);
        CookedMealRecipe(MIItem.NI_JIU_ZI_YU.get(), new Item[]{MIItem.LU_ROU.asItem(), MIItem.SONG_LU.asItem(), MIItem.CHAN_SHUI.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Legendary,Good_Alcohol,Hot,Peculiar,Small_Portion,Dreamy), List.of(Empty), 12, output);
        CookedMealRecipe(MIItem.MAO_MI_XI_SHUI.get(), new Item[]{MIItem.TAO_ZI.asItem(), MIItem.NAI_YOU.asItem(), MIItem.XU_LI.asItem(), MIItem.KE_KE_DOU.asItem(), MIItem.MIAN_FEN.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Vegetarian,Sweet,Photogenic,Refreshing,Wonderful,Dreamy), List.of(Good_Alcohol,Hot), 12, output);
        CookedMealRecipe(MIItem.HAN_GONG_CHANG_JIAO.get(), new Item[]{MIItem.BA_MU_MAN.asItem(), MIItem.DOU_FU.asItem(), MIItem.PANG_XIE.asItem(), MIItem.ZHU_ZI.asItem(), MIItem.LU_SHUI.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Aquatic,Premium,Legendary,Chinese,Peculiar,Cultural_Heritage,Soup), List.of(Greasy), 12, output);
        CookedMealRecipe(MIItem.QUAN_ROU_SHENG_YAN.get(), new Item[]{MIItem.YE_ZHU_ROU.asItem(), MIItem.HEI_MAO_ZHU_ROU.asItem(), MIItem.LU_ROU.asItem(), MIItem.HE_NIU.asItem()},CookerTypeEnum.Grill, List.of(Expensive,Premium,Meat,Good_Alcohol,Large_Portion,Mountain_Delicacy,Salty,Hot,Photogenic), List.of(Empty), 14, output);
        CookedMealRecipe(MIItem.HAI_DAN_ZHENG_DAN.get(), new Item[]{MIItem.HAI_DAN.asItem(), MIItem.JI_DAN.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Sea_Delicacy,Fresh,Photogenic), List.of(Mountain_Delicacy), 7, output);
        CookedMealRecipe(MIItem.MO_NV_DE_WU_TA_HUI.get(), new Item[]{MIItem.MO_GU.asItem(), MIItem.XIA.asItem(), MIItem.ZHANG_YU.asItem(), MIItem.LA_JIAO.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Aquatic,Greasy,Salty,Fresh,Photogenic,Hot,Fungus,Spicy), List.of(Empty), 14, output);
        CookedMealRecipe(MIItem.DI_YU_JI_XIN_JIN_GAO.get(), new Item[]{MIItem.LA_JIAO.asItem(), MIItem.LA_JIAO.asItem(), MIItem.LA_JIAO.asItem(), MIItem.ZHI_SHI.asItem(), MIItem.NIU_ROU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Expensive,Meat,Greasy,Salty,Photogenic,Hot,Strength_Boosting,Peculiar,Spicy), List.of(Mild,Vegetarian), 12, output);
        CookedMealRecipe(MIItem.HAI_DAN_CI_SHEN.get(), new Item[]{MIItem.HAI_DAN.asItem(), MIItem.LU_SHUI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Premium,Sweet,Specialty,Sea_Delicacy,Photogenic,Wonderful,Small_Portion), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.DA_SHE_YAN.get(), new Item[]{MIItem.HEI_MAO_ZHU_ROU.asItem(), MIItem.HE_TUN.asItem(), MIItem.HE_NIU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Meat,Aquatic,Premium,Filling,Mountain_Delicacy), List.of(Homecooking,Economical), 10, output);
        CookedMealRecipe(MIItem.DOU_JIA_ZHENG_GAO.get(), new Item[]{MIItem.MIAN_FEN.asItem(), MIItem.HEI_MAO_ZHU_ROU.asItem(), MIItem.FENG_MI.asItem(), MIItem.CHAN_SHUI.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Premium,Filling,Fresh,Raw,Signature,Photogenic,Strength_Boosting,Peculiar,Specialty), List.of(Empty), 12, output);
        CookedMealRecipe(MIItem.CHUI_ZHU_YIN_CHUN.get(), new Item[]{MIItem.HUANG_GUA.asItem(), MIItem.JI_DAN.asItem(), MIItem.LUO_BU.asItem(), MIItem.LU_ROU.asItem(), MIItem.YUE_GUANG_CAO.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Premium,Mountain_Delicacy,Signature,Photogenic,Cultural_Heritage), List.of(Peculiar,Fungus), 14, output);
        CookedMealRecipe(MIItem.BAI_XUE.get(), new Item[]{MIItem.HAI_TAI.asItem(), MIItem.BA_MU_MAN.asItem(), MIItem.HE_TUN.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Meat,Aquatic,Premium,Japanese,Cultural_Heritage), List.of(Empty), 12, output);
        CookedMealRecipe(MIItem.LUO_HAN_SHANG_SU.get(), new Item[]{MIItem.HUAN_TAN_HUA.asItem(), MIItem.ZHU_SUN.asItem(), MIItem.SONG_LU.asItem(), MIItem.SONG_ZI.asItem(), MIItem.LIAN_ZI.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Vegetarian,Premium,Mild,Fresh,Refreshing,Cultural_Heritage,Dreamy,Specialty), List.of(Meat,Spicy), 12, output);
        CookedMealRecipe(MIItem.HE_HUA_YU_MI_ZHAN.get(), new Item[]{MIItem.JI_SHANG_JIN_QIANG_YU.asItem(), MIItem.BING_DI_LIAN.asItem(), MIItem.LIAN_ZI.asItem(), MIItem.LU_SHUI.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Aquatic,Legendary,Mild,Chinese,Cultural_Heritage,Wonderful,Dreamy), List.of(Empty), 11, output);
        CookedMealRecipe(MIItem.JUE_JIAO_GUAN_DOU_ZHU.get(), new Item[]{MIItem.LA_JIAO.asItem(), MIItem.LA_JIAO.asItem(), MIItem.NIU_ROU.asItem(), MIItem.DOU_FU.asItem(), MIItem.LUO_BU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Large_Portion,Meat,Premium,Filling,Fresh,Hot,Strength_Boosting), List.of(Empty), 12, output);
        CookedMealRecipe(MIItem.QI_SHE_YANG_GENG.get(), new Item[]{MIItem.HAI_TAI.asItem(), MIItem.PU_TAO.asItem(), MIItem.HUAN_TAN_HUA.asItem(), MIItem.LU_SHUI.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Premium,Sweet,Photogenic,Cultural_Heritage,Wonderful,Dreamy,Fruity), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.ER_TIAN_LIU.get(), new Item[]{MIItem.HEI_MAO_ZHU_ROU.asItem(), MIItem.YE_ZHU_ROU.asItem()},CookerTypeEnum.Grill, List.of(Expensive,Meat,Premium,Mountain_Delicacy,Cultural_Heritage,Grilled,Aura_Bursting), List.of(Homecooking), 18, output);
        CookedMealRecipe(MIItem.JIN_XIA_DA_MAO_XIAN.get(), new Item[]{MIItem.MO_GU.asItem(), MIItem.HUAN_TAN_HUA.asItem(), MIItem.FENG_MI.asItem(), MIItem.NAI_YOU.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Photogenic,Strength_Boosting,Peculiar,Wonderful,Dreamy,Specialty), List.of(Homecooking), 12, output);
        CookedMealRecipe(MIItem.CI_SHEN_PIN_PAN.get(), new Item[]{MIItem.JIN_QIANG_YU.asItem(), MIItem.SAN_WEN_YU.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Aquatic,Premium,Japanese,Raw,Photogenic), List.of(Hot), 5, output);
        CookedMealRecipe(MIItem.NAI_YOU_JU_XIE.get(), new Item[]{MIItem.NAI_YOU.asItem(), MIItem.PANG_XIE.asItem()},CookerTypeEnum.Frying_Pan, List.of(Expensive,Premium,Good_Alcohol,Sea_Delicacy,Fresh,Signature,Photogenic), List.of(Empty), 12, output);
        CookedMealRecipe(MIItem.XIAO_XIAO_DE_TIAN_MI_DU_YAO.get(), new Item[]{MIItem.HUAN_TAN_HUA.asItem(), MIItem.NAI_YOU.asItem(), MIItem.PU_TAO.asItem(), MIItem.BAI_GUO.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Premium,Sweet,Photogenic,Small_Portion,Dreamy), List.of(Meat), 10, output);
        CookedMealRecipe(MIItem.MAO_YU_RONG_YAN_DOU_FU.get(), new Item[]{MIItem.DOU_FU.asItem(), MIItem.LA_JIAO.asItem(), MIItem.NIU_ROU.asItem(), MIItem.YANG_CONG.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Vegetarian,Chinese,Fresh,Photogenic,Wonderful), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.YUE_GUANG_TUAN_ZI.get(), new Item[]{MIItem.NUO_MI.asItem(), MIItem.YUE_GUANG_CAO.asItem()},CookerTypeEnum.Cutting_Board, List.of(Japanese,Sweet,Expensive,Wonderful,Specialty), List.of(Meat,Aquatic,Fresh,Salty), 8, output);
        CookedMealRecipe(MIItem.FENG_ZI_DAN.get(), new Item[]{MIItem.KE_KE_DOU.asItem(), MIItem.NAI_YOU.asItem(), MIItem.NAN_GUA.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Premium,Vegetarian,Mild,Wonderful,Sweet,Small_Portion), List.of(Mountain_Delicacy), 7, output);
        CookedMealRecipe(MIItem.ZHU_LU_DIE.get(), new Item[]{MIItem.ZHU_ROU.asItem(), MIItem.LU_ROU.asItem(), MIItem.YUE_GUANG_CAO.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Meat,Premium,Photogenic,Cultural_Heritage), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.HUAN_TAN_HUA_GAO.get(), new Item[]{MIItem.HUAN_TAN_HUA.asItem(), MIItem.LU_SHUI.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Premium,Legendary,Sweet,Photogenic,Dreamy,Wonderful), List.of(Meat,Aquatic), 7, output);
        CookedMealRecipe(MIItem.HUA_NIAO_FENG_YUE.get(), new Item[]{MIItem.XIAN_HUA.asItem(), MIItem.YUE_GUANG_CAO.asItem(), MIItem.NAI_YOU.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Premium,Wonderful,Dreamy,Specialty), List.of(Hot,Greasy), 9, output);
        CookedMealRecipe(MIItem.MAO_YU_SAN_SE_BING_JI_LING.get(), new Item[]{MIItem.LU_SHUI.asItem(), MIItem.DOU_FU.asItem(), MIItem.FENG_MI.asItem(), MIItem.JI_DAN.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Western,Sweet,Photogenic,Refreshing,Dreamy), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.MAO_MI_PI_SHA.get(), new Item[]{MIItem.MO_GU.asItem(), MIItem.YANG_CONG.asItem(), MIItem.XI_LAN_HUA.asItem(), MIItem.YE_ZHU_ROU.asItem()},CookerTypeEnum.Grill, List.of(Expensive,Filling,Western,Fungus,Photogenic), List.of(Refreshing), 10, output);
        CookedMealRecipe(MIItem.RAN_JING_BU_DING.get(), new Item[]{MIItem.FENG_MI.asItem(), MIItem.PU_TAO.asItem(), MIItem.NING_MENG.asItem(), MIItem.NING_MENG.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Sweet,Signature,Refreshing,Strength_Boosting,Small_Portion,Dreamy,Fruity,Sour), List.of(Greasy,Salty), 8, output);
        CookedMealRecipe(MIItem.ZHU_TONG_FEN_ZHENG_DAN.get(), new Item[]{MIItem.ZHU_ZI.asItem(), MIItem.LU_SHUI.asItem(), MIItem.HEI_MAO_ZHU_ROU.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Meat,Homecooking,Mountain_Delicacy), List.of(Raw), 9, output);
        CookedMealRecipe(MIItem.SHI_JIN_TIAN_FU_LUO.get(), new Item[]{MIItem.HEI_MAO_ZHU_ROU.asItem(), MIItem.SONG_LU.asItem(), MIItem.BA_MU_MAN.asItem(), MIItem.YUE_GUANG_CAO.asItem()},CookerTypeEnum.Frying_Pan, List.of(Expensive,Homecooking,Greasy,Good_Alcohol,Japanese,Signature,Strength_Boosting,Fungus), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.BAI_LU_ZHEN_SONG.get(), new Item[]{MIItem.LU_ROU.asItem(), MIItem.BAI_GUO.asItem(), MIItem.SONG_ZI.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Meat,Premium,Mountain_Delicacy,Cultural_Heritage,Specialty), List.of(Sour), 12, output);
        CookedMealRecipe(MIItem.YI_SHI_HUI_FAN.get(), new Item[]{MIItem.YANG_CONG.asItem(), MIItem.MO_GU.asItem(), MIItem.ZHU_SUN.asItem(), MIItem.HUANG_YOU.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Filling,Western,Fresh,Fungus), List.of(Sweet), 6, output);
        CookedMealRecipe(MIItem.SAI_XIONG_ZHANG.get(), new Item[]{MIItem.HEI_MAO_ZHU_ROU.asItem(), MIItem.HE_TUN.asItem(), MIItem.ZHU_SUN.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Meat,Aquatic,Premium,Mountain_Delicacy,Fresh,Strength_Boosting,Wonderful), List.of(Empty), 12, output);
        CookedMealRecipe(MIItem.MI_ZHI_CHA_SHAO.get(), new Item[]{MIItem.ZHU_ROU.asItem(), MIItem.FENG_MI.asItem()},CookerTypeEnum.Grill, List.of(Expensive,Meat,Greasy,Chinese,Sweet,Wonderful), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.SHUI_ZHU_YU.get(), new Item[]{MIItem.ZUN_YU.asItem(), MIItem.LA_JIAO.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Aquatic,Chinese,Hot,Spicy,Aura_Bursting), List.of(Sweet,Fruity,Refreshing,Meat), 8, output);
        CookedMealRecipe(MIItem.YUE_ZHI_LIAN_REN.get(), new Item[]{MIItem.HUANG_YOU.asItem(), MIItem.MIAN_FEN.asItem(), MIItem.JI_DAN.asItem(), MIItem.YUE_GUANG_CAO.asItem()},CookerTypeEnum.Cutting_Board, List.of(Expensive,Sweet,Small_Portion,Photogenic,Specialty), List.of(Meat,Vegetarian,Aquatic), 10, output);
        CookedMealRecipe(MIItem.YE_WEI_JIA_NONG.get(), new Item[]{MIItem.HEI_MAO_ZHU_ROU.asItem(), MIItem.TU_DOU.asItem(), MIItem.NAN_GUA.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Meat,Greasy,Filling,Mountain_Delicacy,Hot), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.YANG_WANG_TIAN_HUA_BAN_PAI.get(), new Item[]{MIItem.ZUN_YU.asItem(), MIItem.MIAN_FEN.asItem(), MIItem.TAO_ZI.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Sea_Delicacy,Good_Alcohol,Signature,Photogenic,Peculiar,Specialty), List.of(Meat), 9, output);
        CookedMealRecipe(MIItem.ZHU_QU_JI.get(), new Item[]{MIItem.ZHU_ZI.asItem(), MIItem.ZHU_SUN.asItem(), MIItem.SONG_LU.asItem(), MIItem.HEI_MAO_ZHU_ROU.asItem(), MIItem.BAI_GUO.asItem()},CookerTypeEnum.Steamer, List.of(Expensive,Meat,Premium,Legendary,Japanese,Photogenic,Cultural_Heritage,Specialty), List.of(Empty), 12, output);
        CookedMealRecipe(MIItem.BU_SI_NIAO.get(), new Item[]{MIItem.MIAN_FEN.asItem(), MIItem.FENG_MI.asItem(), MIItem.TU_DOU.asItem(), MIItem.LUO_BU.asItem(), MIItem.YANG_CONG.asItem()},CookerTypeEnum.Grill, List.of(Expensive,Premium,Legendary,Western,Photogenic,Grilled,Aura_Bursting), List.of(Empty), 12, output);
        CookedMealRecipe(MIItem.BAI_GUO_LUO_BU_PAI_GU_TANG.get(), new Item[]{MIItem.BAI_GUO.asItem(), MIItem.LUO_BU.asItem(), MIItem.ZHU_ROU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Meat,Chinese,Hot,Soup), List.of(Empty), 6, output);
        CookedMealRecipe(MIItem.XIANG_JIAN_SHUANG_GU_ROU_JUAN.get(), new Item[]{MIItem.ZHU_ROU.asItem(), MIItem.MO_GU.asItem(), MIItem.SONG_LU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Expensive,Meat,Homecooking,Greasy,Good_Alcohol,Signature,Hot,Fungus), List.of(Refreshing), 9, output);
        CookedMealRecipe(MIItem.YI_JI_BI_SHA.get(), new Item[]{MIItem.YE_ZHU_ROU.asItem(), MIItem.LU_ROU.asItem(), MIItem.YANG_CONG.asItem()},CookerTypeEnum.Grill, List.of(Expensive,Meat,Greasy,Filling,Grilled,Mountain_Delicacy,Strength_Boosting), List.of(Empty), 9, output);
        CookedMealRecipe(MIItem.MI_ZHI_XIAN_JUN_BAO.get(), new Item[]{MIItem.MO_GU.asItem(), MIItem.SONG_LU.asItem(), MIItem.LU_SHUI.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Expensive,Japanese,Fresh,Fungus,Specialty), List.of(Empty), 9, output);
        CookedMealRecipe(MIItem.TUN_GU_LA_MIAN.get(), new Item[]{MIItem.ZHU_ROU.asItem(), MIItem.HAI_TAI.asItem(), MIItem.JI_DAN.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Meat,Homecooking,Filling,Salty), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.SHI_LI_YIN_XING.get(), new Item[]{MIItem.BAI_GUO.asItem(), MIItem.FENG_MI.asItem()},CookerTypeEnum.Steamer, List.of(Vegetarian,Sweet,Chinese,Cultural_Heritage), List.of(Salty), 8, output);
        CookedMealRecipe(MIItem.HUANG_YOU_NIU_PAI.get(), new Item[]{MIItem.HE_NIU.asItem(), MIItem.HUANG_YOU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Meat,Greasy,Filling,Western), List.of(Sweet,Refreshing), 7, output);
        CookedMealRecipe(MIItem.XING_HONG_E_MO_DAN_GAO.get(), new Item[]{MIItem.LU_SHUI.asItem(), MIItem.NAN_GUA.asItem(), MIItem.TU_DOU.asItem(), MIItem.FENG_MI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Western,Sweet,Photogenic,Peculiar,Dreamy), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.WU_YI_SHI_YAO_GUAI_MU_SI.get(), new Item[]{MIItem.DOU_FU.asItem(), MIItem.HUANG_YOU.asItem(), MIItem.YANG_CONG.asItem(), MIItem.FENG_MI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Western,Sweet,Photogenic,Premium,Dreamy), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.JU_REN_YU_ZI_SHAO.get(), new Item[]{MIItem.MIAN_FEN.asItem(), MIItem.MIAN_FEN.asItem(), MIItem.JI_DAN.asItem(), MIItem.JI_DAN.asItem()},CookerTypeEnum.Frying_Pan, List.of(Premium,Filling,Japanese,Sweet,Strength_Boosting), List.of(Good_Alcohol), 12, output);
        CookedMealRecipe(MIItem.TAO_HUA_LIU_LI_JUAN.get(), new Item[]{MIItem.TAO_ZI.asItem(), MIItem.XU_LI.asItem(), MIItem.HONG_DOU.asItem()},CookerTypeEnum.Steamer, List.of(Premium,Japanese,Sweet,Small_Portion,Photogenic,Specialty,Dreamy), List.of(Meat,Peculiar,Filling,Fungus), 8, output);
        CookedMealRecipe(MIItem.HU_LA_TANG.get(), new Item[]{MIItem.NIU_ROU.asItem(), MIItem.LA_JIAO.asItem(), MIItem.DOU_FU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Homecooking,Chinese,Hot,Aura_Bursting,Soup,Spicy), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.ZHU_TONG_SHAO_ZUI_XIA.get(), new Item[]{MIItem.ZHU_ZI.asItem(), MIItem.XIA.asItem(), MIItem.XI_LAN_HUA.asItem()},CookerTypeEnum.Cutting_Board, List.of(Aquatic,Fresh,Raw,Peculiar), List.of(Filling), 5, output);
        CookedMealRecipe(MIItem.XIANG_JIAN_SAN_WEN_YU.get(), new Item[]{MIItem.SAN_WEN_YU.asItem(), MIItem.ZHU_SUN.asItem()},CookerTypeEnum.Frying_Pan, List.of(Meat,Western,Fresh), List.of(Empty), 10, output);
        CookedMealRecipe(MIItem.DU_ZHANG_HUA_YUAN.get(), new Item[]{MIItem.HE_TUN.asItem(), MIItem.MEI_ZI.asItem(), MIItem.BA_MU_MAN.asItem(), MIItem.BAI_GUO.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Aquatic,Signature,Peculiar,Poison), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.HAI_DAO_XUN_ROU.get(), new Item[]{MIItem.NIU_ROU.asItem(), MIItem.HEI_YAN.asItem(), MIItem.LA_JIAO.asItem(), MIItem.FENG_MI.asItem()},CookerTypeEnum.Grill, List.of(Large_Portion,Meat,Legendary,Strength_Boosting,Specialty), List.of(Sour), 9, output);
        CookedMealRecipe(MIItem.SHU_CAI_ZHUAN_JI.get(), new Item[]{MIItem.YANG_CONG.asItem(), MIItem.TU_DOU.asItem(), MIItem.NAN_GUA.asItem()},CookerTypeEnum.Cutting_Board, List.of(Vegetarian,Mild,Raw,Refreshing), List.of(Meat,Aquatic,Hot), 5, output);
        CookedMealRecipe(MIItem.SHENG_BAI_LIAN_ZI_GAO.get(), new Item[]{MIItem.BAI_GUO.asItem(), MIItem.LIAN_ZI.asItem(), MIItem.MIAN_FEN.asItem(), MIItem.HUANG_YOU.asItem()},CookerTypeEnum.Steamer, List.of(Vegetarian,Mild,Photogenic,Small_Portion,Specialty), List.of(Spicy), 10, output);
        CookedMealRecipe(MIItem.PU_TONG_XIA_DAN_GAO.get(), new Item[]{MIItem.JI_DAN.asItem(), MIItem.PU_TAO.asItem(), MIItem.NAI_YOU.asItem()},CookerTypeEnum.Steamer, List.of(Premium,Sweet,Photogenic,Cultural_Heritage,Fruity), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.BAI_TAO_SHENG_BA_QIAO.get(), new Item[]{MIItem.NUO_MI.asItem(), MIItem.TAO_ZI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Japanese,Sweet,Fruity), List.of(Meat,Aquatic,Fresh,Salty), 5, output);
        CookedMealRecipe(MIItem.TAO_HUA_GENG.get(), new Item[]{MIItem.TAO_ZI.asItem(), MIItem.LU_SHUI.asItem(), MIItem.BING_KUAI.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Vegetarian,Sweet,Photogenic,Refreshing,Fruity,Soup), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.ZHEN_HAI_XIAN_WEI_CHENG_TANG.get(), new Item[]{MIItem.SAN_WEN_YU.asItem(), MIItem.ZUN_YU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Aquatic,Homecooking,Mild,Soup), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.TIAN_SHI_BAN_LI_MENG_GU.get(), new Item[]{MIItem.BAN_LI.asItem(), MIItem.MO_GU.asItem(), MIItem.SONG_LU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Vegetarian,Homecooking,Chinese,Fungus,Specialty), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.NAN_GUA_XIA_ZHONG.get(), new Item[]{MIItem.NAN_GUA.asItem(), MIItem.XIA.asItem(), MIItem.DOU_FU.asItem()},CookerTypeEnum.Steamer, List.of(Aquatic,Mild,Filling,Fresh,Sweet,Photogenic,Specialty), List.of(Empty), 9, output);
        CookedMealRecipe(MIItem.NENG_LIANG_CHUAN.get(), new Item[]{MIItem.NIU_ROU.asItem(), MIItem.YANG_CONG.asItem(), MIItem.NAN_GUA.asItem()},CookerTypeEnum.Grill, List.of(Meat,Filling,Grilled), List.of(Empty), 12, output);
        CookedMealRecipe(MIItem.YING_LUO_XUE.get(), new Item[]{MIItem.JI_SHANG_JIN_QIANG_YU.asItem()},CookerTypeEnum.Cutting_Board, List.of(Aquatic,Premium,Sea_Delicacy,Japanese,Raw,Photogenic,Small_Portion), List.of(Greasy), 12, output);
        CookedMealRecipe(MIItem.SONG_ZI_GAO.get(), new Item[]{MIItem.NUO_MI.asItem(), MIItem.SONG_ZI.asItem()},CookerTypeEnum.Steamer, List.of(Mild,Specialty), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.SOU_MA_TUAN_ZI.get(), new Item[]{MIItem.NUO_MI.asItem(), MIItem.NUO_MI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Filling,Photogenic,Peculiar,Cultural_Heritage), List.of(Meat), 9, output);
        CookedMealRecipe(MIItem.MAN_YU_NENG_DAN_JING.get(), new Item[]{MIItem.BA_MU_MAN.asItem(), MIItem.JI_DAN.asItem()},CookerTypeEnum.Frying_Pan, List.of(Aquatic,Raw,Signature), List.of(Empty), 5, output);
        CookedMealRecipe(MIItem.MAO_MI_KE_LU_LI.get(), new Item[]{MIItem.KE_KE_DOU.asItem(), MIItem.JI_DAN.asItem(), MIItem.MIAN_FEN.asItem()},CookerTypeEnum.Grill, List.of(Filling,Sweet,Photogenic), List.of(Peculiar), 7, output);
        CookedMealRecipe(MIItem.SAN_WEN_YU_TIAN_FU_LUO.get(), new Item[]{MIItem.SAN_WEN_YU.asItem(), MIItem.HUANG_YOU.asItem(), MIItem.JI_DAN.asItem(), MIItem.MIAN_FEN.asItem()},CookerTypeEnum.Frying_Pan, List.of(Aquatic,Premium,Greasy,Fresh,Small_Portion), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.HONG_SHAO_MAN_YU.get(), new Item[]{MIItem.BA_MU_MAN.asItem(), MIItem.YANG_CONG.asItem()},CookerTypeEnum.Frying_Pan, List.of(Aquatic,Vegetarian,Greasy,Fresh,Signature), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.MI_TAO_HONG_SHAO_ROU.get(), new Item[]{MIItem.FENG_MI.asItem(), MIItem.TAO_ZI.asItem(), MIItem.ZHU_ROU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Meat,Good_Alcohol,Wonderful,Fruity), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.SHI_GUO_ZHU_SUN_DUN_ROU.get(), new Item[]{MIItem.ZHU_ZI.asItem(), MIItem.ZHU_SUN.asItem(), MIItem.NIU_ROU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Meat,Homecooking,Filling), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.CHUI_XUAN_FENG.get(), new Item[]{MIItem.MIAN_FEN.asItem(), MIItem.FENG_MI.asItem(), MIItem.CHAN_SHUI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Filling,Raw,Peculiar,Specialty), List.of(Greasy), 5, output);
        CookedMealRecipe(MIItem.TI_SHEN_BU_DING.get(), new Item[]{MIItem.PU_TAO.asItem(), MIItem.PU_TAO.asItem(), MIItem.NING_MENG.asItem()},CookerTypeEnum.Steamer, List.of(Sweet,Refreshing,Strength_Boosting,Small_Portion,Fruity,Sour), List.of(Greasy,Salty), 8, output);
        CookedMealRecipe(MIItem.LIU_SHUI_SU_MIAN.get(), new Item[]{MIItem.MIAN_FEN.asItem(), MIItem.ZHU_ZI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Vegetarian,Mild,Refreshing,Wonderful), List.of(Greasy), 7, output);
        CookedMealRecipe(MIItem.ZA_CHUI.get(), new Item[]{MIItem.HAI_TAI.asItem(), MIItem.DOU_FU.asItem(), MIItem.ZUN_YU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Meat,Homecooking,Fresh,Hot), List.of(Empty), 5, output);
        CookedMealRecipe(MIItem.ZHU_TONG_ZHENG_DAN.get(), new Item[]{MIItem.ZHU_ZI.asItem(), MIItem.JI_DAN.asItem(), MIItem.HAI_TAI.asItem(), MIItem.MO_GU.asItem()},CookerTypeEnum.Steamer, List.of(Homecooking,Mild,Fungus), List.of(Empty), 6, output);
        CookedMealRecipe(MIItem.TONG_LUO_SHAO.get(), new Item[]{MIItem.HONG_DOU.asItem(), MIItem.JI_DAN.asItem(), MIItem.MIAN_FEN.asItem()},CookerTypeEnum.Frying_Pan, List.of(Vegetarian,Japanese,Sweet,Specialty), List.of(Meat), 6, output);
        CookedMealRecipe(MIItem.HUAN_JIN_SHU_YU_BIN.get(), new Item[]{MIItem.MIAN_FEN.asItem(), MIItem.FENG_MI.asItem(), MIItem.ZUN_YU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Aquatic,Greasy,Good_Alcohol,Strength_Boosting), List.of(Empty), 9, output);
        CookedMealRecipe(MIItem.YIN_YU_SHUI_GUO_PAI.get(), new Item[]{MIItem.PU_TAO.asItem(), MIItem.NING_MENG.asItem(), MIItem.ZHI_SHI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Specialty,Fruity,Sour,Fresh,Salty), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.ZHANG_YU_SHAO.get(), new Item[]{MIItem.MIAN_FEN.asItem(), MIItem.HAI_TAI.asItem(), MIItem.ZHANG_YU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Aquatic,Filling,Signature,Photogenic,Small_Portion), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.CHANG_FA_GONG_ZHU.get(), new Item[]{MIItem.NAN_GUA.asItem(), MIItem.XIA.asItem()},CookerTypeEnum.Steamer, List.of(Aquatic,Filling,Photogenic), List.of(Peculiar), 5, output);
        CookedMealRecipe(MIItem.TANG_YUAN.get(), new Item[]{MIItem.NUO_MI.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Vegetarian,Homecooking,Chinese,Cultural_Heritage), List.of(Empty), 5, output);
        CookedMealRecipe(MIItem.SHUI_JIAO.get(), new Item[]{MIItem.MIAN_FEN.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Vegetarian,Homecooking,Chinese,Cultural_Heritage), List.of(Empty), 5, output);
        CookedMealRecipe(MIItem.BAN_NI_DI_KE_DAN.get(), new Item[]{MIItem.JI_DAN.asItem(), MIItem.ZHU_SUN.asItem(), MIItem.HUANG_YOU.asItem(), MIItem.MIAN_FEN.asItem()},CookerTypeEnum.Frying_Pan, List.of(Filling,Western,Raw,Small_Portion), List.of(Sweet,Fruity), 7, output);
        CookedMealRecipe(MIItem.YANG_XIN_ZHOU.get(), new Item[]{MIItem.YIN_ER.asItem(), MIItem.LIAN_ZI.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Mild,Sweet,Specialty), List.of(Empty), 5, output);
        CookedMealRecipe(MIItem.LI_LIANG_TANG.get(), new Item[]{MIItem.YE_ZHU_ROU.asItem(), MIItem.HAI_TAI.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Meat,Mountain_Delicacy,Hot,Strength_Boosting,Soup), List.of(Small_Portion,Refreshing), 12, output);
        CookedMealRecipe(MIItem.MA_PO_DOU_FU.get(), new Item[]{MIItem.DOU_FU.asItem(), MIItem.ZHU_ROU.asItem(), MIItem.LA_JIAO.asItem()},CookerTypeEnum.Frying_Pan, List.of(Vegetarian,Chinese,Hot,Spicy), List.of(Sweet,Fruity,Refreshing), 6, output);
        CookedMealRecipe(MIItem.MEI_ZI_CHA_PAO_FAN.get(), new Item[]{MIItem.MEI_ZI.asItem(), MIItem.HAI_TAI.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Homecooking,Japanese), List.of(Empty), 4, output);
        CookedMealRecipe(MIItem.YIN_HUA_BU_DING.get(), new Item[]{MIItem.FENG_MI.asItem(), MIItem.TAO_ZI.asItem()},CookerTypeEnum.Steamer, List.of(Sweet,Photogenic,Refreshing,Small_Portion,Specialty,Fruity), List.of(Greasy,Salty), 6, output);
        CookedMealRecipe(MIItem.MA_SHU.get(), new Item[]{MIItem.NUO_MI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Japanese,Sweet,Small_Portion), List.of(Meat,Aquatic,Fresh,Salty), 7, output);
        CookedMealRecipe(MIItem.WEN_NUAN_FAN_TUAN.get(), new Item[]{MIItem.YANG_CONG.asItem(), MIItem.ZUN_YU.asItem()},CookerTypeEnum.Cutting_Board, List.of(Aquatic,Vegetarian,Homecooking,Japanese,Filling,Hot), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.MI_ZHI_XIAO_YU_GAN.get(), new Item[]{MIItem.ZUN_YU.asItem()},CookerTypeEnum.Cutting_Board, List.of(Salty,Fresh,Aquatic,Small_Portion), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.XIANG_CHUN_JIAN_BING.get(), new Item[]{MIItem.CHUN_CHUN.asItem(), MIItem.JI_DAN.asItem()},CookerTypeEnum.Frying_Pan, List.of(Signature,Specialty), List.of(Empty), 6, output);
        CookedMealRecipe(MIItem.BA_SI_DI_GUA.get(), new Item[]{MIItem.DI_GUA.asItem(), MIItem.FENG_MI.asItem()},CookerTypeEnum.Frying_Pan, List.of(Vegetarian,Homecooking,Filling,Sweet), List.of(Raw), 6, output);
        CookedMealRecipe(MIItem.MI_QIAN_LI_ZI.get(), new Item[]{MIItem.FENG_MI.asItem(), MIItem.BAN_LI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Small_Portion,Sweet,Specialty), List.of(Empty), 6, output);
        CookedMealRecipe(MIItem.HONG_DOU_DA_FU.get(), new Item[]{MIItem.HONG_DOU.asItem(), MIItem.NUO_MI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Japanese,Sweet,Small_Portion), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.SHI_ZI_TOU.get(), new Item[]{MIItem.NIU_ROU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Meat,Good_Alcohol,Fresh,Signature,Specialty), List.of(Aquatic,Filling), 7, output);
        CookedMealRecipe(MIItem.NAI_XIANG_MO_GU_TANG.get(), new Item[]{MIItem.MO_GU.asItem(), MIItem.TU_DOU.asItem(), MIItem.NAI_YOU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Homecooking,Photogenic,Fungus), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.ZHA_BA_MU_MAN.get(), new Item[]{MIItem.BA_MU_MAN.asItem()},CookerTypeEnum.Frying_Pan, List.of(Aquatic,Greasy,Signature), List.of(Refreshing), 7, output);
        CookedMealRecipe(MIItem.ZHU_ROU_ZUN_YU_XUN.get(), new Item[]{MIItem.ZHU_ROU.asItem(), MIItem.ZUN_YU.asItem()},CookerTypeEnum.Grill, List.of(Meat,Aquatic,Homecooking,Grilled), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.ZHA_FAN_QIE_TIAO.get(), new Item[]{MIItem.XI_HONG_SHI.asItem(), MIItem.TU_DOU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Peculiar,Wonderful,Small_Portion), List.of(Aquatic), 6, output);
        CookedMealRecipe(MIItem.BI_SI_KAI_WAN_BING_GAN.get(), new Item[]{MIItem.MIAN_FEN.asItem(), MIItem.ZHI_SHI.asItem()},CookerTypeEnum.Grill, List.of(Filling,Salty,Hot), List.of(Sour), 5, output);
        CookedMealRecipe(MIItem.MAO_FAN.get(), new Item[]{MIItem.ZUN_YU.asItem(), MIItem.MIAN_FEN.asItem(), MIItem.LU_SHUI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Aquatic,Fresh,Small_Portion), List.of(Greasy), 5, output);
        CookedMealRecipe(MIItem.ZHI_SHI_DAN.get(), new Item[]{MIItem.JI_DAN.asItem(), MIItem.ZHI_SHI.asItem()},CookerTypeEnum.Frying_Pan, List.of(Greasy,Salty,Fresh,Raw), List.of(Meat), 6, output);
        CookedMealRecipe(MIItem.BEI_JI_TIAN_XIA_MI_TAO_SE_LA.get(), new Item[]{MIItem.TAO_ZI.asItem(), MIItem.XIA.asItem(), MIItem.BING_KUAI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Aquatic,Vegetarian,Mild,Sweet,Photogenic,Wonderful,Fruity), List.of(Salty,Meat), 10, output);
        CookedMealRecipe(MIItem.ZHU_SUN_CHAO_ROU.get(), new Item[]{MIItem.ZHU_ROU.asItem(), MIItem.ZHU_SUN.asItem()},CookerTypeEnum.Frying_Pan, List.of(Meat,Homecooking,Good_Alcohol), List.of(Empty), 10, output);
        CookedMealRecipe(MIItem.ZHA_ZHU_ROU_PAI.get(), new Item[]{MIItem.ZHU_ROU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Meat,Homecooking,Greasy,Filling), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.KAO_DI_GUA.get(), new Item[]{MIItem.DI_GUA.asItem()},CookerTypeEnum.Grill, List.of(Economical,Homecooking,Filling,Sweet), List.of(Good_Alcohol), 6, output);
        CookedMealRecipe(MIItem.SHANG_QI_ZHI_SHI_TIAO.get(), new Item[]{MIItem.ZHI_SHI.asItem(), MIItem.BAI_GUO.asItem(), MIItem.BAI_GUO.asItem()},CookerTypeEnum.Steamer, List.of(Good_Alcohol,Salty,Fresh,Specialty), List.of(Empty), 6, output);
        CookedMealRecipe(MIItem.CHOU_DOU_FU.get(), new Item[]{MIItem.DOU_FU.asItem(), MIItem.LA_JIAO.asItem()},CookerTypeEnum.Frying_Pan, List.of(Vegetarian,Chinese,Peculiar,Spicy), List.of(Sweet,Fruity), 5, output);
        CookedMealRecipe(MIItem.LV_YE_XIAN_GU.get(), new Item[]{MIItem.CHUN_CHUN.asItem(), MIItem.MO_GU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Mild,Cultural_Heritage,Fungus,Specialty), List.of(Empty), 6, output);
        CookedMealRecipe(MIItem.DA_BAN_SHAO.get(), new Item[]{MIItem.MIAN_FEN.asItem(), MIItem.JI_DAN.asItem(), MIItem.LUO_BU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Japanese,Signature,Photogenic,Small_Portion), List.of(Empty), 6, output);
        CookedMealRecipe(MIItem.RE_SONG_BING.get(), new Item[]{MIItem.JI_DAN.asItem(), MIItem.MIAN_FEN.asItem(), MIItem.FENG_MI.asItem()},CookerTypeEnum.Frying_Pan, List.of(Filling,Western,Sweet), List.of(Empty), 9, output);
        CookedMealRecipe(MIItem.TU_DOU_KE_LE_BING.get(), new Item[]{MIItem.TU_DOU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Vegetarian,Homecooking,Greasy), List.of(Refreshing), 5, output);
        CookedMealRecipe(MIItem.ZHU_DOU_FU.get(), new Item[]{MIItem.DOU_FU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Vegetarian,Homecooking,Mild), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.KAO_BA_MU_MAN.get(), new Item[]{MIItem.BA_MU_MAN.asItem()},CookerTypeEnum.Grill, List.of(Aquatic,Grilled,Signature), List.of(Meat,Vegetarian), 7, output);
        CookedMealRecipe(MIItem.ZHA_XIA_TIAN_FU_LUO.get(), new Item[]{MIItem.XIA.asItem(), MIItem.MIAN_FEN.asItem()},CookerTypeEnum.Frying_Pan, List.of(Greasy,Good_Alcohol), List.of(Mild), 6, output);
        CookedMealRecipe(MIItem.LENG_DOU_FU.get(), new Item[]{MIItem.LUO_BU.asItem(), MIItem.DOU_FU.asItem()},CookerTypeEnum.Cutting_Board, List.of(Vegetarian,Homecooking,Mild,Small_Portion,Good_Alcohol), List.of(Empty), 5, output);
        CookedMealRecipe(MIItem.DOU_FU_WEI_CHENG.get(), new Item[]{MIItem.DOU_FU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Vegetarian,Homecooking,Japanese,Mild,Soup), List.of(Greasy), 7, output);
        CookedMealRecipe(MIItem.LIANG_CAI_DIAO_HUA.get(), new Item[]{MIItem.LUO_BU.asItem()},CookerTypeEnum.Cutting_Board, List.of(Vegetarian,Mild,Photogenic,Refreshing), List.of(Meat,Hot), 5, output);
        CookedMealRecipe(MIItem.NAI_YOU_TUN_CAI.get(), new Item[]{MIItem.MO_GU.asItem(), MIItem.YANG_CONG.asItem(), MIItem.HUANG_YOU.asItem()},CookerTypeEnum.Steamer, List.of(Vegetarian,Western,Fungus,Soup), List.of(Empty), 9, output);
        CookedMealRecipe(MIItem.ZHU_ROU_GAI_JIAO_FAN.get(), new Item[]{MIItem.ZHU_ROU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Meat,Homecooking,Filling), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.NIU_ROU_GAI_JIAO_FAN.get(), new Item[]{MIItem.NIU_ROU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Meat,Homecooking,Filling), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.YUN_SHAN_MIAO_HUA_TANG.get(), new Item[]{MIItem.FENG_MI.asItem(), MIItem.TAO_ZI.asItem()},CookerTypeEnum.Frying_Pan, List.of(Sweet,Wonderful,Specialty,Fruity), List.of(Meat,Salty), 8, output);
        CookedMealRecipe(MIItem.MO_GU_ROU_PIAN.get(), new Item[]{MIItem.MO_GU.asItem(), MIItem.ZHU_ROU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Meat,Homecooking,Greasy,Fungus), List.of(Empty), 6, output);
        CookedMealRecipe(MIItem.XIANG_ZHA_CHAN_SHUI.get(), new Item[]{MIItem.CHAN_SHUI.asItem()},CookerTypeEnum.Frying_Pan, List.of(Economical,Greasy,Peculiar), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.DOU_FU_GUO.get(), new Item[]{MIItem.DOU_FU.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Economical,Mild,Vegetarian,Japanese,Hot), List.of(Empty), 5, output);
        CookedMealRecipe(MIItem.KAO_MO_GU.get(), new Item[]{MIItem.MO_GU.asItem()},CookerTypeEnum.Grill, List.of(Economical,Vegetarian,Salty,Hot,Fungus,Grilled), List.of(Empty), 6, output);
        CookedMealRecipe(MIItem.LU_SHUI_ZHU_DAN.get(), new Item[]{MIItem.JI_DAN.asItem(), MIItem.LU_SHUI.asItem()},CookerTypeEnum.Steamer, List.of(Economical,Mild,Raw), List.of(Meat,Aquatic,Greasy), 3, output);
        CookedMealRecipe(MIItem.YOU_DOU_FU.get(), new Item[]{MIItem.DOU_FU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Economical,Vegetarian,Homecooking,Greasy,Japanese), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.YAN_HUANG_GUA.get(), new Item[]{MIItem.HUANG_GUA.asItem(), MIItem.HEI_YAN.asItem()},CookerTypeEnum.Cutting_Board, List.of(Economical,Vegetarian,Good_Alcohol,Salty,Small_Portion), List.of(Empty), 6, output);
        CookedMealRecipe(MIItem.CHAO_ROU_SI.get(), new Item[]{MIItem.ZHU_ROU.asItem()},CookerTypeEnum.Frying_Pan, List.of(Economical,Meat,Homecooking,Greasy,Good_Alcohol,Chinese), List.of(Empty), 8, output);
        CookedMealRecipe(MIItem.ZHI_ZHU_ROU_FAN_TUAN.get(), new Item[]{MIItem.ZHU_ROU.asItem()},CookerTypeEnum.Cutting_Board, List.of(Economical,Meat,Homecooking,Filling,Japanese), List.of(Empty), 6, output);
        CookedMealRecipe(MIItem.SI_KANG_BING.get(), new Item[]{MIItem.HUANG_YOU.asItem(), MIItem.MIAN_FEN.asItem()},CookerTypeEnum.Steamer, List.of(Economical,Filling,Western), List.of(Empty), 7, output);
        CookedMealRecipe(MIItem.HAI_XIAN_WEI_CHENG_TANG.get(), new Item[]{MIItem.HAI_TAI.asItem()},CookerTypeEnum.Boiling_Pot, List.of(Economical,Vegetarian,Homecooking,Soup), List.of(Greasy), 6, output);
        CookedMealRecipe(MIItem.FAN_TUAN.get(), new Item[]{MIItem.HAI_TAI.asItem()},CookerTypeEnum.Cutting_Board, List.of(Economical,Vegetarian,Homecooking,Filling,Japanese), List.of(Empty), 5, output);

    }

    private void CookedMealRecipe(CookedMealItem target, RecipeOutput output) {
        MealRecipeBuilder.shapelessMeal(RecipeCategory.FOOD, target)
                .requires(target.ingredients)
                .cooker(target.cookerTypeEnum)
                .positiveTag(TagListToBytes(target.positiveTag))
                .negativeTag(TagListToBytes(target.negativeTag))
                .cookingTime((int) target.cookingTime)
                .save(output);
    }

    private void CookedMealRecipe(Item target, Item[] ingredients, CookerTypeEnum cookerTypeEnum, List<FoodTagEnum> positiveTags, List<FoodTagEnum> negativeTags, float cookingTime, RecipeOutput output) {
        MealRecipeBuilder.shapelessMeal(RecipeCategory.FOOD, target)
                .requires(ingredients)
                .cooker(cookerTypeEnum)
                .positiveTag(TagListToBytes(positiveTags))
                .negativeTag(TagListToBytes(negativeTags))
                .cookingTime((int) cookingTime)
                .save(output);
    }
}
