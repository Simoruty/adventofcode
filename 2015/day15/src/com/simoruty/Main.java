package com.simoruty;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> input = Common.readFromFile("./input");
        ArrayList<Ingredient> ingredients = Common.fillFeature(input);

        int scoreMax = 0;
        int[] totMax = new int[4];

        ArrayList<int[]> tots = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
            for (int j = 1; j <= 100 - i; j++)
                for (int k = 1; k <= 100 - i - j; k++)
                    for (int l = 0; l <= 100 - i - j - k; l++)
                        tots.add(new int[]{i, j, k, l});

        for (int[] tot : tots) {
            int score = 0;
            int capacityTot = 0;
            int flavorTot = 0;
            int textureTot = 0;
            int durabilityTot = 0;
            int caloriesTot = 0;

            for (int i = 0, ingredientsSize = ingredients.size(); i < ingredientsSize; i++) {
                Ingredient ingredient = ingredients.get(i);
                capacityTot += ingredient.getCapacity() * tot[i];
                flavorTot += ingredient.getFlavor() * tot[i];
                textureTot += ingredient.getTexture() * tot[i];
                durabilityTot += ingredient.getDurability() * tot[i];
                caloriesTot += ingredient.getCalories() * tot[i];

            }
            if (capacityTot > 0 && flavorTot > 0 && textureTot > 0 && durabilityTot > 0)
                score = capacityTot * flavorTot * textureTot * durabilityTot;

            /* Task 1
            if (score > scoreMax) {
                scoreMax = score;
                totMax = tot;
            }
            */

            // Task 2
            if (score > scoreMax && caloriesTot == 500) {
                scoreMax = score;
                totMax = tot;
            }
        }

        System.out.println("The highest-scoring cookie you can make with a calorie total of 500 is: " + scoreMax);
        System.out.println("The number of teaspoons that you can used for the ingredients are: " + Arrays.toString(totMax));


    }
}
