package com.example.software.introapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
    private Button btn3;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Log.d(LOG_TAG, "onCreate().......");

        btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(new MyClickListener());
        btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new MyClickListener());
        btn3 = (Button)findViewById(R.id.button3);
        btn3.setOnClickListener(new MyClickListener());
        btn4 = (Button)findViewById(R.id.button4);
        btn4.setOnClickListener(new MyClickListener());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                Log.d("FirstActivity", "case 1");
                Log.d("FirstActivity", "resultCode"+resultCode);
                if (resultCode == RESULT_OK) {
                    Bundle bundle = data.getExtras();
                    String msg = bundle.getString("data_return");
                    Log.d("FirstActivity", msg);
                    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
                }
                break;
        }
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1:
                    Toast.makeText(IntroActivity.this, "Hi Rowling", Toast.LENGTH_LONG).show();
                    Intent intent1 = new Intent(IntroActivity.this, FirstActivity.class);
                    intent1.putExtra("name", "Luo Lin");
                    startActivityForResult(intent1, 1);
                    break;
                case R.id.button2:
                    Toast.makeText(IntroActivity.this, "Hi Rowling.......", Toast.LENGTH_LONG).show();
                    Intent intent2 = new Intent("android.intent.action.introactivity.secondactivity");
                    startActivity(intent2);
                    break;
                case R.id.button3:
                    Intent intent3 = new Intent(Intent.ACTION_VIEW);
                    intent3.setData(Uri.parse("http://www.baidu.com?CSU"));
                    startActivity(intent3);
                    break;
                case R.id.button4:
                    Intent intent4 = new Intent(Intent.ACTION_DIAL);
                    intent4.setData(Uri.parse("tel:10086"));
                    startActivity(intent4);
                    break;
            }
        }
    }
}
