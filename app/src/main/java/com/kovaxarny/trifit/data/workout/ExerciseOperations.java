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

    public Cursor getExercisesByMuscleCursor(String muscle){
        String whereClause = ExerciseContract.ExerciseEntry.COLUMN_MUSCLE + " = ?";
        String[] whereArgs = new String[] {
                muscle
        };
        return mDb.query(
                ExerciseContract.ExerciseEntry.TABLE_NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
    }

    public ExerciseModel getExerciseByName(String name){
        String whereClause = ExerciseContract.ExerciseEntry.COLUMN_NAME + " = ?";
        String[] whereArgs = new String[] {
                name
        };

        ExerciseModel exerciseModel = new ExerciseModel();

        Cursor mCursor =  mDb.query(
                ExerciseContract.ExerciseEntry.TABLE_NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );

        if (mCursor.moveToFirst()) {
            do {
                exerciseModel.set_id(mCursor.getInt(mCursor.getColumnIndex(ExerciseContract.ExerciseEntry._ID)));
                exerciseModel.setName(mCursor.getString(mCursor.getColumnIndex(ExerciseContract.ExerciseEntry.COLUMN_NAME)));
                exerciseModel.setType(mCursor.getString(mCursor.getColumnIndex(ExerciseContract.ExerciseEntry.COLUMN_TYPE)));
                exerciseModel.setMuscle(mCursor.getString(mCursor.getColumnIndex(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE)));
                exerciseModel.setDescription(mCursor.getString(mCursor.getColumnIndex(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION)));
                exerciseModel.setEquipment(mCursor.getString(mCursor.getColumnIndex(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT)));
            } while (mCursor.moveToNext());
        }

        mCursor.close();

        return exerciseModel;
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
