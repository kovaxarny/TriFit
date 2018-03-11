package com.kovaxarny.trifit.data.bodystats;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.kovaxarny.trifit.data.bodystats.BodyStatsContract.BodyStatsEntry;

/**
 * Created by kovax on 2018-02-11.
 */

public class BodyStatsDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "basestats.db";
    private static final int DATABASE_VERSION = 1;

    public BodyStatsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_BODYSTATS_TABLE = "CREATE TABLE " +
                BodyStatsEntry.TABLE_NAME + " (" +
                BodyStatsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BodyStatsEntry.COLUMN_HEIGHT + " INTEGER NOT NULL," +
                BodyStatsEntry.COLUMN_WEIGHT + " REAL NOT NULL," +
                BodyStatsEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";
        sqLiteDatabase.execSQL(SQL_CREATE_BODYSTATS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BodyStatsEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
