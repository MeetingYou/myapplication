package com.example.software.introapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Anonymous on 2016/5/2.
 */
public class FirstActivity extends Activity{
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        textView = (TextView)findViewById(R.id.textView);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        textView.setText(name);

        Intent intent2 = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("data_return", "Luo mumu");
        intent2.putExtras(bundle);
        setResult(RESULT_OK, intent2);
    }

}
