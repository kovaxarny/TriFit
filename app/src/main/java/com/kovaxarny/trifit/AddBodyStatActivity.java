package com.kovaxarny.trifit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddBodyStatActivity extends AppCompatActivity {
    private static final String TAG = "AddBodyStatActivity";

    private EditText etAddHeight;
    private EditText etAddWeight;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_body_stat);

        etAddHeight = (EditText) findViewById(R.id.et_add_height);
        etAddWeight = (EditText) findViewById(R.id.et_add_weight);

        addButton = (Button) findViewById(R.id.add_stats_button);

        addButton.setOnClickListener(addButtonListener);

        etAddHeight.requestFocus();
    }

    View.OnClickListener addButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent output = new Intent();
            if (!etAddHeight.getText().toString().equals("") && !etAddWeight.getText().toString().equals("")){
                output.putExtra("addWeight", etAddHeight.getText().toString());
                output.putExtra("addHeight", etAddWeight.getText().toString());
                setResult(RESULT_OK, output);
                finish();
            }else{
                Log.d(TAG, "Add pressed");
            }
        }
    };
}
