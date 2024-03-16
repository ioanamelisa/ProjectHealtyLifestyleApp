package com.example.healthylifestyle1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ScreenTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_two);

        Button btnToDoList = findViewById(R.id.btn_todolist);
        Button btnWorkouts = findViewById(R.id.btn_workouts);
        Button btnFoods = findViewById(R.id.btn_foods);
        Button btnInspirationalQuotes = findViewById(R.id.btn_inspirational_quotes);

        btnToDoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScreenTwo.this, ToDoList.class);
                startActivity(intent);
            }
        });


        btnWorkouts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScreenTwo.this, WorkoutsActivity.class);
                startActivity(intent);
            }
        });


        btnFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScreenTwo.this, ViewRecipe.class);
                startActivity(intent);
            }
        });

        btnInspirationalQuotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScreenTwo.this, InspirationalQuotesActivity.class);
                startActivity(intent);
            }
        });

    }
}
