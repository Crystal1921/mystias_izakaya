package com.crystal.mystia_izakaya.registry;

import com.crystal.mystia_izakaya.MystiaIzakaya;
import com.crystal.mystia_izakaya.recipe.MealRecipe;
import com.crystal.mystia_izakaya.recipe.CookerSerializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.crystal.mystia_izakaya.utils.UtilStaticMethod.resourceLocation;

public class RecipeTypeRegistry {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MystiaIzakaya.MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, MystiaIzakaya.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MealRecipe>> COOKING_SERIALIZER = RECIPE_SERIALIZERS.register("cooking_serializers", CookerSerializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<MealRecipe>> GRILL_RECIPE = RECIPE_TYPES.register("grill_recipe", () -> RecipeType.simple(resourceLocation("grill_recipe")));
}
