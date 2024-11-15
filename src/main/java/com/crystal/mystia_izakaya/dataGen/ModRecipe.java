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

import static com.crystal.mystia_izakaya.utils.UtilMethod.TagListToBytes;

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
    }

    private void CookedMealRecipe(CookedMealItem target, RecipeOutput output) {
        MealRecipeBuilder mealRecipeBuilder = MealRecipeBuilder.shapelessMeal(RecipeCategory.FOOD, target)
                .cooker(target.cookerTypeEnum)
                .positiveTag(TagListToBytes(target.positiveTag))
                .negativeTag(TagListToBytes(target.negativeTag))
                .cookingTime((int) target.cookingTime);
        target.ingredients.forEach(mealRecipeBuilder::requires);
        mealRecipeBuilder.save(output);
    }
}
