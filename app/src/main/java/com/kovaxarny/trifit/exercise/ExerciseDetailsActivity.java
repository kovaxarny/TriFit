package com.kovaxarny.trifit.exercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.data.workout.ExerciseDbHelper;
import com.kovaxarny.trifit.data.workout.ExerciseModel;
import com.kovaxarny.trifit.data.workout.ExerciseOperations;
import com.kovaxarny.trifit.utilities.PreferenceUtil;

public class ExerciseDetailsActivity extends AppCompatActivity {

    private ExerciseDbHelper dbHelper = new ExerciseDbHelper(this);
    ExerciseOperations exerciseOperations = null;

    ExerciseModel exerciseModel = new ExerciseModel();

    EditText sets;
    EditText reps;
    EditText weight;

    TextView tvLastWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_details);

        TextView tvMuscleDesc = (TextView) findViewById(R.id.tv_muscleDesc);
        TextView tvMuscleEquipment = (TextView) findViewById(R.id.tv_muscleEquipment);

        tvLastWorkout = (TextView) findViewById(R.id.tv_lastWorkout);

        sets = (EditText) findViewById(R.id.et_setsLog);
        reps = (EditText) findViewById(R.id.et_repsLog);
        weight = (EditText) findViewById(R.id.et_weightLog);

        Button exerciseCompleteButton = (Button) findViewById(R.id.btn_exercisecomplete);

        exerciseCompleteButton.setOnClickListener(exerciseCompleteListener);


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

        tvLastWorkout.setText(PreferenceUtil.getLastPerformance(getApplicationContext(), exerciseModel.get_id().toString()));
    }

    View.OnClickListener exerciseCompleteListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (sets.length() != 0 && reps.length() != 0 && weight.length() != 0){
                int numberOfSets = Integer.parseInt(sets.getText().toString());
                int numberOfReps = Integer.parseInt(reps.getText().toString());
                int numberOfWeight = Integer.parseInt(weight.getText().toString());
                String workout = String.format("Sets: " + numberOfSets + "  Reps: " + numberOfReps + "  Weight: " + numberOfWeight + " KG.\n" +
                        "Total volume done: " + numberOfReps*numberOfSets*numberOfWeight + " KG.");
                PreferenceUtil.saveWorkoutPerformance(getApplicationContext(), exerciseModel.get_id().toString(), workout);
                tvLastWorkout.setText(workout);
                Toast.makeText(getApplicationContext(),"Performance Saved!", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
