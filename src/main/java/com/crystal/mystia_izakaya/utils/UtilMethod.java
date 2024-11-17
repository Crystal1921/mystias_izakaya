package com.crystal.mystia_izakaya.utils;

import com.crystal.mystia_izakaya.client.gui.menu.AbstractCookMenu;
import com.crystal.mystia_izakaya.recipe.MealRecipe;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.mojang.blaze3d.vertex.PoseStack;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UtilMethod {
    public static final int positiveInColor = new Color(230, 180, 166).getRGB();
    public static final int positiveOutColor = new Color(157, 84, 55).getRGB();

    /**
     * @param itemStacks 物品列表
     * @param meals      所有菜肴
     * @param cookerType 筛选的厨具类型
     * @return {@code List<Item>} 返回所有符合条件的菜肴
     */
    public static List<MealRecipe> getItems(NonNullList<ItemStack> itemStacks, List<MealRecipe> meals, CookerTypeEnum cookerType) {
        List<ItemStack> ingredients = itemStacks
                .stream()
                .limit(5)//限定前五个格子为材料格
                .filter(itemStack -> !itemStack.isEmpty())
                .toList();
        return meals.stream()
                .parallel()
                .filter(item -> item.cookerTypeEnum == cookerType)
                .filter(item -> isMatchedRecipe(ingredients, item.getIngredients()))
                .collect(Collectors.toList());
    }

    /**
     * @param cookMenu   菜肴所在的容器
     * @param mealRecipe 菜肴
     * @return 返回正确的菜肴标签
     */
    public static @NotNull ArrayList<FoodTagEnum> getPositiveTags(AbstractCookMenu cookMenu, MealRecipe mealRecipe) {
        if (mealRecipe.result.is(ItemRegistry.Dark_Matter)) {
            return new ArrayList<>();
        }
        TagModify tagModify = new TagModify();
        tagModify.setFull(cookMenu.isFull());
        //菜肴正面标签
        ArrayList<FoodTagEnum> positiveTags = BytesToTagList(mealRecipe.positiveTag.array());
        //菜肴食材
        NonNullList<Ingredient> ingredients = mealRecipe.getIngredients();

        // 将多余食材的标签加入展示列表，并标记冲突
        ArrayList<Ingredient> menuItems = new ArrayList<>(cookMenu.getIngredientList()).stream()
                .map(Ingredient::of)
                .collect(Collectors.toCollection(ArrayList::new)); // 确保menuItems是可修改的

        Iterator<Ingredient> iterator = menuItems.iterator();
        while (iterator.hasNext()) {
            Ingredient item = iterator.next();
            if (ingredients.contains(item)) {
                ingredients.remove(item);
                iterator.remove();
            }
        }

        menuItems.stream()
                .map(UtilMethod::getItemFoodTag)
                .flatMap(List::stream)
                .forEach(foodTagEnum -> {
                    positiveTags.add(foodTagEnum);
                    tagModify.markConflict(foodTagEnum);
                });
        //清除重复标签
        return positiveTags.stream()
                .distinct()
                .filter(foodTagEnum -> !tagModify.isConflict(foodTagEnum))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static @NotNull ArrayList<String> getPositiveStings(AbstractCookMenu cookMenu, MealRecipe mealRecipe) {
        return getPositiveTags(cookMenu, mealRecipe).stream()
                .map(foodTagEnum -> Component.translatable("mystia_izakaya." + foodTagEnum.name()).getString())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static @NotNull IntList getPositiveIntList(AbstractCookMenu cookMenu, MealRecipe mealRecipe) {
        IntList list = new IntArrayList();
        getPositiveTags(cookMenu, mealRecipe).forEach(foodTagEnum -> list.add(foodTagEnum.ordinal()));
        return list;
    }

    @SuppressWarnings("deprecation")
    public static byte[] getByteArray(IntList intList) {
        byte[] byteArray = new byte[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            byteArray[i] = intList.get(i).byteValue();
        }
        return byteArray;
    }

    /**
     * @param pDropShadow 是否有阴影
     * @param selected    背景色是否加深
     */
    @SuppressWarnings("deprecation")
    public static void drawStringSize(GuiGraphics guiGraphics, Font pFont, Component pText, int pX, int pY, int pColor, boolean pDropShadow, boolean selected) {
        int width = pFont.width(pText.getString());
        if (width <= 36) {
            width = 36;
        }
        float scale = 24.0F / width;
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.scale(scale, scale, scale);
        int color = selected ? positiveOutColor : positiveInColor;
        guiGraphics.fill((int) (pX / scale), (int) ((pY - 1) / scale), (int) ((pX + 26) / scale), (int) ((pY + 9) / scale), color);
        pFont.drawInBatch(pText.getVisualOrderText(), pX / scale, pY / scale, pColor, pDropShadow, poseStack.last().pose(), guiGraphics.bufferSource(), Font.DisplayMode.NORMAL, 0, 15728880);
        poseStack.popPose();
        guiGraphics.flushIfUnmanaged();
    }

    /**
     * @param pMouseX 鼠标位置 X
     * @param pMouseY 鼠标位置 Y
     * @return 返回鼠标位置在标签列表中的第几个
     */
    public static int getBoxIndex(double pMouseX, double pMouseY, int i, int j, int totalBoxes) {
        // 假设方框的尺寸和起始位置
        final int BOX_WIDTH = 26;
        final int BOX_HEIGHT = 9;
        final int BOXES_PER_ROW = 4;
        final int BOX_SPACING_X = 28;
        final int BOX_SPACING_Y = 12;
        final int OFFSET_X = 13;
        final int OFFSET_Y = 27;

        double relativeX = pMouseX - i - OFFSET_X;
        double relativeY = pMouseY - j - OFFSET_Y;

        if (relativeX < 0 || relativeY < 0) {
            return -1;
        }

        int col = (int) (relativeX / BOX_SPACING_X);
        int row = (int) (relativeY / BOX_SPACING_Y);

        // 计算方框索引
        int index = row * BOXES_PER_ROW + col;

        if (col >= BOXES_PER_ROW || index >= totalBoxes ||
                relativeX % BOX_SPACING_X >= BOX_WIDTH || relativeY % BOX_SPACING_Y >= BOX_HEIGHT) {
            return -1;
        }

        return index;
    }

    /**
     * 将标签列表为数组
     *
     * @param enumList 标签列表
     * @return 按枚举类的索引转换成数字
     */
    public static byte[] TagListToBytes(List<FoodTagEnum> enumList) {
        // 创建一个 ByteBuffer，大小为枚举列表的大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(enumList.size());

        // 将每个枚举的序列号（ordinal）放入 ByteBuffer
        for (FoodTagEnum foodTag : enumList) {
            byteBuffer.put((byte) foodTag.ordinal()); // 将 ordinal 转为 byte
        }

        // 返回 byte 数组
        return byteBuffer.array();
    }

    /**
     * 将数据转为标签列表
     *
     * @param bytes 数字标签数组
     * @return 按枚举类的索引转换成标签
     */
    public static ArrayList<FoodTagEnum> BytesToTagList(byte[] bytes) {
        ArrayList<FoodTagEnum> enumList = new ArrayList<>();

        for (byte b : bytes) {
            int ordinal = Byte.toUnsignedInt(b);
            FoodTagEnum foodTag = FoodTagEnum.values()[ordinal];
            enumList.add(foodTag);
        }

        return enumList;
    }

    @SuppressWarnings("deprecation")
    public static List<FoodTagEnum> getItemFoodTag(Ingredient ingredient) {
        ItemStack itemStack = ingredient.getItems()[0];
        return itemStack.getItem().builtInRegistryHolder().tags().map(tagKey -> LocalMealList.getInstance().getFoodTypeMap().get(tagKey.location().getPath())).filter(Objects::nonNull).toList();
    }

    /**
     * 容器的物品是否包含配方所需的
     *
     * @param items       容器内的物品
     * @param ingredients 配方需要的材料
     */
    public static boolean isMatchedRecipe(List<ItemStack> items, NonNullList<Ingredient> ingredients) {
        for (Ingredient ingredient : ingredients) {
            boolean matched = false;
            for (ItemStack itemStack : items) {
                if (ingredient.test(itemStack)) {
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                return false;
            }
        }
        return true;
    }

}
