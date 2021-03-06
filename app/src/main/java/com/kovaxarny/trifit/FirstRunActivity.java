package com.kovaxarny.trifit;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.kovaxarny.trifit.data.workout.ExerciseDbHelper;
import com.kovaxarny.trifit.utilities.PreferenceUtil;
import com.kovaxarny.trifit.utilities.PrePopulateDBUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FirstRunActivity extends AppCompatActivity {

    private static final String TAG = "FirstRunActivity";

    private EditText firstName;
    private EditText lastName;
    private EditText birthDay;
    private Spinner gender;
    private EditText height;
    private EditText weight;

    private Button submitButton;

    private int year_x, month_x, day_x;
    private static final int DIALOG_ID = 0;
    private final Calendar calendar = Calendar.getInstance();

    private ExerciseDbHelper dbHelper = new ExerciseDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_start);

        PrePopulateDBUtil.insertExerciseData(dbHelper.getWritableDatabase());

        year_x = calendar.get(Calendar.YEAR);
        month_x = calendar.get(Calendar.MONTH);
        day_x = calendar.get(Calendar.DAY_OF_MONTH);

        //TODO setting date to my birthday for faster manual testing
        calendar.set(1996, 11, 4);

        birthDay = (EditText) findViewById(R.id.et_birth_date);
        updateEditText();
        showDialogOnEditTextClick();

        gender = (Spinner) findViewById(R.id.spinner_gender);
        String[] genders = {"Male", "Female"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, genders);
        gender.setAdapter(adapter);

        submitButton = (Button) findViewById(R.id.btn_submit);

        firstName = (EditText) findViewById(R.id.et_first_name);
        lastName = (EditText) findViewById(R.id.et_last_name);
        height = (EditText) findViewById(R.id.et_height);
        weight = (EditText) findViewById(R.id.et_weightLog);

        setSwitchesToFalse();


        onSubmit();
    }

    private void setSwitchesToFalse() {
        PreferenceUtil.saveSwitchState(getBaseContext(),"workout_switch",false);
        PreferenceUtil.saveSwitchState(getBaseContext(),"logging_switch",false);
    }

    private void onSubmit() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent output = new Intent();
                if (firstName.length() != 0 && lastName.length() != 0 && birthDay.length() != 0 && weight.length() != 0 && height.length() != 0) {
                    PreferenceUtil.turnOffFirstRun(getBaseContext());
                    output.putExtra("firstName", firstName.getText().toString());
                    output.putExtra("lastName", lastName.getText().toString());
                    output.putExtra("birthDay", birthDay.getText().toString());
                    output.putExtra("gender", gender.getSelectedItem().toString());
                    output.putExtra("height", Integer.parseInt(height.getText().toString()));
                    output.putExtra("weight", Double.parseDouble(weight.getText().toString()));
                    output.putExtra("date", formatDate(Calendar.getInstance().getTime()));
                    setResult(RESULT_OK, output);
                    finish();
                } else {
                    Log.d(TAG, "Submit pressed");
                }
            }
        });
    }

    private void showDialogOnEditTextClick() {
        birthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, datePickerListener, year_x, month_x, day_x);
        else
            return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateEditText();
        }
    };

    private void updateEditText() {
        birthDay.setText(formatDate(calendar.getTime()));
    }

    private String formatDate(Date date) {
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        return sdf.format(date);
    }
}
