package com.crystal.mystia_izakaya.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;

public class CookerSerializer implements RecipeSerializer<MealRecipe> {
    private static final MapCodec<MealRecipe> CODEC = RecordCodecBuilder.mapCodec(
            recipeInstance -> recipeInstance.group(
                            Codec.STRING.optionalFieldOf("group", "").forGetter(ShapelessRecipe::getGroup),
                            CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(mealRecipe -> mealRecipe.category),
                            ItemStack.STRICT_CODEC.fieldOf("result").forGetter(mealRecipe -> mealRecipe.result),
                            Ingredient.CODEC_NONEMPTY
                                    .listOf()
                                    .fieldOf("ingredients")
                                    .flatXmap(
                                            ingredientList -> {
                                                Ingredient[] aingredient = ingredientList.toArray(Ingredient[]::new); // Neo skip the empty check and immediately create the array.
                                                if (aingredient.length == 0) {
                                                    return DataResult.error(() -> "No ingredients for shapeless recipe");
                                                } else {
                                                    return aingredient.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth()
                                                            ? DataResult.error(() -> "Too many ingredients for shapeless recipe. The maximum is: %s".formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth()))
                                                            : DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
                                                }
                                            },
                                            DataResult::success
                                    )
                                    .forGetter(ShapelessRecipe::getIngredients)
                    )
                    .apply(recipeInstance, MealRecipe::new));

    public final StreamCodec<RegistryFriendlyByteBuf, MealRecipe> STREAM_CODEC = StreamCodec.of(
            this::toNetwork, this::fromNetwork
    );


    @Override
    public @NotNull MapCodec<MealRecipe> codec() {
        return CODEC;
    }

    @Override
    public @NotNull StreamCodec<RegistryFriendlyByteBuf, MealRecipe> streamCodec() {
        return STREAM_CODEC;
    }

    private MealRecipe fromNetwork(RegistryFriendlyByteBuf friendlyByteBuf) {
        String s = friendlyByteBuf.readUtf();
        CraftingBookCategory craftingbookcategory = friendlyByteBuf.readEnum(CraftingBookCategory.class);
        int i = friendlyByteBuf.readVarInt();
        NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
        nonnulllist.replaceAll(ingredient -> Ingredient.CONTENTS_STREAM_CODEC.decode(friendlyByteBuf));
        ItemStack itemstack = ItemStack.STREAM_CODEC.decode(friendlyByteBuf);
        return new MealRecipe(s, craftingbookcategory, itemstack, nonnulllist);
    }

    private void toNetwork(RegistryFriendlyByteBuf friendlyByteBuf, MealRecipe mealRecipe) {
        friendlyByteBuf.writeUtf(mealRecipe.group);
        friendlyByteBuf.writeEnum(mealRecipe.category);
        friendlyByteBuf.writeVarInt(mealRecipe.getIngredients().size());

        for (Ingredient ingredient : mealRecipe.getIngredients()) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(friendlyByteBuf, ingredient);
        }

        ItemStack.STREAM_CODEC.encode(friendlyByteBuf, mealRecipe.result);
    }
}
