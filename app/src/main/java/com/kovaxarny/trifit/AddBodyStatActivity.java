package com.kovaxarny.trifit;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddBodyStatActivity extends AppCompatActivity {
    private static final String TAG = "AddBodyStatActivity";

    private EditText etAddHeight;
    private EditText etAddWeight;
    private EditText etAddDate;

    private int year_x, month_x, day_x;
    private static final int DIALOG_ID = 0;
    private final Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_body_stat);

        etAddHeight = (EditText) findViewById(R.id.et_add_height);
        etAddWeight = (EditText) findViewById(R.id.et_add_weight);

        Button addButton = (Button) findViewById(R.id.add_stats_button);

        addButton.setOnClickListener(addButtonListener);

        etAddHeight.requestFocus();

        year_x = calendar.get(Calendar.YEAR);
        month_x = calendar.get(Calendar.MONTH);
        day_x = calendar.get(Calendar.DAY_OF_MONTH);

        etAddDate = (EditText) findViewById(R.id.et_new_date);
        updateEditText();
        showDialogOnEditTextClick();
    }

    private View.OnClickListener addButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent output = new Intent();
            if (!etAddHeight.getText().toString().equals("") && !etAddWeight.getText().toString().equals("") && !etAddDate.getText().toString().equals("")) {
                output.putExtra("addHeight", Integer.parseInt(etAddHeight.getText().toString()));
                output.putExtra("addWeight", Double.parseDouble(etAddWeight.getText().toString()));
                output.putExtra("addDate", etAddDate.getText().toString());
                setResult(RESULT_OK, output);
                finish();
            } else {
                Log.d(TAG, "Add pressed");
            }
        }
    };

    private void showDialogOnEditTextClick() {
        etAddDate.setOnClickListener(new View.OnClickListener() {
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
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etAddDate.setText(sdf.format(calendar.getTime()));
    }
}
