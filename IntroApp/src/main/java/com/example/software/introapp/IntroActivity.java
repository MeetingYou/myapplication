package com.example.software.introapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntroActivity extends Activity {
    private final String LOG_TAG = "IntroActivity";

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Log.d(LOG_TAG, "onCreate().......");

        btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new MyClickListener());
        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new MyClickListener());
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    Toast.makeText(IntroActivity.this, "Hi Rowling", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(IntroActivity.this, FirstActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.button2:
                    Toast.makeText(IntroActivity.this, "Hi Rowling.......", Toast.LENGTH_LONG).show();
                    Intent intent2 = new Intent("android.intent.action.introactivity.secondactivity");
                    startActivity(intent2);
                    break;
            }
        }
    }
}