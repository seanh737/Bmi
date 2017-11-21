package com.sean.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        float bmi = getIntent().getFloatExtra("Extra_bmi", 0);
        TextView result = (TextView) findViewById(R.id.result_bmi);
        result.setText("您的BMI值 : "+bmi);
    }
}
