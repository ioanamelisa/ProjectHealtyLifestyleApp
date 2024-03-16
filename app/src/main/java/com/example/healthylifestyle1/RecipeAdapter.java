package com.example.healthylifestyle1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.text.TextUtils;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> recipeList;
    private OnRecipeDeleteListener onRecipeDeleteListener;

    public RecipeAdapter(List<Recipe> recipeList, OnRecipeDeleteListener onRecipeDeleteListener) {
        this.recipeList = recipeList;
        this.onRecipeDeleteListener = onRecipeDeleteListener;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);
        holder.recipeNameTextView.setText(recipe.getName());
        holder.ingredientsTextView.setText(recipe.getIngredients());
        holder.instructionsTextView.setText(recipe.getInstructions());

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecipeDeleteListener.onRecipeDelete(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public interface OnRecipeDeleteListener{
        void onRecipeDelete(int position);
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        public TextView recipeNameTextView;
        public TextView ingredientsTextView;
        public TextView instructionsTextView;
        public View deleteButton;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            recipeNameTextView = itemView.findViewById(R.id.textViewRecipeName);
            ingredientsTextView = itemView.findViewById(R.id.textViewIngredients);
            instructionsTextView = itemView.findViewById(R.id.textViewInstructions);
            deleteButton = itemView.findViewById(R.id.deleteButton);

        }
    }

    
}