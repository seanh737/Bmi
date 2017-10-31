package com.sean.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void bmi(View view){
//        System.out.println("what???");  躲在logcat多行裡
        Log.d("MainActivity","testing bmi method");
        EditText edWeight = (EditText) findViewById(R.id.ed_weight);
        EditText edHeight = (EditText) findViewById(R.id.ed_height);
//        String s = edWeight.getText().toString();  原始長相
//        float weight = Float.parseFloat(s);
        float weight = Float.parseFloat(edWeight.getText().toString());
        float height = Float.parseFloat(edHeight.getText().toString());
        float bmi = weight / (height * height);
        Log.d("MainActivity", "Your BMI : "+ bmi);
//        Toast.makeText(this, "Your BMI is"+ bmi,Toast.LENGTH_LONG).show();
        new AlertDialog.Builder(this) //顯示對話框
                .setMessage("Your BMI is "+bmi)
                .setTitle("BMI值")
                .setPositiveButton("OK",null)
                .show();






    }
}
