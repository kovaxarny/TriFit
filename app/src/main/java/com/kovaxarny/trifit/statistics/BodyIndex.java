package com.kovaxarny.trifit.statistics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by kovax on 2018-02-19.
 */

public class BodyIndex {

    public BodyIndex() {
    }

    public Double calculateBodyMassIndex(int height, double weight) {
        Double mBMI;
        mBMI = weight / ((height / 100.0) * (height / 100.0));
        return mBMI;
    }

    public Integer calculateBasalMetabolicRate(int height, double weight, String gender, String date) {
        Integer mBMR;
        Double bmr;
        int age = calculateAge(date);
        if (gender.equals("Male")) {
            //For men:	BMR = 10 × weight(kg) + 6.25 × height(cm) - 5 × age(y) + 5
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            //For women:  BMR = 10 × weight(kg) + 6.25 × height(cm) - 5 × age(y) - 161
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        }
        mBMR = bmr.intValue();
        return mBMR;
    }

    private static int calculateAge(String stringBirthDate) {
        Calendar today = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();

        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        try {
            birthDate.setTime(sdf.parse(stringBirthDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < birthDate.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }
}
