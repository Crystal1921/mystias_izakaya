package com.crystal.mystia_izakaya.dataGen;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.Arrays;

public class ModLanguageEN extends LanguageProvider {
    public ModLanguageEN(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.mystia_izakaya", "Mystia's Izakaya");
        this.add("itemGroup.mystia_izakaya_meal", "Meals");
        this.add("gui.mystia_izakaya.meal", "Recipe");
        this.add("gui.mystia_izakaya.level", "Level");
        this.add("gui.mystia_izakaya.cooking_time", "Cooking Time");
        this.add("gui.mystia_izakaya.tags", "Tags");
        this.add("gui.mystia_izakaya.meal.jei", "Mystia's Izakaya");
        this.add("gui.mystia_izakaya.progress", "Progress");

        this.add(ItemRegistry.MystiaFishingRod.get(), "Mystia's Fishing Rod");
        this.add(ItemRegistry.RecipeBook.get(), "Mystia's Recipe Book");

        this.add(ItemRegistry.Grill_Block.get(), "Grill Block");
        this.add(ItemRegistry.Boiling_Pot.get(), "Boiling Pot");
        this.add(ItemRegistry.Frying_Pan.get(), "Frying Pan");
        this.add(ItemRegistry.Steamer.get(), "Steamer");
        this.add(ItemRegistry.Cutting_Board.get(), "Cutting Board");

        this.add(ItemRegistry.Trout.get(), "Trout");
        this.add(ItemRegistry.Lamprey.get(), "Lamprey");
        this.add(ItemRegistry.Salmon.get(), "Salmon");
        this.add(ItemRegistry.Tuna.get(), "Tuna");
        this.add(ItemRegistry.Premium_Tuna.get(), "Premium Tuna");
        this.add(ItemRegistry.Pufferfish.get(), "Pufferfish");
        this.add(ItemRegistry.Shrimp.get(), "Shrimp");
        this.add(ItemRegistry.Octopus.get(), "Octopus");
        this.add(ItemRegistry.Sea_Urchin.get(), "Sea Urchin");
        this.add(ItemRegistry.Crab.get(), "Crab");

        this.add(ItemRegistry.Pork.get(),"Pork");
        this.add(ItemRegistry.Beef.get(),"Beef");
        this.add(ItemRegistry.Venison.get(),"Venison");
        this.add(ItemRegistry.Boar_Meat.get(),"Boar Meat");
        this.add(ItemRegistry.Iberico_Pork.get(),"Iberico Pork");
        this.add(ItemRegistry.Wagyo_Beef.get(),"Wagyo Beef");

        this.add(ItemRegistry.Tofu.get(), "Tofu");
        this.add(ItemRegistry.Potato.get(), "Potato");
        this.add(ItemRegistry.Onion.get(), "Onion");
        this.add(ItemRegistry.Pumpkin.get(), "Pumpkin");
        this.add(ItemRegistry.Radish.get(), "Radish");
        this.add(ItemRegistry.Seaweed.get(), "Seaweed");
        this.add(ItemRegistry.Mushroom.get(), "Mushroom");
        this.add(ItemRegistry.Truffle.get(), "Truffle");
        this.add(ItemRegistry.Bamboo_Shoot.get(),"Bamboo Shoot");
        this.add(ItemRegistry.Cucumber.get(), "Cucumber");
        this.add(ItemRegistry.Chestnut.get(), "Chestnut");
        this.add(ItemRegistry.Red_Toon.get(), "Red Toon");
        this.add(ItemRegistry.Tomato.get(), "Tomato");
        this.add(ItemRegistry.Broceoli.get(), "Broceoli");

        this.add(ItemRegistry.Egg.get(),"Egg");
        this.add(ItemRegistry.Ginko_Nut.get(),"Ginko Nut");
        this.add(ItemRegistry.Cicada_Slough.get(),"Cicada Slough");
        this.add(ItemRegistry.Dew.get(),"Dew");
        this.add(ItemRegistry.Flour.get(),"Flour");
        this.add(ItemRegistry.Sticky_Rice.get(),"Sticky Rice");
        this.add(ItemRegistry.Ice_Cube.get(),"Ice Cube");
        this.add(ItemRegistry.Grapes.get(),"Grapes");
        this.add(ItemRegistry.Cream.get(),"Cream");
        this.add(ItemRegistry.Lemon.get(),"Lemon");
        this.add(ItemRegistry.Lotus_Seed.get(),"Lotus Seed");
        this.add(ItemRegistry.Pine_Nut.get(),"Pine Nut");
        this.add(ItemRegistry.Red_Bean.get(),"Red Bean");
        this.add(ItemRegistry.Cocoa_Bean.get(),"Cocoa Bean");
        this.add(ItemRegistry.Snow_Fungus.get(),"Snow Fungus");
        this.add(ItemRegistry.Peach.get(),"Peach");
        this.add(ItemRegistry.Honey.get(),"Honey");
        this.add(ItemRegistry.Udunmbara.get(),"Udunmbara");
        this.add(ItemRegistry.Butter.get(),"Butter");
        this.add(ItemRegistry.Bamboo.get(),"Bamboo");
        this.add(ItemRegistry.Lunar_Herb.get(),"Lunar Herb");
        this.add(ItemRegistry.Chili.get(),"Chili");
        this.add(ItemRegistry.Black_Salt.get(),"Black Salt");
        this.add(ItemRegistry.Bingdi_Lotus.get(),"Bingdi Lotus");
        this.add(ItemRegistry.Cheese.get(),"Cheese");
        this.add(ItemRegistry.Sweet_Potato.get(),"Sweet Potato");
        this.add(ItemRegistry.Plum.get(),"Plum");
        this.add(ItemRegistry.Flower.get(),"Flower");
        this.add(ItemRegistry.Creeping_Fig.get(),"Creeping Fig");

        this.add(ItemRegistry.Oedo_Boat_Feast.get(), "oedo boat feast");
        this.add(ItemRegistry.Dragonsong_Peach.get(), "dragonsong peach");
        this.add(ItemRegistry.Planet_Mars.get(), "planet mars");
        this.add(ItemRegistry.Two_Flavor_Beef_Hotpot.get(), "two flavor beef hotpot");
        this.add(ItemRegistry.Mad_Hatters_Tea_Party.get(), "mad hatters tea party");
        this.add(ItemRegistry.Scrumptious_Storm.get(), "scrumptious storm");
        this.add(ItemRegistry.Buddha_Jump_Over_The_Wall.get(), "buddha jump over the wall");
        this.add(ItemRegistry.Beef_Wellington.get(), "beef wellington");
        this.add(ItemRegistry.Dragon_Carp.get(), "dragon carp");
        this.add(ItemRegistry.Eight_Trigram_Fish_Maws.get(), "eight trigram fish maws");
        this.add(ItemRegistry.Supreme_Seafood_Noodles.get(), "supreme seafood noodles");
        this.add(ItemRegistry.Faint_Dream.get(), "faint dream");
        this.add(ItemRegistry.Star_Lotus_Ship.get(), "star lotus ship");
        this.add(ItemRegistry.Rainbow_Pan_Fride_Pork_Buns.get(), "rainbow pan fride pork buns");
        this.add(ItemRegistry.Moonlight_over_the_Lotus_Pond.get(), "moonlight over the lotus pond");
        this.add(ItemRegistry.Urchin_Raindrop_Cake.get(), "urchin raindrop cake");
        this.add(ItemRegistry.Fujis_Lava.get(), "fujis lava");
        this.add(ItemRegistry.Hourai_Branch.get(), "hourai branch");
        this.add(ItemRegistry.Against_the_World.get(), "against the world");
        this.add(ItemRegistry.Origin_of_Life.get(), "origin of life");
        this.add(ItemRegistry.Imitation_Shirikodama.get(), "imitation shirikodama");
        this.add(ItemRegistry.Kittens_Water_Play.get(), "kittens water play");
        this.add(ItemRegistry.Palace_of_the_Han.get(), "palace of the han");
        this.add(ItemRegistry.All_Meat_Feast.get(), "all meat feast");
        this.add(ItemRegistry.Urchin_Steamed_Egg.get(), "urchin steamed egg");
        this.add(ItemRegistry.Mushroom_Maidens_Tip_Tap_Pot.get(), "mushroom maidens tip tap pot");
        this.add(ItemRegistry.Caution_Hellish_Spice.get(), "caution hellish spice");
        this.add(ItemRegistry.Sea_Urchin_Sashimi.get(), "sea urchin sashimi");
        this.add(ItemRegistry.Daimyos_Feast.get(), "daimyos feast");
        this.add(ItemRegistry.Kabuto_Steamed_Cake.get(), "kabuto steamed cake");
        this.add(ItemRegistry.Bamboo_Spring.get(), "bamboo spring");
        this.add(ItemRegistry.Shirayuki.get(), "shirayuki");
        this.add(ItemRegistry.Buddhas_Delight.get(), "buddhas delight");
        this.add(ItemRegistry.Lotus_Fish_Lamps.get(), "lotus fish lamps");
        this.add(ItemRegistry.Agony_Oden.get(), "agony oden");
        this.add(ItemRegistry.Seven_Colored_Yokan.get(), "seven colored yokan");
        this.add(ItemRegistry.Niten_Ichiryu.get(), "niten ichiryu");
        this.add(ItemRegistry.Heart_Trobbing_Surprise.get(), "heart trobbing surprise");
        this.add(ItemRegistry.Sashimi_Platter.get(), "sashimi platter");
        this.add(ItemRegistry.Creamy_Crab.get(), "creamy crab");
        this.add(ItemRegistry.Little_Sweet_Poision.get(), "little sweet poision");
        this.add(ItemRegistry.Cubic_Kedama_Volcanic_Tofu.get(), "cubic kedama volcanic tofu");
        this.add(ItemRegistry.Lunar_Dango.get(), "lunar dango");
        this.add(ItemRegistry.Molecular_Egg.get(), "molecular egg");
        this.add(ItemRegistry.Ino_Shika_Chou.get(), "ino shika chou");
        this.add(ItemRegistry.Udumbara_Cake.get(), "udumbara cake");
        this.add(ItemRegistry.Natures_Beauty.get(), "natures beauty");
        this.add(ItemRegistry.Cubic_Kedama_Ice_Cream.get(), "cubic kedama ice cream");
        this.add(ItemRegistry.Kitten_Pizza.get(), "kitten pizza");
        this.add(ItemRegistry.Burn_out_Pudding.get(), "burn out pudding");
        this.add(ItemRegistry.Rice_Powder_Meat.get(), "rice powder meat");
        this.add(ItemRegistry.Tempura_Platter.get(), "tempura platter");
        this.add(ItemRegistry.White_Deer_Unyielding_Pine.get(), "white deer unyielding pine");
        this.add(ItemRegistry.Italian_Risotto.get(), "italian risotto");
        this.add(ItemRegistry.Imitation_Bear_Paw.get(), "imitation bear paw");
        this.add(ItemRegistry.Cantonese_Char_Siu.get(), "cantonese char siu");
        this.add(ItemRegistry.Sichuan_Boiled_Fish.get(), "sichuan boiled fish");
        this.add(ItemRegistry.Lunar_Lover_Biscuit.get(), "lunar lover biscuit");
        this.add(ItemRegistry.Hunters_Casserole.get(), "hunters casserole");
        this.add(ItemRegistry.Ceiling_Longing_Pie.get(), "ceiling longing pie");
        this.add(ItemRegistry.Kaguya_Hime.get(), "kaguya hime");
        this.add(ItemRegistry.Immortal_Turkey.get(), "immortal turkey");
        this.add(ItemRegistry.Golden_Ribs_Soup.get(), "golden ribs soup");
        this.add(ItemRegistry.Golden_Two_Shroom_Wrap.get(), "golden two shroom wrap");
        this.add(ItemRegistry.Instant_Death.get(), "instant death");
        this.add(ItemRegistry.Secret_Savory_Mushroom_Hotpot.get(), "secret savory mushroom hotpot");
        this.add(ItemRegistry.Tonkotsu_Ramen.get(), "tonkotsu ramen");
        this.add(ItemRegistry.Scholars_Ginkyo.get(), "scholars ginkyo");
        this.add(ItemRegistry.Classic_Steak.get(), "classic steak");
        this.add(ItemRegistry.Scarlet_Devil_Cake.get(), "scarlet devil cake");
        this.add(ItemRegistry.Unconscious_Youkai_Mousse.get(), "unconscious youkai mousse");
        this.add(ItemRegistry.Giant_Tamagoyaki.get(), "giant tamagoyaki");
        this.add(ItemRegistry.Peach_Flower_Crystal_Ball.get(), "peach flower crystal ball");
        this.add(ItemRegistry.Hot_Pepper_Soup.get(), "hot pepper soup");
        this.add(ItemRegistry.Drunk_Shrimp_in_Bamboo.get(), "drunk shrimp in bamboo");
        this.add(ItemRegistry.Salmon_Steak.get(), "salmon steak");
        this.add(ItemRegistry.Miasma_Garden.get(), "miasma garden");
        this.add(ItemRegistry.Smoked_Buccaneer.get(), "smoked buccaneer");
        this.add(ItemRegistry.Vegetable_Salad.get(), "vegetable salad");
        this.add(ItemRegistry.Pure_White_Lotus.get(), "pure white lotus");
        this.add(ItemRegistry.Ordinary_Eat_Me_Cupcake.get(), "ordinary eat me cupcake");
        this.add(ItemRegistry.Peach_Yatsuhashi.get(), "peach yatsuhashi");
        this.add(ItemRegistry.Peach_Tapioca.get(), "peach tapioca");
        this.add(ItemRegistry.Real_Seafood_Miso_Soup.get(), "real seafood miso soup");
        this.add(ItemRegistry.Tianshis_Stewed_Mushrooms.get(), "tianshis stewed mushrooms");
        this.add(ItemRegistry.Shrimp_Stuffed_Pumpkin.get(), "shrimp stuffed pumpkin");
        this.add(ItemRegistry.Energy_Skewer.get(), "energy skewer");
        this.add(ItemRegistry.Falling_Blossoms.get(), "falling blossoms");
        this.add(ItemRegistry.Pine_Nut_Cake.get(), "pine nut cake");
        this.add(ItemRegistry.Yashouma_Dango.get(), "yashouma dango");
        this.add(ItemRegistry.Eel_Bowl_with_Egg.get(), "eel bowl with egg");
        this.add(ItemRegistry.Kitten_Canele.get(), "kitten canele");
        this.add(ItemRegistry.Salmon_Tempura.get(), "salmon tempura");
        this.add(ItemRegistry.Kabayaki_Lampreys.get(), "kabayaki lampreys");
        this.add(ItemRegistry.Peach_Braised_Pork.get(), "peach braised pork");
        this.add(ItemRegistry.Bamboo_Meat_Pot.get(), "bamboo meat pot");
        this.add(ItemRegistry.Crispy_Spirals.get(), "crispy spirals");
        this.add(ItemRegistry.Energy_Pudding.get(), "energy pudding");
        this.add(ItemRegistry.Flowing_Somen.get(), "flowing somen");
        this.add(ItemRegistry.Hodgepodge.get(), "hodgepodge");
        this.add(ItemRegistry.Steamed_Egg_Bamboo_Shoots.get(), "steamed egg bamboo shoots");
        this.add(ItemRegistry.Dorayaki.get(), "dorayaki");
        this.add(ItemRegistry.Golden_Crispy_Fish_Cake.get(), "golden crispy fish cake");
        this.add(ItemRegistry.Gloomy_Fruit_Pie.get(), "gloomy fruit pie");
        this.add(ItemRegistry.Takoyaki.get(), "takoyaki");
        this.add(ItemRegistry.Long_Hair_Princess.get(), "long hair princess");
        this.add(ItemRegistry.Tangyuan.get(), "tangyuan");
        this.add(ItemRegistry.Dumplings.get(), "dumplings");
        this.add(ItemRegistry.Eggs_Benedict.get(), "eggs benedict");
        this.add(ItemRegistry.Heart_Warming_Congee.get(), "heart warming congee");
        this.add(ItemRegistry.Power_Soup.get(), "power soup");
        this.add(ItemRegistry.Mapo_Tofu.get(), "mapo tofu");
        this.add(ItemRegistry.Plum_Tea_Rice.get(), "plum tea rice");
        this.add(ItemRegistry.Sakura_Pudding.get(), "sakura pudding");
        this.add(ItemRegistry.Mochi.get(), "mochi");
        this.add(ItemRegistry.Pink_Rice_Ball.get(), "pink rice ball");
        this.add(ItemRegistry.Secret_Dried_Fish_Crisps.get(), "secret dried fish crisps");
        this.add(ItemRegistry.Toon_Pancake.get(), "toon pancake");
        this.add(ItemRegistry.Candied_Sweet_Potato.get(), "candied sweet potato");
        this.add(ItemRegistry.Honeyed_Chestnut.get(), "honeyed chestnut");
        this.add(ItemRegistry.Red_Bean_Daifuku.get(), "red bean daifuku");
        this.add(ItemRegistry.Lions_Head.get(), "lions head");
        this.add(ItemRegistry.Nigiri_Sushi.get(), "nigiri sushi");
        this.add(ItemRegistry.Cream_of_Mushroom_Hotpot.get(), "cream of mushroom hotpot");
        this.add(ItemRegistry.Fried_Lamprey.get(), "fried lamprey");
        this.add(ItemRegistry.Pork_Trout_Kebab.get(), "pork trout kebab");
        this.add(ItemRegistry.Tomato_Fries.get(), "tomato fries");
        this.add(ItemRegistry.Biscay_Biscuits.get(), "biscay biscuits");
        this.add(ItemRegistry.Neko_Manma.get(), "neko manma");
        this.add(ItemRegistry.Cheese_Omelette.get(), "cheese omelette");
        this.add(ItemRegistry.Peach_Shrimp_Salad.get(), "peach shrimp salad");
        this.add(ItemRegistry.Pork_Bamboo_Shoots_Stir_Fry.get(), "pork bamboo shoots stir fry");
        this.add(ItemRegistry.Fried_Pork_Cutlet.get(), "fried pork cutlet");
        this.add(ItemRegistry.Baked_Sweet_Potato.get(), "baked sweet potato");
        this.add(ItemRegistry.Misery_Cheese_Sticks.get(), "misery cheese sticks");
        this.add(ItemRegistry.Stinky_Tofu.get(), "stinky tofu");
        this.add(ItemRegistry.Mushroom_Herb_Road.get(), "mushroom herb road");
        this.add(ItemRegistry.Okonomiyaki.get(), "okonomiyaki");
        this.add(ItemRegistry.Pancakes_With_Syrup.get(), "pancakes with syrup");
        this.add(ItemRegistry.Potato_Croquettes.get(), "potato croquettes");
        this.add(ItemRegistry.Boiled_Tofu.get(), "boiled tofu");
        this.add(ItemRegistry.Grilled_Lamprey.get(), "grilled lamprey");
        this.add(ItemRegistry.Deep_Fried_Shrimp_Tempura.get(), "deep fried shrimp tempura");
        this.add(ItemRegistry.Fresh_Tofu.get(), "fresh tofu");
        this.add(ItemRegistry.Miso_Tofu.get(), "miso tofu");
        this.add(ItemRegistry.Carved_Rose_Salad.get(), "carved rose salad");
        this.add(ItemRegistry.Creamy_Vegetable_Chowder.get(), "creamy vegetable chowder");
        this.add(ItemRegistry.Pork_Bowl.get(), "pork bowl");
        this.add(ItemRegistry.Beef_Bawl.get(), "beef bawl");
        this.add(ItemRegistry.Unzan_Cotton_Candy.get(), "unzan cotton candy");
        this.add(ItemRegistry.Pork_Mushroom_Stir_Fry.get(), "pork mushroom stir fry");
        this.add(ItemRegistry.Fried_Cicada_Sloughs.get(), "fried cicada sloughs");
        this.add(ItemRegistry.Tofu_Stew.get(), "tofu stew");
        this.add(ItemRegistry.Roasted_Mushroom.get(), "roasted mushroom");
        this.add(ItemRegistry.Dew_Runny_Eggs.get(), "dew runny eggs");
        this.add(ItemRegistry.Deep_Fried_Tofu.get(), "deep fried tofu");
        this.add(ItemRegistry.Pickles.get(), "pickles");
        this.add(ItemRegistry.Pork_Stir_Fry.get(), "pork stir fry");
        this.add(ItemRegistry.Pork_Rice_Ball.get(), "pork rice ball");
        this.add(ItemRegistry.Scones.get(), "scones");
        this.add(ItemRegistry.Sea_Miso_soup.get(), "sea miso soup");
        this.add(ItemRegistry.Rice_Ball.get(), "rice ball");

        Arrays.stream(FoodTagEnum.values()).toList()
                .forEach(foodTagEnum -> this.add(MystiaIzakaya.MODID + "." + foodTagEnum.name(), foodTagEnum.name()));
    }
}
