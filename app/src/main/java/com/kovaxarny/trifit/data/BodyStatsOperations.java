package com.kovaxarny.trifit.data;

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

    public Cursor getAllBodyStats(){
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



}
