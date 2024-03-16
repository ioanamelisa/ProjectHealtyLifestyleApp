package com.example.healthylifestyle1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;

public class AddRecipe extends AppCompatActivity {

    private EditText recipeNameEditText;
    private EditText ingredientsEditText;
    private EditText instructionsEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foods_activity);

        recipeNameEditText = findViewById(R.id.nameEditText);
        ingredientsEditText = findViewById(R.id.ingredientsEditText);
        instructionsEditText = findViewById(R.id.instructionsEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recipeName = recipeNameEditText.getText().toString();
                String ingredients = ingredientsEditText.getText().toString();
                String instructions = instructionsEditText.getText().toString();

                // Save the recipe
                saveRecipe(recipeName, ingredients, instructions, AddRecipe.this);

                Toast.makeText(AddRecipe.this, "Recipe saved successfully", Toast.LENGTH_SHORT).show();

                recipeNameEditText.setText("");
                ingredientsEditText.setText("");
                instructionsEditText.setText("");
            }
        });
    }

    private void saveRecipe(String recipeName, String ingredients, String instructions, Context context) {
        try {
            FileOutputStream fileOutputStream = openFileOutput("saveRecipe.txt", Context.MODE_APPEND);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);

            String recipeDetails = recipeName + "," + ingredients + "," + instructions + "\n";
            outputStreamWriter.write(recipeDetails);

            outputStreamWriter.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(AddRecipe.this, "Failed to save recipe", Toast.LENGTH_SHORT).show();
        }
    }

}
