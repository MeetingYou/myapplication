package com.orange.broadcastbestpractise;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;


/**
 * Created by 80119667 on 2016-05-28.
 */
public class BaseActivity extends Activity{
    private String LOG_TAG = "BaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityController.addActivity(this);
        Log.d(LOG_TAG, "onCreate()...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityController.removeActivity(this);
        Log.d(LOG_TAG, "onDestroy");
    }
}
