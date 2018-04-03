package com.kovaxarny.trifit.data.bodystats;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.github.mikephil.charting.data.Entry;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by kovax on 2018-02-13.
 */

public class BodyStatsOperations {
    private static final String TAG = "BodyStatsOperations";

    private SQLiteDatabase mDb;


    public BodyStatsOperations(BodyStatsDbHelper dbHelper) {
        this.mDb = dbHelper.getWritableDatabase();
    }

    public Cursor getAllBodyStats() {
        return mDb.query(
                BodyStatsContract.BodyStatsEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                BodyStatsContract.BodyStatsEntry.COLUMN_TIMESTAMP
        );
    }

    public long addNewBodyStat(Integer height, Double weight, String stringDate) {
        ContentValues cv = new ContentValues();

        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT, height);
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT, weight);
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_TIMESTAMP, stringDate);

        return mDb.insert(BodyStatsContract.BodyStatsEntry.TABLE_NAME, null, cv);
    }

    public long addNewBodyStat(BodyStatsModel model) {
        ContentValues cv = new ContentValues();

        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT, model.getHeight());
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT, model.getWeight());
        cv.put(BodyStatsContract.BodyStatsEntry.COLUMN_TIMESTAMP, model.getTimestamp());

        return mDb.insert(BodyStatsContract.BodyStatsEntry.TABLE_NAME, null, cv);
    }

    public void deleteData() {
        mDb.delete(BodyStatsContract.BodyStatsEntry.TABLE_NAME, null, null);
    }

    public BodyStatsModel getLatestData() {
        BodyStatsModel stats = new BodyStatsModel();

        Cursor mCursor = mDb.query(
                BodyStatsContract.BodyStatsEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                BodyStatsContract.BodyStatsEntry._ID + " DESC",
                "1"
        );

        if (mCursor.moveToFirst()) {
            do {
                stats.set_id(mCursor.getInt(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry._ID)));
                stats.setHeight(mCursor.getInt(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT)));
                stats.setWeight(mCursor.getDouble(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT)));
                stats.setTimestamp(mCursor.getString(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_TIMESTAMP)));
            } while (mCursor.moveToNext());
        }

        mCursor.close();

        return stats.get_id() != null ? stats : null;
    }

    public BodyStatsModel getFirstData() {
        BodyStatsModel stats = new BodyStatsModel();

        Cursor mCursor = mDb.query(
                BodyStatsContract.BodyStatsEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                BodyStatsContract.BodyStatsEntry._ID + " ASC",
                "1"
        );

        if (mCursor.moveToFirst()) {
            do {
                stats.set_id(mCursor.getInt(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry._ID)));
                stats.setHeight(mCursor.getInt(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT)));
                stats.setWeight(mCursor.getDouble(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT)));
                stats.setTimestamp(mCursor.getString(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_TIMESTAMP)));
            } while (mCursor.moveToNext());
        }

        mCursor.close();

        return stats.get_id() != null ? stats : null;
    }

    public ArrayList<Entry> getLastTenEntry() {
        ArrayList<Entry> entries = new ArrayList<>();

        BodyStatsModel stats = new BodyStatsModel();

        Cursor mCursor = mDb.query(
                BodyStatsContract.BodyStatsEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                BodyStatsContract.BodyStatsEntry._ID + " ASC",
                "10"
        );

        if (mCursor.moveToFirst()) {
            do {


                float convertedTimeStamp = formatDate(mCursor.getString(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_TIMESTAMP)));
                entries.add(new Entry(convertedTimeStamp,(float) mCursor.getDouble(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT))));

//                stats.set_id(mCursor.getInt(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry._ID)));
//                stats.setHeight(mCursor.getInt(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT)));
//                stats.setWeight(mCursor.getDouble(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT)));
//                stats.setTimestamp(mCursor.getString(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_TIMESTAMP)));
            } while (mCursor.moveToNext());
        }

        mCursor.close();

        return entries;
    }

    private float formatDate(String stringDate){
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        DateFormat dateFormat = new SimpleDateFormat(myFormat,Locale.US);
        Date inputDate = null;
        try {
            inputDate = dateFormat.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        float time = inputDate.getTime();
        return time;
    }
}
