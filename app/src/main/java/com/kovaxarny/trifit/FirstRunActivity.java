package com.kovaxarny.trifit;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FirstRunActivity extends AppCompatActivity {

    private EditText editTextBirthDay;
    private Spinner spinner;

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
        showDialogOnEditTextClick();

        spinner = (Spinner) findViewById(R.id.spinner_gender);
        String[] genders = {"Male","Female"};
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,genders);
        spinner.setAdapter(adapter);
    }

    public void showDialogOnEditTextClick(){
        editTextBirthDay = (EditText) findViewById(R.id.et_birth_date);
        editTextBirthDay.setOnClickListener(new View.OnClickListener() {
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
        String myFormat = "yyyy/MM/dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        editTextBirthDay.setText(sdf.format(calendar.getTime()));
    }
}
