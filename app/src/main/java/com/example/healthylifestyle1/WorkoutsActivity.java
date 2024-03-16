package com.example.healthylifestyle1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WorkoutsActivity extends AppCompatActivity implements WorkoutAdapter.OnWorkoutClickListener {

    private RecyclerView recyclerView;
    private WorkoutAdapter workoutAdapter;
    private List<Workout> workoutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workouts_activity);

        recyclerView = findViewById(R.id.recycler_view);
        workoutList = generateWorkoutList(); // Generate your workout list here
        workoutAdapter = new WorkoutAdapter(workoutList, this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(workoutAdapter);
    }

    private List<Workout> generateWorkoutList() {
        // Generate and return a list of Workout objects
        List<Workout> workouts = new ArrayList<>();

        // Add your workouts to the list
        workouts.add(new Workout("5 MIN FAT BURNER", "Everyone has 5 minutes!! \uD83D\uDD25 No equipment, no excuses!", "https://www.youtube.com/watch?v=OFibSNpw2hE"));

        workouts.add(new Workout("5 MIN STANDING FLAT-BELLY", "Everyone has 5 minutes!! \uD83D\uDD25 No equipment, no excuses!", "https://www.youtube.com/watch?v=SRq7XtDW0wg"));

        workouts.add(new Workout("5 MIN DAILY ABS WORKOUT", "This is a great daily abs workout that you can include in your routine!", "https://www.youtube.com/watch?v=6UWcaE8rR68"));

        workouts.add(new Workout("DUA LIPA- DANCE NIGHT", "Dance the Night by Dua Lipa full body dance workout! Channel your inner \"Barbie\" with this fun choreographed workout! No equipment needed!", "https://www.youtube.com/watch?v=-ZVxaFxL73A"));

        workouts.add(new Workout("5 MIN DAILY STRETCH", "An everyday, full body, routine for basic flexibility!", "https://www.youtube.com/watch?v=rcpoUe9sAUk"));

        workouts.add(new Workout("8 MIN FIX ROUND SHOULDER", "EGet Slim Arms and Back. \uD83D\uDD25", "https://www.youtube.com/watch?v=rZiCR6Obkpc"));


        return workouts;
    }

    @Override
    public void onWorkoutClick(int position) {
        String videoUrl = workoutList.get(position).getVideoUrl();

        Intent intent = new Intent(WorkoutsActivity.this, VideoPlayerActivity.class);
        intent.putExtra("videoUri", videoUrl);
        startActivity(intent);
    }
}
