package com.crystal.mystia_izakaya.compat;

import com.crystal.mystia_izakaya.recipe.MealRecipe;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.registry.RecipeTypeRegistry;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

import static com.crystal.mystia_izakaya.utils.UtilStaticMethod.resourceLocation;

@JeiPlugin
public class MystiaPlugin implements IModPlugin {
    private static final ResourceLocation UID = resourceLocation("jei");

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new MealRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<RecipeHolder<MealRecipe>> recipes = manager.getAllRecipesFor(RecipeTypeRegistry.GRILL_RECIPE.get());
        registration.addRecipes(MealRecipeCategory.COOKED_MEAL, recipes.stream().map(RecipeHolder::value).toList());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(ItemRegistry.MystiaFishingRod.toStack(), MealRecipeCategory.COOKED_MEAL);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }
}
