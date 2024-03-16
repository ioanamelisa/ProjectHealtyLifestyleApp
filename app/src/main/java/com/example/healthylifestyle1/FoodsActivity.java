package com.example.healthylifestyle1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import java.io.IOException;
import java.io.FileOutputStream;
import android.text.TextUtils;

public class FoodsActivity extends AppCompatActivity {

    private EditText recipeNameEditText;
    private EditText ingredientsEditText;
    private EditText instructionsEditText;
    private Button saveButton;
    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foods_activity);

        recipeNameEditText = findViewById(R.id.nameEditText);
        ingredientsEditText = findViewById(R.id.ingredientsEditText);
        instructionsEditText = findViewById(R.id.instructionsEditText);
        saveButton = findViewById(R.id.saveButton);

        recipeList = RecipeDataSource.getRecipes(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipeName = recipeNameEditText.getText().toString();
                String ingredients = ingredientsEditText.getText().toString();
                String instructions = instructionsEditText.getText().toString();

                if (TextUtils.isEmpty(recipeName) || TextUtils.isEmpty(ingredients) || TextUtils.isEmpty(instructions)) {
                    Toast.makeText(FoodsActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                //new recipe object
                Recipe recipe = new Recipe(recipeName, ingredients, instructions);
                recipeList.add(recipe);
                RecipeDataSource.saveRecipes(FoodsActivity.this, recipeList);

                Toast.makeText(FoodsActivity.this, "Recipe saved successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(FoodsActivity.this, ViewRecipe.class);
                startActivity(intent);

                //clear input fields
                recipeNameEditText.getText().clear();
                ingredientsEditText.getText().clear();
                instructionsEditText.getText().clear();
            }
        });
    }

}
