package com.jackpot.forlecture_event;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    public String[] names = {"Lee", "Choi", "Kim", "Kwak", "Jeong"};
    Context mContext;

    public MyAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount(){
        return names.length;
    }

    @Override
    public Object getItem(int position){
        return names[position];
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        TextView view = new TextView(mContext);
        view.setText(names[position]);
        view.setTextColor(Color.BLUE);
        return view;
    }
}
