package com.kovaxarny.trifit.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
                stats.setHeight(mCursor.getInt(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_HEIGHT)));
                stats.setWeight(mCursor.getDouble(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_WEIGHT)));
                stats.setTimestamp(mCursor.getString(mCursor.getColumnIndex(BodyStatsContract.BodyStatsEntry.COLUMN_TIMESTAMP)));
            } while (mCursor.moveToNext());
        }

        return stats;
    }


}
