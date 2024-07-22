package com.crystal.mystia_izakaya.utils;

public class TagModify {
    boolean isMeat, isGreasy, isLarge, isHot, isFilling, isFull;
    public void markConflict(FoodTagEnum foodTagEnum) {
        switch (foodTagEnum) {
            case Meat -> this.isMeat = true;
            case Greasy -> this.isGreasy = true;
            case Large_Portion -> this.isLarge = true;
            case Hot -> this.isHot = true;
            case Filling -> this.isFilling = true;
        }
    }

    public boolean isConflict(FoodTagEnum foodTagEnum) {
        switch (foodTagEnum) {
            case Vegetarian -> {
                return this.isMeat;
            }
            case Mild -> {
                return this.isGreasy;
            }
            case Small_Portion -> {
                return this.isLarge;
            }
            case Refreshing -> {
                return this.isHot;
            }
            case Good_Alcohol -> {
                return this.isFilling;
            }
            default -> {
                return false;
            }
        }
    }

    public void setFull(boolean isFull) {
        this.isFull = isFull;
    }
}
