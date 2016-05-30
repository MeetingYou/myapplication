package com.orange.broadcastbestpractise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    private Button mOfflineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOfflineButton = (Button)findViewById(R.id.force_offline_button);
        mOfflineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.action.intent.FORCE_OFFLINE_BROADCAST");
                sendBroadcast(intent);
            }
        });
    }
}
