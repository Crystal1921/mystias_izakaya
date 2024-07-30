package com.crystal.mystia_izakaya.dataGen.builder;

import com.crystal.mystia_izakaya.recipe.MealRecipe;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static com.crystal.mystia_izakaya.MystiaIzakaya.prefix;

public class MealRecipeBuilder implements RecipeBuilder {
    private final RecipeCategory category;
    private final Item result;
    private final ItemStack resultStack; // Neo: add stack result support
    private final NonNullList<Ingredient> ingredients = NonNullList.create();

    public MealRecipeBuilder(RecipeCategory pCategory, ItemLike pResult, int pCount) {
        this(pCategory, new ItemStack(pResult, pCount));
    }

    public MealRecipeBuilder(RecipeCategory category, ItemStack result) {
        this.category = category;
        this.result = result.getItem();
        this.resultStack = result;
    }

    public static MealRecipeBuilder shapelessMeal(RecipeCategory pCategory, ItemLike pResult) {
        return new MealRecipeBuilder(pCategory, pResult, 1);
    }

    public MealRecipeBuilder requires(Item[] items) {
        Arrays.stream(items).toList().forEach(item -> this.ingredients.add(Ingredient.of(item)));
        return this;
    }

    @Override
    public RecipeBuilder unlockedBy(String pName, Criterion<?> pCriterion) {
        return this;
    }

    @Override
    public RecipeBuilder group(@org.jetbrains.annotations.Nullable String pGroupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(@NotNull RecipeOutput output) {
        this.save(output, prefix("cooked_meal/" + RecipeBuilder.getDefaultRecipeId(this.getResult()).getPath()));
    }

    @Override
    public void save(RecipeOutput pRecipeOutput, @NotNull ResourceLocation pId) {
        MealRecipe mealRecipe = new MealRecipe(
                "cooked_meal",
                RecipeBuilder.determineBookCategory(this.category),
                this.resultStack,
                this.ingredients
        );
        pRecipeOutput.accept(pId, mealRecipe, null);
    }
}
