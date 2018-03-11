package com.kovaxarny.trifit.data.bodystats;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.kovaxarny.trifit.data.workout.ExerciseContract;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static void insertFakeData(SQLiteDatabase db) {
        if (db == null) {
            return;
        }
        //create a list of fake data
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Push Up");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Chest");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "Description");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Pull Up");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Back");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "Description");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        cv = new ContentValues();
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_NAME, "Sit Up");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_TYPE, "Calisthenics");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_MUSCLE, "Abs");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_DESCRIPTION, "Description");
        cv.put(ExerciseContract.ExerciseEntry.COLUMN_EQUIPMENT, "None");
        list.add(cv);

        //insert all data in one transaction
        try {
            db.beginTransaction();
            //clear the table first
            db.delete(ExerciseContract.ExerciseEntry.TABLE_NAME, null, null);
            //go through the list and add one by one
            for (ContentValues c : list) {
                db.insert(ExerciseContract.ExerciseEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            //too bad :(
        } finally {
            db.endTransaction();
        }

    }
}