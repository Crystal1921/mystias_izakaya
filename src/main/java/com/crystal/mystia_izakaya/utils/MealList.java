package com.crystal.mystia_izakaya.utils;

import com.crystal.mystia_izakaya.recipe.MealRecipe;
import com.crystal.mystia_izakaya.registry.RecipeTypeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.*;
import java.util.stream.Collectors;

public class MealList {
    private static MealList instance;
    private final Map<Item, MealRecipe> recipeMap = new HashMap<>();
    private ArrayList<MealRecipe> mealLists = new ArrayList<>();

    private MealList() {
        RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<RecipeHolder<MealRecipe>> recipes = manager.getAllRecipesFor(RecipeTypeRegistry.COOKED_MEAL_RECIPE.get());
        mealLists = recipes.stream().map(RecipeHolder::value).collect(Collectors.toCollection(ArrayList::new));

        mealLists.forEach(mealRecipe -> recipeMap.put(mealRecipe.result.getItem(), mealRecipe));
    }

    public static synchronized MealList getInstance() {
        if (instance == null) {
            instance = new MealList();
        }
        return instance;
    }

    public ArrayList<MealRecipe> getMealList() {
        return mealLists;
    }

    public Map<Item, MealRecipe> getRecipeMap() {
        return recipeMap;
    }
}
