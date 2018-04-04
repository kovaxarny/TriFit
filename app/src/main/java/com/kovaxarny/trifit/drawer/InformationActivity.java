package com.kovaxarny.trifit.drawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.kovaxarny.trifit.R;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        ImageButton bmiWebsiteButton = (ImageButton) findViewById(R.id.ibtn_bmiWebsite);
        bmiWebsiteButton.setOnClickListener(bmiWebsiteButtonListener);

        ImageButton bmrWebsiteButton = (ImageButton) findViewById(R.id.ibtn_bmrWebsite);
        bmrWebsiteButton.setOnClickListener(bmrWebsiteButtonListener);

        ImageButton physicalActivityWebsiteButton = (ImageButton) findViewById(R.id.ibtn_phisicalWebsite);
        physicalActivityWebsiteButton.setOnClickListener(physicalActivityWebsiteButtonListener);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    View.OnClickListener bmiWebsiteButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.livestrong.com/article/421339-bmi-calculator-for-bodybuilders/"));
            browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(browserIntent);
        }
    };

    View.OnClickListener bmrWebsiteButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bodybuilding.com/fun/bmr_calculator.htm"));
            browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(browserIntent);
        }
    };
    View.OnClickListener physicalActivityWebsiteButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.who.int/dietphysicalactivity/factsheet_adults/en/"));
            browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(browserIntent);
        }
    };


}
