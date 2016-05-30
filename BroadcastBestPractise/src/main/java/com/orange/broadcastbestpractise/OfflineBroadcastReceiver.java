package com.orange.broadcastbestpractise;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * Created by 80119667 on 2016-05-30.
 */
public class OfflineBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        if ("android.action.intent.FORCE_OFFLINE_BROADCAST".equals(intent.getAction())) {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
            dialogBuilder.setTitle("Warning");
            dialogBuilder.setMessage("You are forced to be offline");
            dialogBuilder.setCancelable(false);
            dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityController.finishAllActivity();
                    Intent loginIntent = new Intent(context, LoginActivity.class);
                    loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(loginIntent);
                }
            });
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            alertDialog.show();
        }
    }
}
