package com.kovaxarny.trifit.drawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.adapter.WorkoutProgramsAdapter;
import com.kovaxarny.trifit.data.workout.WorkoutModel;
import com.kovaxarny.trifit.data.workout.WorkoutStyleModel;

import java.util.ArrayList;

public class WorkoutProgramsActivity extends AppCompatActivity {
    private static final String TAG = "WorkoutProgramsActivity";


    String[] titles = {"Cardio", "Gym WorkoutModel", "Calisthenics"};
    int[] images = {R.drawable.workout_running,R.drawable.workout_gym,R.drawable.workout_calisthenics};

    RecyclerView workoutProgramsRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_programs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d(TAG, "onCreate: called");
        workoutProgramsRecycleView = (RecyclerView) findViewById(R.id.workout_programs_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false);
        workoutProgramsRecycleView.setLayoutManager(linearLayoutManager);
        WorkoutProgramsAdapter workoutProgramsAdapter = new WorkoutProgramsAdapter(this,getWorkoutStylesToPass());
        workoutProgramsRecycleView.setAdapter(workoutProgramsAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private ArrayList<WorkoutStyleModel> getWorkoutStylesToPass(){
        ArrayList<WorkoutStyleModel> workoutStyleModelArrayList = new ArrayList<>();
        ArrayList<WorkoutModel> workoutModelArrayList;
        WorkoutStyleModel workoutStyleModel;
        WorkoutModel workoutModel;

        //CARDIO
        workoutStyleModel = new WorkoutStyleModel();
        workoutStyleModel.setStyleName("Cardio");
        workoutStyleModel.setStyleImage(R.drawable.workout_running);
        workoutModelArrayList = new ArrayList<>();
        //1st child
        workoutModel = new WorkoutModel();
        workoutModel.setWorkoutName("Walking");
        workoutModelArrayList.add(workoutModel);
        //2nd child
        workoutModel = new WorkoutModel();
        workoutModel.setWorkoutName("Running");
        workoutModelArrayList.add(workoutModel);
        //3rd child
        workoutModel = new WorkoutModel();
        workoutModel.setWorkoutName("Bicycle");
        workoutModelArrayList.add(workoutModel);
        //add childs to parent
        workoutStyleModel.setWorkoutModelItems(workoutModelArrayList);
        workoutStyleModelArrayList.add(workoutStyleModel);
        //GYM
        workoutStyleModel = new WorkoutStyleModel();
        workoutStyleModel.setStyleName("Gym Workout");
        workoutStyleModel.setStyleImage(R.drawable.workout_gym);
        workoutModelArrayList = new ArrayList<>();
        //1st child
        workoutModel = new WorkoutModel();
        workoutModel.setWorkoutName("Chest");
        workoutModelArrayList.add(workoutModel);
        //add childs to parent
        workoutStyleModel.setWorkoutModelItems(workoutModelArrayList);
        workoutStyleModelArrayList.add(workoutStyleModel);
        //CALISTHENICS
        workoutStyleModel = new WorkoutStyleModel();
        workoutStyleModel.setStyleName("Calisthenics");
        workoutStyleModel.setStyleImage(R.drawable.workout_calisthenics);
        workoutModelArrayList = new ArrayList<>();
        //add childs to parent
        workoutStyleModel.setWorkoutModelItems(workoutModelArrayList);
        workoutStyleModelArrayList.add(workoutStyleModel);


        return workoutStyleModelArrayList;
    }
}
