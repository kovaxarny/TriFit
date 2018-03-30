package com.kovaxarny.trifit.drawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.data.bodystats.BodyStatsDbHelper;
import com.kovaxarny.trifit.data.bodystats.BodyStatsModel;
import com.kovaxarny.trifit.data.bodystats.BodyStatsOperations;
import com.kovaxarny.trifit.statistics.BodyIndex;
import com.kovaxarny.trifit.utilities.PreferenceUtil;

import java.util.Locale;

public class ProfileActivity extends AppCompatActivity {

    BodyStatsDbHelper dbHelper = new BodyStatsDbHelper(this);
    BodyStatsOperations bodyStatsOperations = null;

    TextView tvFirstName;
    TextView tvLastName;
    TextView tvBirthDate;
    TextView tvGender;

    TextView tvThenWeight;
    TextView tvThenBMI;
    TextView tvThenBMR;

    TextView tvNowWeight;
    TextView tvNowBMI;
    TextView tvNowBMR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bodyStatsOperations = new BodyStatsOperations(dbHelper);

        getTextViewReferences();

        fillUpTextViews();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void fillUpTextViews() {
        tvFirstName.setText(PreferenceUtil.getFirstName(getApplicationContext()));
        tvLastName.setText(PreferenceUtil.getLastName(getApplicationContext()));
        tvBirthDate.setText(PreferenceUtil.getBirthDate(getApplicationContext()));
        tvGender.setText(PreferenceUtil.getGender(getApplicationContext()));

        calculateProgress();
    }

    private void calculateProgress() {
        BodyIndex bodyIndex = new BodyIndex();


        BodyStatsModel model = bodyStatsOperations.getLatestData();
        if (model != null) {
            tvNowBMI.setText(String.format(Locale.US, "%.2f",
                    bodyIndex.calculateBodyMassIndex(
                            model.getHeight(),
                            model.getWeight()
                    )));
            tvNowBMR.setText(String.format(Locale.US, "%d",
                    bodyIndex.calculateBasalMetabolicRate(
                            model.getHeight(),
                            model.getWeight(),
                            PreferenceUtil.getGender(this),
                            PreferenceUtil.getBirthDate(this)
                    )));
            tvNowWeight.setText(String.format(Locale.US, "%.2f",model.getWeight()));
        }

        model = bodyStatsOperations.getFirstData();
        if (model != null) {
            tvThenBMI.setText(String.format(Locale.US, "%.2f",
                    bodyIndex.calculateBodyMassIndex(
                            model.getHeight(),
                            model.getWeight()
                    )));
            tvThenBMR.setText(String.format(Locale.US, "%d",
                    bodyIndex.calculateBasalMetabolicRate(
                            model.getHeight(),
                            model.getWeight(),
                            PreferenceUtil.getGender(this),
                            PreferenceUtil.getBirthDate(this)
                    )));
            tvThenWeight.setText(String.format(Locale.US, "%.2f",model.getWeight()));
        }
    }

    private void getTextViewReferences() {
        tvFirstName = (TextView) findViewById(R.id.tv_firstName);
        tvLastName = (TextView) findViewById(R.id.tv_lastName);
        tvBirthDate = (TextView) findViewById(R.id.tv_birthDate);
        tvGender = (TextView) findViewById(R.id.tv_gender);

        tvThenWeight = (TextView) findViewById(R.id.tv_then_weight);
        tvThenBMI = (TextView) findViewById(R.id.tv_then_BMI);
        tvThenBMR = (TextView) findViewById(R.id.tv_then_BMR);

        tvNowWeight = (TextView) findViewById(R.id.tv_now_weight);
        tvNowBMI = (TextView) findViewById(R.id.tv_now_BMI);
        tvNowBMR = (TextView) findViewById(R.id.tv_now_BMR);
    }

}
