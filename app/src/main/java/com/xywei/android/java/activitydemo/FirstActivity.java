package com.xywei.android.java.activitydemo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        Intent intent = getIntent();
        String fromMainMsg = intent.getStringExtra("toFirstKey");
        Toast.makeText(FirstActivity.this, "first activity 收到" + fromMainMsg, Toast.LENGTH_LONG).show();

        Button backMainButton = findViewById(R.id.button_first_backactivity);

        backMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent();
                backIntent.putExtra("toMain", "from firstActivity");
                setResult(RESULT_OK, backIntent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent();
        intent.putExtra("toMain", "from firstActivity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
