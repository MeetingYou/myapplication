package com.example.braodcasttest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by software on 2016/5/23.
 */
public class BroadcastTestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BroadcastTestReceiver", "onReceive");
        if ("android.intent.action.MY_BROADCAST".equals(intent.getAction())) {
            Intent intent1 = new Intent(context, MainActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
            abortBroadcast();
        }
    }
}
