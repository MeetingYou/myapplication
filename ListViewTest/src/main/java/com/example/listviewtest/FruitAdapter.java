package com.example.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 80119667 on 2016-05-09.
 */
public class FruitAdapter extends ArrayAdapter<Fruit>{

    private int resourceId;

    public FruitAdapter(Context context, int resource, List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*
        Fruit fruit = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        imageView.setImageResource(fruit.getImageId());
        textView.setText(fruit.getName());
        return view;
        */

        /*
        Fruit fruit = getItem(position);
        View view;
        if (convertView==null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        } else {
            view = convertView;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        imageView.setImageResource(fruit.getImageId());
        textView.setText(fruit.getName());
        return view;
        */

        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView)view.findViewById(R.id.image_view);
            viewHolder.textView = (TextView)view.findViewById(R.id.text_view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.imageView.setImageResource(fruit.getImageId());
        viewHolder.textView.setText(fruit.getName());
        return  view;
    }

    public class ViewHolder {
        public ImageView imageView;
        public TextView textView;
    }
}
