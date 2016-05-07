package com.example.uicustom;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by 80119667 on 2016-05-07.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());

        Util.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Util.removeActivity(this);
    }
}
