package com.orange.broadcastbestpractise;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 80119667 on 2016-05-28.
 */
public class LoginActivity extends BaseActivity{

    private EditText mAccountEditText;
    private EditText mPasswordEditText;
    private Button mOkButton;

    private final String LOG_TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAccountEditText = (EditText)findViewById(R.id.account_edit_text);
        mPasswordEditText = (EditText)findViewById(R.id.password_edit_text);
        mOkButton = (Button)findViewById(R.id.ok_button);

        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = mAccountEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();
                if ("admin".equals(account) && "123321".equals(password)) {
                    Log.d(LOG_TAG, "Right");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Your account or password is wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
