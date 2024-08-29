package com.crystal.mystia_izakaya.dataGen;

import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.dataGen.builder.MealRecipeBuilder;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

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

        CookeMealRecipe((CookedMealItem) ItemRegistry.Oedo_Boat_Feast.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Dragonsong_Peach.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Planet_Mars.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Two_Flavor_Beef_Hotpot.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Mad_Hatters_Tea_Party.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Scrumptious_Storm.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Buddha_Jump_Over_The_Wall.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Beef_Wellington.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Dragon_Carp.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Eight_Trigram_Fish_Maws.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Supreme_Seafood_Noodles.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Faint_Dream.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Star_Lotus_Ship.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Rainbow_Pan_Fride_Pork_Buns.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Moonlight_over_the_Lotus_Pond.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Urchin_Raindrop_Cake.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Fujis_Lava.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Hourai_Branch.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Against_the_World.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Origin_of_Life.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Imitation_Shirikodama.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Kittens_Water_Play.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Palace_of_the_Han.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.All_Meat_Feast.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Urchin_Steamed_Egg.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Mushroom_Maidens_Tip_Tap_Pot.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Caution_Hellish_Spice.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Sea_Urchin_Sashimi.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Daimyos_Feast.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Kabuto_Steamed_Cake.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Bamboo_Spring.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Shirayuki.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Buddhas_Delight.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Lotus_Fish_Lamps.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Agony_Oden.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Seven_Colored_Yokan.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Niten_Ichiryu.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Heart_Trobbing_Surprise.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Sashimi_Platter.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Creamy_Crab.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Little_Sweet_Poision.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Cubic_Kedama_Volcanic_Tofu.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Lunar_Dango.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Molecular_Egg.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Ino_Shika_Chou.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Udumbara_Cake.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Natures_Beauty.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Cubic_Kedama_Ice_Cream.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Kitten_Pizza.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Burn_out_Pudding.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Rice_Powder_Meat.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Tempura_Platter.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.White_Deer_Unyielding_Pine.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Italian_Risotto.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Imitation_Bear_Paw.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Cantonese_Char_Siu.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Sichuan_Boiled_Fish.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Lunar_Lover_Biscuit.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Hunters_Casserole.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Ceiling_Longing_Pie.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Kaguya_Hime.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Immortal_Turkey.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Golden_Ribs_Soup.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Golden_Two_Shroom_Wrap.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Instant_Death.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Secret_Savory_Mushroom_Hotpot.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Tonkotsu_Ramen.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Scholars_Ginkyo.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Classic_Steak.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Scarlet_Devil_Cake.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Unconscious_Youkai_Mousse.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Giant_Tamagoyaki.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Peach_Flower_Crystal_Ball.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Hot_Pepper_Soup.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Drunk_Shrimp_in_Bamboo.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Salmon_Steak.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Miasma_Garden.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Smoked_Buccaneer.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Vegetable_Salad.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Pure_White_Lotus.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Ordinary_Eat_Me_Cupcake.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Peach_Yatsuhashi.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Peach_Tapioca.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Real_Seafood_Miso_Soup.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Tianshis_Stewed_Mushrooms.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Shrimp_Stuffed_Pumpkin.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Energy_Skewer.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Falling_Blossoms.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Pine_Nut_Cake.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Yashouma_Dango.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Eel_Bowl_with_Egg.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Kitten_Canele.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Salmon_Tempura.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Kabayaki_Lampreys.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Peach_Braised_Pork.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Bamboo_Meat_Pot.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Crispy_Spirals.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Energy_Pudding.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Flowing_Somen.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Hodgepodge.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Steamed_Egg_Bamboo_Shoots.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Dorayaki.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Golden_Crispy_Fish_Cake.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Gloomy_Fruit_Pie.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Takoyaki.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Long_Hair_Princess.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Tangyuan.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Dumplings.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Eggs_Benedict.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Heart_Warming_Congee.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Power_Soup.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Mapo_Tofu.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Plum_Tea_Rice.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Sakura_Pudding.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Mochi.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Pink_Rice_Ball.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Secret_Dried_Fish_Crisps.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Toon_Pancake.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Candied_Sweet_Potato.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Honeyed_Chestnut.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Red_Bean_Daifuku.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Lions_Head.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Nigiri_Sushi.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Cream_of_Mushroom_Hotpot.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Fried_Lamprey.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Pork_Trout_Kebab.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Tomato_Fries.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Biscay_Biscuits.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Neko_Manma.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Cheese_Omelette.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Peach_Shrimp_Salad.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Pork_Bamboo_Shoots_Stir_Fry.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Fried_Pork_Cutlet.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Baked_Sweet_Potato.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Misery_Cheese_Sticks.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Stinky_Tofu.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Mushroom_Herb_Road.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Okonomiyaki.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Pancakes_With_Syrup.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Potato_Croquettes.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Boiled_Tofu.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Grilled_Lamprey.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Deep_Fried_Shrimp_Tempura.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Fresh_Tofu.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Miso_Tofu.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Carved_Rose_Salad.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Creamy_Vegetable_Chowder.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Pork_Bowl.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Beef_Bawl.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Unzan_Cotton_Candy.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Pork_Mushroom_Stir_Fry.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Fried_Cicada_Sloughs.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Tofu_Stew.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Roasted_Mushroom.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Dew_Runny_Eggs.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Deep_Fried_Tofu.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Pickles.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Pork_Stir_Fry.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Pork_Rice_Ball.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Scones.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Sea_Miso_soup.get(), output);
        CookeMealRecipe((CookedMealItem) ItemRegistry.Rice_Ball.get(), output);
    }

    private void CookeMealRecipe(CookedMealItem item, RecipeOutput output) {
        MealRecipeBuilder.shapelessMeal(RecipeCategory.FOOD, item)
                .requires(item.ingredients)
                .cooker(item.cookerTypeEnum)
                .save(output);
    }
}
