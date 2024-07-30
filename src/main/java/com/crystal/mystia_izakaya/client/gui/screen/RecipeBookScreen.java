package com.crystal.mystia_izakaya.client.gui.screen;

import com.crystal.mystia_izakaya.client.gui.widget.MealEntry;
import com.crystal.mystia_izakaya.client.gui.widget.MealListWidget;
import com.crystal.mystia_izakaya.client.item.CookedMealItem;
import com.crystal.mystia_izakaya.component.CookerTypeComponent;
import com.crystal.mystia_izakaya.component.FoodTagComponent;
import com.crystal.mystia_izakaya.registry.ComponentRegistry;
import com.crystal.mystia_izakaya.utils.CookerTypeEnum;
import com.crystal.mystia_izakaya.utils.FoodTagEnum;
import com.crystal.mystia_izakaya.utils.MealList;
import com.crystal.mystia_izakaya.utils.UtilMethod;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ObjectSelectionList;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.crystal.mystia_izakaya.MystiaIzakaya.resourceLocation;
import static com.crystal.mystia_izakaya.utils.UtilMethod.drawStringSize;

public class RecipeBookScreen extends Screen {
    final int black = Color.BLACK.getRGB();
    private final int imageWidth;
    private final int imageHeight;
    public int listWidth = 90;
    ResourceLocation BACKGROUND = resourceLocation("textures/gui/recipe_bg.png");
    List<FoodTagEnum> foodTagEnums = List.of(FoodTagEnum.values());
    ArrayList<FoodTagEnum> foodTagSelected = new ArrayList<>();
    List<CookerTypeEnum> cookerTypeEnums = List.of(CookerTypeEnum.values());
    CookerTypeEnum cookerSelected;
    List<CookedMealItem> cookedMealItems = MealList.getInstance().getCookedMeals();
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
        CookerTypeComponent cookerTypeComponent = recipeBookItem.get(ComponentRegistry.COOKER);
        if (cookerTypeComponent != null) {
            cookerSelected = cookerTypeEnums.get(cookerTypeComponent.cookerType());
        }
        this.imageWidth = 230;
        this.imageHeight = 219;
    }

    @Override
    public void init() {
        super.init();
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.search = new EditBox(getFontRenderer(), i + 10, j + 6, listWidth, 15, Component.translatable("fml.menu.mods.search"));
        this.search.setFocused(false);
        this.addRenderableWidget(search);
        this.mealListWidget = new MealListWidget(this, listWidth, j + 87, j + 108);
        this.mealListWidget.setX(i + 128);
        this.addRenderableWidget(mealListWidget);
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
        this.mealListWidget.setScrollAmount(0);
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
        renderInfo(guiGraphics, pMouseX, pMouseY, pPartialTick, i, j);
        renderTags(guiGraphics, pMouseX, pMouseY, pPartialTick, i, j);
    }

    private void renderInfo(@NotNull GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick, int i, int j) {
        if (selected != null) {
            int deltaX = 114;
            CookedMealItem cookedMealItem = selected.getCookedMealItem();
            guiGraphics.drawString(font, Component.translatable(cookedMealItem.getDescriptionId()), i + 15 + deltaX, j + 10, black, false);
            guiGraphics.drawString(font, Component.translatable("gui.mystia_izakaya.level").append(": " + cookedMealItem.level), i + 15 + deltaX, j + 20, black, false);
            guiGraphics.drawString(font, Component.translatable("gui.mystia_izakaya.cooking_time").append(": " + cookedMealItem.cookingTime), i + 15 + deltaX, j + 30, black, false);
            guiGraphics.drawString(font, Component.translatable("gui.mystia_izakaya.tags").append(":"), i + 15 + deltaX, j + 40, black, false);
            List<String> positiveStings = cookedMealItem.positiveTag.stream()
                    .map(foodTagEnum -> Component.translatable("mystia_izakaya." + foodTagEnum.name()).getString())
                    .collect(Collectors.toCollection(ArrayList::new));
            ;
            int stringLength = 0;
            int stringHeight = 0;
            for (int k = 0; k < positiveStings.size(); k++) {
                //guiGraphics.fill(i + 15 + stringLength * 10 - 2, j + 50 + stringHeight * 10 - 1,i + 15 + stringLength * 10 + positiveStings.get(k).length() * 9 + 1, j + 50 + stringHeight * 10 + 9,positiveOutColor);
                //guiGraphics.fill(i + 15 + stringLength * 10 - 1, j + 50 + stringHeight * 10,i + 15 + stringLength * 10 + positiveStings.get(k).length() * 9, j + 50 + stringHeight * 10 + 8,positiveInColor);
                guiGraphics.drawString(font, positiveStings.get(k), i + 128 + stringLength * 10, j + 50 + stringHeight * 10, black, false);
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

    private void renderTags(@NotNull GuiGraphics guiGraphics, int pMouseX, int pMouseY, float pPartialTick, int i, int j) {
        for (int k = 0; k < foodTagEnums.size(); k++) {
            int stringX = i + k % 4 * 28 + 13;
            int stringY = j + k / 4 * 12 + 24;
            boolean selected = foodTagSelected.contains(foodTagEnums.get(k));
            drawStringSize(guiGraphics, font, Component.translatable("mystia_izakaya." + foodTagEnums.get(k).name()), stringX, stringY, black, false, 0.75f, selected);
        }
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        int index = UtilMethod.getBoxIndex(pMouseX, pMouseY, i, j, foodTagEnums.size());
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
                } else {
                    foodTagSelected.add(foodTagEnum);
                }
            }
        }
        reloadItems();
        mealListWidget.refreshList();
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }
}
