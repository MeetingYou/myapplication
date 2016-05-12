package com.example.uibestpractise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 80119667 on 2016-05-12.
 */
public class MsgAdapter extends ArrayAdapter<Msg> {

    private int mResource;

    public MsgAdapter(Context context, int resource, List<Msg> objects) {
        super(context, resource, objects);
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg message = (Msg)getItem(position);
        View view;
        ViewHolder viewHolder = new ViewHolder();

        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(mResource, null);
            viewHolder.mSendTextView = (TextView)view.findViewById(R.id.send_textview);
            viewHolder.mReceiveTextView = (TextView)view.findViewById(R.id.receive_textview);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        if (message.getType()==Msg.TYPE_SEND) {
            viewHolder.mSendTextView.setText(message.getContent());
            viewHolder.mSendTextView.setVisibility(View.VISIBLE);
            viewHolder.mReceiveTextView.setVisibility(View.GONE);
        } else if (message.getType()==Msg.TYPE_RECEIVE) {
            viewHolder.mReceiveTextView.setText(message.getContent());
            viewHolder.mSendTextView.setVisibility(View.GONE);
            viewHolder.mReceiveTextView.setVisibility(View.VISIBLE);
        }

        return  view;
    }

    private class ViewHolder {
        TextView mSendTextView;
        TextView mReceiveTextView;
    }
}
