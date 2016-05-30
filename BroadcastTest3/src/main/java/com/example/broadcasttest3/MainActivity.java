package com.example.broadcasttest3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
安卓发出的广播可以分为四种：
Standard broadcast
System broadcast
Ordered broadcast
Local broadcast

静态注册的广播，app不启动不一定可以收到广播，原因是所有的广播默认添加了Intent.FLAG_EXCLUDE_STOPPED_PACKAGES
FLAG_INCLUDE_STOPPED_PACKAGES：包含已经停止的包（停止：即包所在的进程已经退出）
FLAG_EXCLUDE_STOPPED_PACKAGES：不包含已经停止的包

除了满足FLAG的条件，还要查看手机是否有其它 安全类的程序阻止 后台启动
 */


public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private LocalBroadcastManager mLocalBroadcastManager;
    private LocalBroadcastReceiver mLocalBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter("android.intent.action.localbroadcast");
        mLocalBroadcastReceiver = new LocalBroadcastReceiver();

        mLocalBroadcastManager.registerReceiver(mLocalBroadcastReceiver, intentFilter);

        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mLocalBroadcastManager.sendBroadcast(new Intent("android.intent.action.localbroadcast"));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalBroadcastManager.unregisterReceiver(mLocalBroadcastReceiver);
    }

    class LocalBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(MainActivity.this, "Hi rowling", Toast.LENGTH_SHORT).show();
        }
    }
}
