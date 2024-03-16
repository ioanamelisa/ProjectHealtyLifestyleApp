package com.example.healthylifestyle1;
import android.content.Context;
import java.io.IOException;
import java.io.FileOutputStream;
import android.widget.Toast;
import android.text.TextUtils;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class RecipeDataSource {
    private static final String FILE_NAME = "recipe.txt";

    public static void saveRecipes(Context context, List<Recipe> recipeList) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE); // Overwrite the file
            for (Recipe recipe : recipeList) {
                String recipeString = recipe.getName() + "," + recipe.getIngredients() + "," + recipe.getInstructions() + "\n";
                fileOutputStream.write(recipeString.getBytes());
            }
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Failed to save recipes", Toast.LENGTH_SHORT).show();
        }
    }


    public static void deleteRecipe(Context context, int position){
        List<Recipe> recipeList = getRecipes(context);
        if(position >=0 && position < recipeList.size()){
            recipeList.remove(position);
            saveRecipes(context,recipeList);
        }
    }

    public static void deleteAllRecipes(Context context) {
        List<Recipe> recipeList = new ArrayList<>();
        saveRecipes(context, recipeList);
    }

    public static List<Recipe> getRecipes(Context context) {
        List<Recipe> recipeList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = context.openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] recipeData = line.split(",");
                if (recipeData.length == 3) {
                    String name = recipeData[0];
                    String ingredients = recipeData[1];
                    String instructions = recipeData[2];
                    Recipe recipe = new Recipe(name, ingredients, instructions);
                    recipeList.add(recipe);
                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Failed to retrieve recipes", Toast.LENGTH_SHORT).show();
        }
        return recipeList;
    }
}
