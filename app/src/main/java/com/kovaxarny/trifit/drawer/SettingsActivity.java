package com.kovaxarny.trifit.drawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.notifications.ReminderUtilities;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button testNotificationButton = (Button) findViewById(R.id.button_Test_Notification);
        Button cancelNotificationButton = (Button) findViewById(R.id.cancel_Test_Notification);

        testNotificationButton.setOnClickListener(testNotificationListener);
        cancelNotificationButton.setOnClickListener(cancelTestNotificationListener);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    View.OnClickListener testNotificationListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ReminderUtilities.scheduleChargingReminder(getApplicationContext());
        }
    };

    View.OnClickListener cancelTestNotificationListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ReminderUtilities.cancelWorkoutReminder(getApplicationContext());
        }
    };

}
