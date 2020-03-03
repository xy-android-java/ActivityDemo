package com.xywei.android.java.activitydemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity {

    private static final int FIRST_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button firstButton = findViewById(R.id.button_main_first);
        Button secondButton = findViewById(R.id.button_main_second);

        //启动第一个activity
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //启动第一个activity，传递数据，给第一个，并且要收到第一个activity返回的数据
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                intent.putExtra("toFirstKey", "from main activity");
                startActivityForResult(intent, FIRST_ACTIVITY_REQUEST_CODE);
            }
        });

        //普通对话框
        Button buttonDialog = findViewById(R.id.button_main_dialog);
        buttonDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //测试生命周期onResume<->onPause
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("生命周期测试");
                builder.setMessage("onResume<->onPause");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });

        //第二个按钮，对话框activity
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }


    //第一个activity返回数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("result", "onActivityResult--requestCode=" + requestCode + " resultCode=" + resultCode);

        switch (requestCode) {

            //对话认证
            case FIRST_ACTIVITY_REQUEST_CODE:

                if (resultCode == RESULT_OK) {
                    Toast toast = Toast.makeText(MainActivity.this, "收到first activity回复" + data.getStringExtra("toMain"), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }

                break;
            default:
        }


    }
}