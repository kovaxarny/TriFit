package com.kovaxarny.trifit.data;

import android.provider.BaseColumns;

/**
 * Created by kovax on 2018-02-11.
 */

public class BodyStatsContract {

    public static final class BodyStatsEntry implements BaseColumns {
        public static final String TABLE_NAME = "bodystats";
        public static final String COLUMN_HEIGHT = "height";
        public static final String COLUMN_WEIGHT = "weight";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
