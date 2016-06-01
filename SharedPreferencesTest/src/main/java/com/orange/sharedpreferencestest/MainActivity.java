package com.orange.sharedpreferencestest;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button mSaveButton;
    private Button mRestoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSaveButton = (Button)findViewById(R.id.save_button);
        mRestoreButton = (Button)findViewById(R.id.restore_button);

        mSaveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //1.获取SharedPreferences对象，有三种方法
                //      Context.getSharedPreferences(String name, int mode)
                //      Activity.getPreferences(int mode),内部会调用Context类的方法，name参数为包名
                //      PreferenceManager.getDefaultSharedPreferences(Context)
                //2.通过SharedPreferences对象的edit()方法获取SharedPreferences.Editor对象
                SharedPreferences.Editor editor = getSharedPreferences("age", MODE_PRIVATE).edit();

                //3.通过SharedPreferences.Editor对象添加数据
                editor.putInt("ZhangSan", 22);
                editor.putInt("LiSi", 21);
                editor.putInt("Rowling", 18);

                //4.通过SharedPreferences.Editor对象的commit()方法存储数据
                editor.commit();

            }
        });

        mRestoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("age", MODE_PRIVATE);
                int age1 = sharedPreferences.getInt("ZhangSan", 0);
                int age2 = sharedPreferences.getInt("LiSi", 0);
                int age3 = sharedPreferences.getInt("Rowling", 0);

                Toast.makeText(MainActivity.this, "Rowling is " + age3 + " years old", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
