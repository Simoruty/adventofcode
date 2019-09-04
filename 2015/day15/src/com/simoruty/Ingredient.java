package com.simoruty;

public class Ingredient {
    private String name;
    private String capacity;
    private String flavor;
    private String texture;
    private String calories;
    private String durability;

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public Ingredient() {
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", capacity='" + capacity + '\'' +
                ", flavor='" + flavor + '\'' +
                ", texture='" + texture + '\'' +
                ", calories='" + calories + '\'' +
                ", durability='" + durability + '\'' +
                '}';
    }
}
