package com.kovaxarny.trifit.data.workout;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kovax on 2018-03-11.
 */

public class ExerciseOperations {
    private static final String TAG = "ExerciseOperations";

    private SQLiteDatabase mDb;

    public ExerciseOperations(ExerciseDbHelper dbHelper){
        this.mDb = dbHelper.getWritableDatabase();
    }

    public Cursor getAllExercise() {
        return mDb.query(
                ExerciseContract.ExerciseEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
