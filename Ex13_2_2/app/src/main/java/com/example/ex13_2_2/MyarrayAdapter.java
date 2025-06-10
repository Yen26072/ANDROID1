package com.example.ex13_2_2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyarrayAdapter extends ArrayAdapter<Image> {
    Activity context = null;
    ArrayList<Image> myArray = null;
    int LayoutId;

    public MyarrayAdapter(Activity context, int LayoutId, ArrayList<Image> arr) {
        super(context, LayoutId, arr);
        this.context = context;
        this.LayoutId = LayoutId;
        this.myArray = arr;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(LayoutId, null);
        final Image myimage = myArray.get(position);
        final ImageView imgitem = (ImageView) convertView.findViewById(R.id.imageView);
        imgitem.setImageResource(myimage.getImg());
        final TextView myname = (TextView) convertView.findViewById(R.id.textView);
        myname.setText(myimage.getName());
        return convertView;
    }
}
