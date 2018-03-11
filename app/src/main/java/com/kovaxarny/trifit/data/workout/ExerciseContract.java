package com.kovaxarny.trifit.data.workout;

import android.provider.BaseColumns;

/**
 * Created by kovax on 2018-03-11.
 */

public class ExerciseContract {

    public static final class ExerciseEntry implements BaseColumns{
        public static final String TABLE_NAME = "exercises";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_MUSCLE = "muscle";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_EQUIPMENT = "equipment";
    }
}
