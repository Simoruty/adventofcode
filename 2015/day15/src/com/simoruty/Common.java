package com.simoruty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Common {
    static ArrayList<String> readFromFile(String path) {
        ArrayList<String> lines = new ArrayList<>();
        try {

            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;

            while ((readLine = b.readLine()) != null) {
                lines.add(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    static ArrayList<Ingredient> fillFeature(ArrayList<String> inputs){

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        for (String input : inputs) {
            Ingredient ingredient = new Ingredient();

            ingredient.setName(input.split(":")[0]);

            ingredient.setCapacity(Integer.parseInt(input.split("capacity")[1].split(",")[0].replace(" ", "")));
            ingredient.setDurability(Integer.parseInt(input.split("durability")[1].split(",")[0].replace(" ", "")));
            ingredient.setFlavor(Integer.parseInt(input.split("flavor")[1].split(",")[0].replace(" ", "")));
            ingredient.setTexture(Integer.parseInt(input.split("texture")[1].split(",")[0].replace(" ", "")));
            ingredient.setCalories(Integer.parseInt(input.split("calories")[1].split(",")[0].replace(" ", "")));

            ingredients.add(ingredient);
        }
        return ingredients;
    }
}
