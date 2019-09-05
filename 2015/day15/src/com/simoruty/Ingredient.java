package com.simoruty;

public class Ingredient {
    private String name;
    private int capacity;
    private int flavor;
    private int texture;
    private int calories;
    private int durability;

    Ingredient() {
    }

    Ingredient(String name, int capacity, int flavor, int texture, int calories, int durability) {
        this.name = name;
        this.capacity = capacity;
        this.flavor = flavor;
        this.texture = texture;
        this.calories = calories;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getCapacity() {
        return capacity;
    }

    void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    int getFlavor() {
        return flavor;
    }

    void setFlavor(int flavor) {
        this.flavor = flavor;
    }

    int getTexture() {
        return texture;
    }

    void setTexture(int texture) {
        this.texture = texture;
    }

    int getCalories() {
        return calories;
    }

    void setCalories(int calories) {
        this.calories = calories;
    }

    int getDurability() {
        return durability;
    }

    void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", flavor=" + flavor +
                ", texture=" + texture +
                ", calories=" + calories +
                ", durability=" + durability +
                '}';
    }
}
