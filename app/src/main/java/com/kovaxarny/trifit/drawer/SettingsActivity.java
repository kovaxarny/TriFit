package com.kovaxarny.trifit.drawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.utilities.NotificationUtil;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView mDisplayText = (TextView) findViewById(R.id.tv_settings_activity);

        Intent callerIntent = getIntent();

        if (callerIntent.hasExtra("Text")) {
            mDisplayText.setText(callerIntent.getStringExtra("Text"));
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void testNotification(View view) {
        NotificationUtil.remindUserToWorkout(this);
    }
}
