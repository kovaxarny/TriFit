package com.kovaxarny.trifit.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

    public static void insertFakeData(SQLiteDatabase db){
        if(db == null){
            return;
        }
        //create a list of fake data
        List<ContentValues> list = new ArrayList<ContentValues>();

        ContentValues cv = new ContentValues();
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT, 170);
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT, 75);
        list.add(cv);

        cv = new ContentValues();
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT, 170);
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT, 74);
        list.add(cv);

        cv = new ContentValues();
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT, 170);
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT, 73.5);
        list.add(cv);

        cv = new ContentValues();
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT, 170);
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT, 72);
        list.add(cv);

        cv = new ContentValues();
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT, 171);
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT, 71.0);
        list.add(cv);

        //insert all data in one transaction
        try
        {
            db.beginTransaction();
            //clear the table first
            db.delete (BodyStatsContract.BodyStatsEntry.TABLE_NAME,null,null);
            //go through the list and add one by one
            for(ContentValues c:list){
                db.insert(BodyStatsContract.BodyStatsEntry.TABLE_NAME, null, c);
            }
            db.setTransactionSuccessful();
        }
        catch (SQLException e) {
            //too bad :(
        }
        finally
        {
            db.endTransaction();
        }

    }
}