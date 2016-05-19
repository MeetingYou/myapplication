package com.example.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver mMyBroadcastReceiver;
    IntentFilter mIntentFilter;
    private Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mMyBroadcastReceiver = new MyBroadcastReceiver();
        registerReceiver(mMyBroadcastReceiver, mIntentFilter);

        mSendButton = (Button)findViewById(R.id.send_button);
        mSendButton.setOnClickListener(new MyClickListener());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMyBroadcastReceiver);
    }

    private class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null && networkInfo.isAvailable())
                Toast.makeText(MainActivity.this, "network status available", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "network status not available", Toast.LENGTH_SHORT).show();
        }
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.send_button:
                    Intent intent = new Intent("android.intent.action.MY_BROADCAST");
                    MainActivity.this.sendBroadcast(intent);
                    break;
            }
        }
    }
}
