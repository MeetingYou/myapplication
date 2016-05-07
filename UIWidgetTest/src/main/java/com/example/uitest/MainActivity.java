package com.example.uitest;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button button;
    private EditText editText;
    private ProgressBar progressBar;
    private Button alertButton;
    private Button progressButton;
    private Button secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new MyOnclickListener());
        editText = (EditText)findViewById(R.id.edit_text);
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        alertButton = (Button)findViewById(R.id.alert_button);
        alertButton.setOnClickListener(new MyOnclickListener());
        progressButton = (Button)findViewById(R.id.progress_button);
        progressButton.setOnClickListener(new MyOnclickListener());
        secondButton = (Button)findViewById(R.id.second_button);
        secondButton.setOnClickListener(new MyOnclickListener());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Anhui", "onDestroy()");
    }

    private class MyOnclickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    /*
                    String msg = editText.getText().toString();
                    if (msg.length()>0) {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                    */
                    if (progressBar.getVisibility()==View.VISIBLE) {
                        progressBar.setVisibility(View.GONE);
                    } else {
                        progressBar.setVisibility(View.VISIBLE);
                    }
                    break;
                case R.id.alert_button:
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("Are you Rowling?");
                    alertDialog.setMessage("Yes or no?");
                    alertDialog.setCancelable(false);
                    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "Hi Rowling", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.this.finish();
                        }
                    });
                    alertDialog.show();
                    break;
                case R.id.progress_button:
                    ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle("Waiting");
                    progressDialog.setMessage("Loading....");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    for (int i=0; i<10000; i++) {

                    }
                    progressDialog.dismiss();
                    break;
                case R.id.second_button:
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
