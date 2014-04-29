package com.fish.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fish.app.R;
import com.fish.entity.FishEntity;

import java.util.List;

/**
 * Created by warrior on 14-4-24.
 */
public class FishPortAdapter extends BaseAdapter {

    private List<FishEntity> list;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public FishPortAdapter(Context context, List<FishEntity> list) {
        this.list = list;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
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
            convertView = mLayoutInflater.inflate(R.layout.fish_port_list_item, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.fish_port_name);
        Drawable drawable;
        if(position % 2 == 0)
            drawable = mContext.getResources().getDrawable(R.drawable.ic_messages);
        else
            drawable = mContext.getResources().getDrawable(R.drawable.ic_refresh);
        name.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null,null);
        TextView price = (TextView) convertView.findViewById(R.id.fish_price);
        FishEntity fe = list.get(position);
        name.setText(fe.getArea());
        price.setText(String.format("%.2f$", fe.getLowPrice()));

        return convertView;
    }
}
