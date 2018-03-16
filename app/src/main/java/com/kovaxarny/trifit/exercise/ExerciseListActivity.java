package com.kovaxarny.trifit.exercise;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.adapter.ExerciseListAdapter;
import com.kovaxarny.trifit.utilities.TestUtil;
import com.kovaxarny.trifit.data.workout.ExerciseDbHelper;
import com.kovaxarny.trifit.data.workout.ExerciseOperations;

public class ExerciseListActivity extends AppCompatActivity {

    private RecyclerView exerciseListRecycleView;
    private ExerciseListAdapter exerciseListAdapter;

    private ExerciseDbHelper dbHelper = new ExerciseDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        TestUtil.insertFakeData(dbHelper.getWritableDatabase());

        ExerciseOperations exerciseOperations = new ExerciseOperations(dbHelper);
        Cursor cursor = exerciseOperations.getAllExercise();

        exerciseListRecycleView = (RecyclerView) findViewById(R.id.exercise_list_rv);
        exerciseListRecycleView.setLayoutManager(new LinearLayoutManager(this));
        exerciseListAdapter = new ExerciseListAdapter(this, cursor);
        exerciseListRecycleView.setAdapter(exerciseListAdapter);

    }
}
