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

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    private int year_x,month_x,day_x;
    static final int DIALOG_ID = 0;
    private final Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_start);

        year_x = calendar.get(Calendar.YEAR);
        month_x = calendar.get(Calendar.MONTH);
        day_x = calendar.get(Calendar.DAY_OF_MONTH);
        birthDay = (EditText) findViewById(R.id.et_birth_date);
        updateEditText();
        showDialogOnEditTextClick();

        gender = (Spinner) findViewById(R.id.spinner_gender);
        String[] genders = {"Male","Female"};
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,genders);
        gender.setAdapter(adapter);

        submitButton = (Button) findViewById(R.id.btn_submit);

        firstName = (EditText) findViewById(R.id.et_first_name);
        lastName = (EditText) findViewById(R.id.et_last_name);
        height = (EditText) findViewById(R.id.et_height);
        weight = (EditText) findViewById(R.id.et_weight);

        onSubmit();
    }

    private void onSubmit(){
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent output = new Intent();
                if (firstName.length()!= 0 && lastName.length()!= 0 && birthDay.length()!= 0 && weight.length()!= 0 && height.length()!= 0){
                    getSharedPreferences("com.kovaxarny.trifit.Preferences", MODE_PRIVATE)
                            .edit()
                            .putBoolean("isFirstRun", false)
                            .apply();
                    output.putExtra("firstName", firstName.getText().toString());
                    output.putExtra("lastName", lastName.getText().toString());
                    output.putExtra("birthDay", birthDay.getText().toString());
                    output.putExtra("gender", gender.getSelectedItem().toString());
                    output.putExtra("height", height.getText().toString());
                    output.putExtra("weight", weight.getText().toString());
                    setResult(RESULT_OK, output);
                    finish();
                }else{
                    Log.d(TAG, "Submit pressed");
                }
            }
        });
    }

    private void showDialogOnEditTextClick(){
        birthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, datePickerListener, year_x ,month_x ,day_x);
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

    private void updateEditText(){
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        birthDay.setText(sdf.format(calendar.getTime()));
    }
}
