package com.playdata.game.dto;

public class Inventory {
    private String name;
    private String item;
    private int gold;

    public Inventory(String name, String item, int gold) {
        this.name = name;
        this.item = item;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
