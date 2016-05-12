package com.example.uibestpractise;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<Msg> mMsgArrayList = new ArrayList<Msg>();
    MsgAdapter adapter;

    private ListView mListView;
    private EditText mEditText;
    private Button mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.list_view);
        mSendButton = (Button)findViewById(R.id.send_button);
        mEditText = (EditText)findViewById(R.id.edit_text);

        mSendButton.setOnClickListener(new MyClickListener());
        initMsgs();
        adapter = new MsgAdapter(this, R.layout.list_item, mMsgArrayList);
        mListView.setAdapter(adapter);
    }

    private void initMsgs() {
        Msg message1 = new Msg("Hello, I'm rowling", Msg.TYPE_RECEIVE);
        mMsgArrayList.add(message1);
        Msg message2 = new Msg("Nice to meet you", Msg.TYPE_RECEIVE);
        mMsgArrayList.add(message2);
        Msg message3 = new Msg("Nice to meet you, too", Msg.TYPE_SEND);
        mMsgArrayList.add(message3);
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.send_button:
                    String message = mEditText.getText().toString();
                    if ("".equals(message)) {
                        Toast.makeText(MainActivity.this, "Can't send empty message", Toast.LENGTH_SHORT).show();
                    } else {
                        mMsgArrayList.add(new Msg(message, Msg.TYPE_SEND));
                        adapter.notifyDataSetChanged();
                        mEditText.setText("");
                    }
                    break;
            }
        }
    }
}
