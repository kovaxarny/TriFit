package com.kovaxarny.trifit.drawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.kovaxarny.trifit.R;
import com.kovaxarny.trifit.data.bodystats.BodyStatsDbHelper;
import com.kovaxarny.trifit.data.bodystats.BodyStatsOperations;
import com.kovaxarny.trifit.notifications.ReminderUtilities;
import com.kovaxarny.trifit.utilities.PreferenceUtil;

public class SettingsActivity extends AppCompatActivity {

    BodyStatsDbHelper dbHelper = new BodyStatsDbHelper(this);
    BodyStatsOperations bodyStatsOperations = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Switch dailyWorkoutSwitch = (Switch) findViewById(R.id.switch_workout_reminder);
        dailyWorkoutSwitch.setChecked(PreferenceUtil.restoreSwitchState(getBaseContext(),"workout_switch"));

        Switch weeklyLoggingSwitch = (Switch) findViewById(R.id.switch_logging_reminder);
        weeklyLoggingSwitch.setChecked(PreferenceUtil.restoreSwitchState(getBaseContext(),"logging_switch"));

        Button deleteDataButton = (Button) findViewById(R.id.bt_delete_all_data);
        deleteDataButton.setOnClickListener(deleteDataButtonListener);

        bodyStatsOperations = new BodyStatsOperations(dbHelper);

        dailyWorkoutSwitch.setOnCheckedChangeListener(workoutSwitchCheckedChangeListener);
        weeklyLoggingSwitch.setOnCheckedChangeListener(loggingSwitchCheckedChangeListener);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    View.OnClickListener deleteDataButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            PreferenceUtil.turnOnFirstRun(getApplicationContext());
            bodyStatsOperations.deleteData();
        }
    };

    Switch.OnCheckedChangeListener workoutSwitchCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b){
                ReminderUtilities.scheduleWorkoutReminder(getApplicationContext());
            }else{
                ReminderUtilities.cancelWorkoutReminder(getApplicationContext());
            }
            PreferenceUtil.saveSwitchState(getBaseContext(),"workout_switch",b);
        }
    };

    Switch.OnCheckedChangeListener loggingSwitchCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b){
                ReminderUtilities.scheduleLoggingReminder(getApplicationContext());
            }else{
                ReminderUtilities.cancelLoggingReminder(getApplicationContext());
            }
            PreferenceUtil.saveSwitchState(getBaseContext(),"logging_switch",b);
        }
    };
}
