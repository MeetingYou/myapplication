package com.example.uicustom;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by 80119667 on 2016-05-07.
 */
public class MyTitle extends LinearLayout {
    public MyTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);
        Button titleBack = (Button)findViewById(R.id.button_left);
        Button titleNext = (Button)findViewById(R.id.button_right);
        titleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        titleNext.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Next", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
