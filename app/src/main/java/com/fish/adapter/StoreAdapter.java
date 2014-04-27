package com.fish.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.fish.app.R;
import com.fish.entity.StoreEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by warrior on 14-4-24.
 */
public class StoreAdapter extends BaseAdapter {
    private List<StoreEntity> list;


    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public StoreAdapter(Context context,List<StoreEntity> list)
    {
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
            convertView = mLayoutInflater.inflate(R.layout.list_item_store, null);
        }

        TextView name = (TextView)convertView.findViewById(R.id.store_name);
        TextView price = (TextView)convertView.findViewById(R.id.fish_price);
        TextView weight = (TextView)convertView.findViewById(R.id.store_weight);
        StoreEntity fe = list.get(position);
        name.setText(fe.getName());
        price.setText(String.format("%.2f$", fe.getPrice()));
        weight.setText(String.format("%.2fKG", fe.getWeight()));

        return convertView;
    }
}
