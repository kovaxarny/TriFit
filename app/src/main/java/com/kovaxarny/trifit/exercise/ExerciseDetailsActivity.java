package com.kovaxarny.trifit.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.data.workout.ExerciseDbHelper;
import com.kovaxarny.trifit.data.workout.ExerciseModel;
import com.kovaxarny.trifit.data.workout.ExerciseOperations;

public class ExerciseDetailsActivity extends AppCompatActivity {

    private ExerciseDbHelper dbHelper = new ExerciseDbHelper(this);
    ExerciseOperations exerciseOperations = null;

    ExerciseModel exerciseModel = new ExerciseModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        TextView tvMuscleDesc = (TextView) findViewById(R.id.tv_muscleDesc);
        TextView tvMuscleEquipment = (TextView) findViewById(R.id.tv_muscleEquipment);


        String exerciseName = null;
        Intent callerIntent = getIntent();
        if (callerIntent.hasExtra("name")) {
            exerciseName = callerIntent.getStringExtra("name");
        }

        exerciseOperations = new ExerciseOperations(dbHelper);
        exerciseModel = exerciseOperations.getExerciseByName(exerciseName);

        setTitle(exerciseModel.getName());

        tvMuscleDesc.setText(exerciseModel.getDescription());
        tvMuscleEquipment.setText(exerciseModel.getEquipment());

    }
}
