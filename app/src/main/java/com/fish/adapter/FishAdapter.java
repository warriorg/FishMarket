package com.fish.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fish.app.R;
import com.fish.entity.FishEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by warrior on 14-4-23.
 */
public class FishAdapter extends BaseAdapter {

    private List<FishEntity> fishList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<FishEntity> list;

    public FishAdapter(Context context,List<FishEntity> list) {
        mContext = context;
        this.list = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        if(list == null) return 0;
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.fish_list_item, null);
        }

        TextView name = (TextView)convertView.findViewById(R.id.fish_name);
        TextView highPrice = (TextView)convertView.findViewById(R.id.fish_high_price);
        TextView lowPrice = (TextView)convertView.findViewById(R.id.fish_low_price);
        FishEntity fe = list.get(position);
        name.setText(fe.getName());
        highPrice.setText(String.format("%.2f$",fe.getHighPrice()));
        lowPrice.setText(String.format("%.2f$",fe.getLowPrice()));
        return convertView;
    }
}
