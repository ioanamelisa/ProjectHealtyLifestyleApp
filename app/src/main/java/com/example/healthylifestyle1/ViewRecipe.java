package com.example.healthylifestyle1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ViewRecipe extends AppCompatActivity implements RecipeAdapter.OnRecipeDeleteListener {

    private RecyclerView recyclerView;
    private RecipeAdapter recipeAdapter;
    private List<Recipe> recipeList;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_recipe);

        recyclerView = findViewById(R.id.recipeRecyclerView);
        recipeList = RecipeDataSource.getRecipes(this);
        recipeAdapter = new RecipeAdapter(recipeList, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recipeAdapter);

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewRecipe.this, FoodsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        recipeList.clear();
        recipeList.addAll(RecipeDataSource.getRecipes(this)); // Fetch the updated recipe list
        recipeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRecipeDelete(int position) {
        recipeList.remove(position);
        recipeAdapter.notifyDataSetChanged();
        RecipeDataSource.saveRecipes(this, recipeList);

        Toast.makeText(this, "Recipe deleted", Toast.LENGTH_SHORT).show();
    }
}