package com.kovaxarny.trifit.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by kovax on 2018-03-18.
 */

public class PreferenceUtil {

    private static final String IS_FIRST_RUN = "isFirstRun";

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String BIRTH_DAY = "birthDay";
    private static final String GENDER = "gender";

    public static void createBaseUserData(Context context, Intent data) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(FIRST_NAME, data.getStringExtra("firstName"))
                .putString(LAST_NAME, data.getStringExtra("lastName"))
                .putString(BIRTH_DAY, data.getStringExtra("birthDay"))
                .putString(GENDER, data.getStringExtra("gender"))
                .apply();
    }

    public static boolean isFirstRun(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(IS_FIRST_RUN, true);
    }

    public static String getFullName(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(FIRST_NAME, "firstName") + " " +
                preferences.getString(LAST_NAME, "lastName");
    }

    public static String getBirthDate(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(BIRTH_DAY, "birthDay");
    }

    public static String getGender(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(GENDER, "gender");
    }

    public static void turnOnFirstRun(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_FIRST_RUN, true)
                    .apply();
    }

    public static void turnOffFirstRun(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_FIRST_RUN, false)
                .apply();
    }

    public static void saveSwitchState(Context context,String key, boolean b) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, b)
                .apply();
    }

    public static boolean restoreSwitchState(Context context, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key,true);
    }

    public static String getFirstName(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(FIRST_NAME, "firstName");
    }

    public static String getLastName(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(LAST_NAME, "lastName");
    }
}
