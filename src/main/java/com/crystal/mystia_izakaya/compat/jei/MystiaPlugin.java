package com.crystal.mystia_izakaya.compat.jei;

import com.crystal.mystia_izakaya.recipe.MealRecipe;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.registry.RecipeTypeRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;

@JeiPlugin
public class MystiaPlugin implements IModPlugin {
    private static final ResourceLocation UID = resourceLocation("jei");

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new BoilingPotRecipe(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CuttingBoardRecipe(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new FryingPanRecipe(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new GrillRecipe(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new SteamerRecipe(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<RecipeHolder<MealRecipe>> recipes = manager.getAllRecipesFor(RecipeTypeRegistry.COOKED_MEAL_RECIPE.get());
        registration.addRecipes(BoilingPotRecipe.BOILING_POT_MEAL, recipes.stream().map(RecipeHolder::value).filter(mealRecipe -> mealRecipe.cookerTypeEnum == CookerTypeEnum.Boiling_Pot).toList());
        registration.addRecipes(CuttingBoardRecipe.CUTTING_BOARD_MEAL, recipes.stream().map(RecipeHolder::value).filter(mealRecipe -> mealRecipe.cookerTypeEnum == CookerTypeEnum.Cutting_Board).toList());
        registration.addRecipes(FryingPanRecipe.FRYING_PAN_MEAL, recipes.stream().map(RecipeHolder::value).filter(mealRecipe -> mealRecipe.cookerTypeEnum == CookerTypeEnum.Frying_Pan).toList());
        registration.addRecipes(GrillRecipe.GRILL_MEAL, recipes.stream().map(RecipeHolder::value).filter(mealRecipe -> mealRecipe.cookerTypeEnum == CookerTypeEnum.Grill).toList());
        registration.addRecipes(SteamerRecipe.STEAMER_MEAL, recipes.stream().map(RecipeHolder::value).filter(mealRecipe -> mealRecipe.cookerTypeEnum == CookerTypeEnum.Steamer).toList());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(ItemRegistry.Boiling_Pot.toStack(), BoilingPotRecipe.BOILING_POT_MEAL);
        registration.addRecipeCatalyst(ItemRegistry.Cutting_Board.toStack(), CuttingBoardRecipe.CUTTING_BOARD_MEAL);
        registration.addRecipeCatalyst(ItemRegistry.Frying_Pan.toStack(), FryingPanRecipe.FRYING_PAN_MEAL);
        registration.addRecipeCatalyst(ItemRegistry.Grill.toStack(), GrillRecipe.GRILL_MEAL);
        registration.addRecipeCatalyst(ItemRegistry.Steamer.toStack(), SteamerRecipe.STEAMER_MEAL);
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }
}
