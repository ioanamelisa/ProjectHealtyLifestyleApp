package com.example.healthylifestyle1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {

    private List<Workout> workouts;
    private OnWorkoutClickListener onWorkoutClickListener;

    public interface OnWorkoutClickListener {
        void onWorkoutClick(int position);
    }

    public WorkoutAdapter(List<Workout> workouts, OnWorkoutClickListener onWorkoutClickListener) {
        this.workouts = workouts;
        this.onWorkoutClickListener = onWorkoutClickListener;
    }

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_item, parent, false);
        return new WorkoutViewHolder(view, onWorkoutClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder holder, int position) {
        Workout workout = workouts.get(position);
        holder.workoutName.setText(workout.getName());
        holder.workoutDescription.setText(workout.getDescription());


    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }

    class WorkoutViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView workoutName;
        TextView workoutDescription;
        OnWorkoutClickListener onWorkoutClickListener;

        public WorkoutViewHolder(@NonNull View itemView, OnWorkoutClickListener onWorkoutClickListener) {
            super(itemView);
            workoutName = itemView.findViewById(R.id.workout_title);
            workoutDescription = itemView.findViewById(R.id.workout_description);
            this.onWorkoutClickListener = onWorkoutClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onWorkoutClickListener.onWorkoutClick(getAdapterPosition());
        }
    }
}

