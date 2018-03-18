package com.kovaxarny.trifit.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by kovax on 2018-03-18.
 */

public class PreferenceUtil {

    public static void createBaseUserData(Context context, Intent data) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("firstName", data.getStringExtra("firstName"))
                .putString("lastName", data.getStringExtra("lastName"))
                .putString("birthDay", data.getStringExtra("birthDay"))
                .putString("gender", data.getStringExtra("gender"))
                .apply();
    }

    public static boolean isFirstRun(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean("isFirstRun", true);
    }

    public static String getFullName(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("firstName", "firstName") + " " + preferences.getString("lastName", "lastName");
    }

    public static String getBirthDate(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("birthDay", "birthDay");
    }

    public static String getGender(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("gender", "gender");
    }

    public static void turnOnFirstRun(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isFirstRun", true)
                    .apply();
    }

    public static void turnOffFirstRun(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isFirstRun", false)
                .apply();
    }
}
