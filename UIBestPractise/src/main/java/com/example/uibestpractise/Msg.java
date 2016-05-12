package com.example.uibestpractise;

/**
 * Created by 80119667 on 2016-05-12.
 */
public class Msg {
    public static final int TYPE_SEND = 0;
    public static final int TYPE_RECEIVE = 1;

    private int mType;
    private String mContent;

    Msg(String content, int type) {
        mType = type;
        mContent = content;
    }

    public int getType() {
        return mType;
    }

    public String getContent() {
        return mContent;
    }
}
