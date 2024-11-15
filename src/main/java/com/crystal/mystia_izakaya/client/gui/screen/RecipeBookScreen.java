package com.crystal.mystia_izakaya.client.gui.screen;

import com.crystal.mystia_izakaya.client.gui.widget.MealEntry;
import com.crystal.mystia_izakaya.client.gui.widget.MealListWidget;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.component.FoodTagComponent;
import com.crystal.mystia_izakaya.network.TagsPacket;
import com.crystal.mystia_izakaya.network.TargetIndexPacket;
import com.crystal.mystia_izakaya.registry.ComponentRegistry;
import com.crystal.mystia_izakaya.registry.ItemRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import com.crystal.mystia_izakaya.utils.LocalMealList;
import com.crystal.mystia_izakaya.utils.UtilMethod;
import com.mojang.blaze3d.platform.InputConstants;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ObjectSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;
import static com.crystal.mystia_izakaya.utils.UtilMethod.*;

public class RecipeBookScreen extends Screen {
    final int black = Color.BLACK.getRGB();
    private final int imageWidth;
    private final int imageHeight;
    public int listWidth = 90;
    ResourceLocation BACKGROUND = resourceLocation("textures/gui/recipe_bg.png");
    List<FoodTagEnum> foodTagEnums = List.of(FoodTagEnum.values());
    ArrayList<FoodTagEnum> foodTagSelected = new ArrayList<>();
    List<CookedMealItem> cookedMealItems = LocalMealList.getInstance().getCookedMeals();
    final List<CookedMealItem> unsortedCookedMealItems = cookedMealItems;
    MealEntry selected;
    EditBox search;
    String lastFilterText = "";
    MealListWidget mealListWidget;
    ItemStack recipeBookItem;

    public RecipeBookScreen(ItemStack recipeBookItem) {
        super(Component.translatable("gui.mystia_izakaya.meal"));
        this.recipeBookItem = recipeBookItem;
        FoodTagComponent foodTagComponent = recipeBookItem.get(ComponentRegistry.FOOD_TAG);
        if (foodTagComponent != null) {
            foodTagSelected = new ArrayList<>(foodTagComponent.intList()).stream().map(integer -> foodTagEnums.get(integer)).collect(Collectors.toCollection(ArrayList::new));
        } else {
            foodTagSelected.add(FoodTagEnum.Empty);
        }
        this.imageWidth = 230;
        this.imageHeight = 219;
    }

    @Override
    public void init() {
        super.init();
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.search = new EditBox(getFontRenderer(), i + 12, j + 9, 50, 15, Component.translatable("fml.menu.mods.search"));
        this.search.setFocused(false);
        this.addRenderableWidget(search);
        this.mealListWidget = new MealListWidget(this, listWidth, j + 87, j + 108);
        this.mealListWidget.setX(i + 128);
        this.addRenderableWidget(mealListWidget);
        this.addRenderableWidget(Button.builder(Component.translatable("gui.mystia_izakaya.confirm"), (button) ->
                this.importEvent()).bounds(i + 65, j + 9, 50, 15).build());
        reloadItems();
        this.mealListWidget.setScrollAmount(0);
        mealListWidget.refreshList();
    }

    public <T extends ObjectSelectionList.Entry<T>> void buildImageList(Consumer<T> modListViewConsumer, Function<CookedMealItem, T> newEntry) {
        cookedMealItems.forEach(cookedMealItem -> modListViewConsumer.accept(newEntry.apply(cookedMealItem)));
    }

    private void reloadItems() {
        if (!foodTagSelected.contains(FoodTagEnum.Empty)) {
            this.cookedMealItems = unsortedCookedMealItems.stream()
                    .filter(cookedMealItem -> Component.translatable(cookedMealItem.getDescriptionId()).getString().contains(search.getValue()))
                    .filter(cookedMealItem -> new HashSet<>(cookedMealItem.positiveTag).containsAll(foodTagSelected))
                    .collect(Collectors.toList());
        } else {
            this.cookedMealItems = unsortedCookedMealItems.stream()
                    .filter(cookedMealItem -> Component.translatable(cookedMealItem.getDescriptionId()).getString().contains(search.getValue()))
                    .collect(Collectors.toList());
        }

        lastFilterText = search.getValue();
    }

    public void setSelected(MealEntry entry) {
        this.selected = entry;
    }

    public MealListWidget getMealListWidget() {
        return mealListWidget;
    }

    @Override
    public void tick() {
        super.tick();
        if (!search.getValue().equals(lastFilterText)) {
            reloadItems();
            this.mealListWidget.setScrollAmount(0);
            mealListWidget.refreshList();
        }
    }

    @NotNull
    public Minecraft getMinecraftInstance() {
        return minecraft;
    }

    public Font getFontRenderer() {
        return font;
    }

    public void importEvent() {
        if (selected != null) {
            CookedMealItem cookedMealItem = selected.getCookedMealItem();
            if (Minecraft.getInstance().player != null) {
                ItemStack itemStack = Minecraft.getInstance().player.getMainHandItem();
                if (itemStack.is(ItemRegistry.RecipeBook)) {
                    int index = unsortedCookedMealItems.indexOf(cookedMealItem);
                    itemStack.set(ComponentRegistry.TARGET_ITEM, index);
                    PacketDistributor.sendToServer(new TargetIndexPacket(index));
                    Minecraft.getInstance().setScreen(null);
                }
            }
        }
    }

    @Override
    public boolean keyPressed(int pKeyCode, int pScanCode, int pModifiers) {
        InputConstants.Key mouseKey = InputConstants.getKey(pKeyCode, pScanCode);
        if (pKeyCode == 256 && this.shouldCloseOnEsc()) {
            this.onClose();
            return true;
        }
        if (this.search.isFocused()) {
            return search.keyPressed(pKeyCode, pScanCode, pModifiers);
        } else {
            if (this.minecraft != null && this.minecraft.options.keyInventory.isActiveAndMatches(mouseKey)) {
                this.onClose();
                return true;
            }
            return super.keyPressed(pKeyCode, pScanCode, pModifiers);
        }
    }


    @Override
    public void renderBackground(@NotNull GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderTransparentBackground(pGuiGraphics);
        this.renderBg(pGuiGraphics, pPartialTick, pMouseX, pMouseY);
    }

    protected void renderBg(@NotNull GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        pGuiGraphics.blit(BACKGROUND, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(guiGraphics, pMouseX, pMouseY, pPartialTick);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        renderInfo(guiGraphics, i, j);
        renderTags(guiGraphics, i, j);
        renderIngredient(guiGraphics, i, j);
    }

    private void renderIngredient(@NotNull GuiGraphics guiGraphics, int i, int j) {
        if (selected != null) {
            CookedMealItem cookedMealItem = selected.getCookedMealItem();
            List<Ingredient> ingredients = cookedMealItem.ingredients;
            CookerTypeEnum cookerTypeEnum = cookedMealItem.cookerTypeEnum;
            ItemStack cooker = LocalMealList.getInstance().getCookerTypeMap().get(cookerTypeEnum).getDefaultInstance();
            for (int k = 0; k < ingredients.size(); k++) {
                int x = i + k * 24 + 12;
                int y = j + 170;
                guiGraphics.fill(x, y, x + 16, y + 16, positiveInColor);
                guiGraphics.renderItem(ingredients.get(k).getItems()[0], x, y);
            }
            guiGraphics.renderItem(cooker, i + 2 * 24 + 12, j + 190);
        }
    }

    private void renderInfo(@NotNull GuiGraphics guiGraphics, int i, int j) {
        if (selected != null) {
            int deltaX = 114;
            CookedMealItem cookedMealItem = selected.getCookedMealItem();
            guiGraphics.drawString(font, Component.translatable(cookedMealItem.getDescriptionId()), i + 15 + deltaX, j + 8, black, false);
            guiGraphics.drawString(font, Component.translatable("gui.mystia_izakaya.level").append(": " + cookedMealItem.level), i + 15 + deltaX, j + 18, black, false);
            guiGraphics.drawString(font, Component.translatable("gui.mystia_izakaya.cooking_time").append(": " + cookedMealItem.cookingTime), i + 15 + deltaX, j + 28, black, false);
            guiGraphics.drawString(font, Component.translatable("gui.mystia_izakaya.tags").append(":"), i + 15 + deltaX, j + 38, black, false);
            List<String> positiveStings = cookedMealItem.positiveTag.stream()
                    .map(foodTagEnum -> Component.translatable("mystia_izakaya." + foodTagEnum.name()).getString())
                    .collect(Collectors.toCollection(ArrayList::new));
            int stringLength = 0;
            int stringHeight = 0;
            for (int k = 0; k < positiveStings.size(); k++) {
                //guiGraphics.fill(i + 15 + stringLength * 10 - 2, j + 50 + stringHeight * 10 - 1,i + 15 + stringLength * 10 + positiveStings.get(k).length() * 9 + 1, j + 50 + stringHeight * 10 + 9,positiveOutColor);
                //guiGraphics.fill(i + 15 + stringLength * 10 - 1, j + 50 + stringHeight * 10,i + 15 + stringLength * 10 + positiveStings.get(k).length() * 9, j + 50 + stringHeight * 10 + 8,positiveInColor);
                guiGraphics.drawString(font, positiveStings.get(k), i + 128 + stringLength * 10, j + 48 + stringHeight * 10, black, false);
                stringLength += positiveStings.get(k).length();
                if (positiveStings.size() > k + 1) {
                    if (stringLength + positiveStings.get(k + 1).length() > 10) {
                        stringLength = 0;
                        stringHeight++;
                    }
                }
            }
        }
    }

    private void renderTags(@NotNull GuiGraphics guiGraphics, int i, int j) {
        for (int k = 0; k < foodTagEnums.size(); k++) {
            int stringX = i + k % 4 * 28 + 13;
            int stringY = j + k / 4 * 12 + 28;
            boolean selected = foodTagSelected.contains(foodTagEnums.get(k));
            drawStringSize(guiGraphics, font, Component.translatable("mystia_izakaya." + foodTagEnums.get(k).name()), stringX, stringY, black, false, selected);
        }
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        int index = UtilMethod.getBoxIndex(pMouseX, pMouseY, i, j, foodTagEnums.size());
        //处理Tag点击事件
        if (index != -1) {
            if (index == 0) {
                if (!foodTagSelected.contains(foodTagEnums.get(index))) {
                    foodTagSelected = new ArrayList<>();
                    foodTagSelected.add(FoodTagEnum.Empty);
                }
            } else {
                FoodTagEnum foodTagEnum = foodTagEnums.get(index);
                foodTagSelected.remove(FoodTagEnum.Empty);
                if (foodTagSelected.contains(foodTagEnum)) {
                    foodTagSelected.remove(foodTagEnum);
                    if (foodTagSelected.isEmpty()) foodTagSelected.add(FoodTagEnum.Empty);
                } else {
                    foodTagSelected.add(foodTagEnum);
                }
            }
        }
        if (Minecraft.getInstance().player != null) {
            ItemStack itemStack = Minecraft.getInstance().player.getMainHandItem();
            if (itemStack.is(ItemRegistry.RecipeBook)) {
                IntList integerList = new IntArrayList();
                foodTagSelected.forEach(foodTagEnum -> integerList.add(foodTagEnum.ordinal()));
                itemStack.set(ComponentRegistry.FOOD_TAG, new FoodTagComponent(integerList));
                PacketDistributor.sendToServer(new TagsPacket(getByteArray(integerList)));
            }
        }
        reloadItems();
        mealListWidget.refreshList();
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }
}
