package com.crystal.mystia_izakaya.utils;

public enum FoodTagEnum {
    Empty("空"),
    Expensive("昂贵"),
    Economical("实惠"),
    Large_Portion("大份"),
    Meat("肉"),
    Aquatic("水产"),
    Vegetarian("素"),
    Homecooking("家常"),
    Premium("高级"),
    Legendary("传说"),
    Greasy("重油"),
    Mild("清淡"),
    Good_Alcohol("下酒"),
    Filling("饱腹"),
    Mountain_Delicacy("山珍"),
    Sea_Delicacy("海味"),
    Japanese("和风"),
    Western("西式"),
    Chinese("中华"),
    Salty("咸"),
    Fresh("鲜"),
    Sweet("甜"),
    Raw("生"),
    Signature("招牌"),
    Photogenic("适合拍照"),
    Refreshing("凉爽"),
    Hot("灼热"),
    Strength_Boosting("力量涌现"),
    Peculiar("猎奇"),
    Cultural_Heritage("文化底蕴"),
    Fungus("菌类"),
    Wonderful("不可思议"),
    Small_Portion("小巧"),
    Dreamy("梦幻"),
    Specialty("特产"),
    Fruity("果味"),
    Soup("汤羹"),
    Grilled("烧烤"),
    Spicy("辣"),
    Aura_Bursting("燃起来了"),
    Sour("酸"),
    Poison("毒");

    final String cn;

    FoodTagEnum(String cn) {
        this.cn = cn;
    }

    public String getCn() {
        return cn;
    }
}
