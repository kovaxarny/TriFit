package com.kovaxarny.trifit.data.workout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kovaxarny.trifit.data.workout.ExerciseContract.ExerciseEntry;

/**
 * Created by kovax on 2018-03-11.
 */

public class ExerciseDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "exercises.db";
    private static final int DATABASE_VERSION = 1;

    public ExerciseDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_EXERCISES_TABLE = "CREATE TABLE " +
                ExerciseEntry.TABLE_NAME + " (" +
                ExerciseEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ExerciseEntry.COLUMN_NAME + " TEXT NOT NULL," +
                ExerciseEntry.COLUMN_TYPE + " TEXT NOT NULL," +
                ExerciseEntry.COLUMN_MUSCLE + " TEXT NOT NULL," +
                ExerciseEntry.COLUMN_DESCRIPTION + " TEXT NOT NULL," +
                ExerciseEntry.COLUMN_EQUIPMENT + " TEXT" +
                ");";
        sqLiteDatabase.execSQL(SQL_CREATE_EXERCISES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ExerciseEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
