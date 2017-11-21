package com.sean.bmi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s = new String("abc");
    private EditText edHeight;
    private EditText edWeight;
    private Button bHelp;


//    View.OnClickListener listener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
        //        getResources().getString(R.string.app_name); 運用Alt+Enter 讓字串自動輸入
        bHelp.setOnClickListener(new View.OnClickListener(){  //匿名類別  箭頭用於簡化
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("說明")
                        .setMessage("BMI原來的設計是一個用於公眾健康研究的統計工具。當需要知道肥胖是否為某一疾病的致病原因時，可以把病人的身高及體重換算成BMI，再找出其數值及病發率是否有線性關連。由於BMI主要反應整體體重，無法區別體重中體脂肪組織與非脂肪組織（包括肌肉、器官），同樣身高體重的人可算出相同的BMI，但其實脂肪量不同，因此其實BMI是整體營養狀態的指標。以往拿來做為肥胖的指標，是因發現BMI與體脂肪在統計上有高度相關；但在同樣BMI之下，仍會有體脂肪率的差異。")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

    }
    @Override    //Activity 生命週期
    protected void onStart() {
        super.onStart();
        Log.d("Mainactivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Mainactivity", "onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Mainactivity", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Mainactivity", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Mainactivity", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Mainactivity", "onRestart");
    }

    private void findviews() {   //Ctrl+Alt+M  自動變為方法
        edHeight = (EditText) findViewById(R.id.ed_height);  //Ctrl+Alt+F 提升為屬性
        edWeight = (EditText) findViewById(R.id.ed_weight);
        bHelp = (Button) findViewById(R.id.b_help);
    }

    public void bmi(View view){
        //        System.out.println("what???");  躲在logcat多行裡
        Log.d("MainActivity","testing bmi method");

        //        String s = edWeight.getText().toString();  原始長相
        //        float weight = Float.parseFloat(s);
        float height = Float.parseFloat(edHeight.getText().toString());
        float weight = Float.parseFloat(edWeight.getText().toString());
        if(height>3){
            new AlertDialog.Builder(this)
                    .setMessage(R.string.height_check)
                    .setTitle(R.string.Warn)
                    .setPositiveButton(R.string.ok,null)
                    .show();
        }
         if(height<3) {
              float bmi = weight / (height * height);
             Log.d("MainActivity", "Your BMI : " + bmi);
             //Toast.makeText(this, "Your BMI is"+ bmi,Toast.LENGTH_LONG).show();

             Intent intent = new Intent(this,ResultActivity.class);   //用Intent轉換Activity 11/21
             intent.putExtra(getString(R.string.extra_bmi), bmi);
             startActivity(intent);

    if (bmi < 20) {
        new AlertDialog.Builder(this) //顯示對話框
                .setMessage(getString(R.string.your_bmi_is) + bmi + getString(R.string.eat_more))
                .setTitle(R.string.bmi_title)
                .setPositiveButton(R.string.ok, null)
                .show();
    } else {
        new AlertDialog.Builder(this) //顯示對話框
                .setMessage(getString(R.string.your_bmi_is) + bmi)
                .setTitle(R.string.bmi_title)
                .setPositiveButton(R.string.ok, null)
                .show();
    }


}



    }
}
