package com.fish.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fish.app.MainActivity;
import com.fish.app.R;
import com.fish.entity.OrderEntity;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by warrior on 14-4-24.
 */
public class OrderAdapter extends BaseAdapter {

    private List<OrderEntity> mList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public OrderAdapter(Context context, List<OrderEntity> list) {
        mContext = context;
        mList = list;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item_order, null);
        }

        TextView name = (TextView)convertView.findViewById(R.id.order_store_name);
        TextView price = (TextView)convertView.findViewById(R.id.order_fish_price);
        TextView weight = (TextView)convertView.findViewById(R.id.order_store_weight);
        TextView orderDt = (TextView)convertView.findViewById(R.id.order_dt);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.order_status);
        final OrderEntity fe = mList.get(position);
        if(fe.getStatus() == 0) {
            imageView.setImageResource(R.drawable.ic_finish);
        } else {
            imageView.setImageResource(R.drawable.ic_check);
        }
        name.setText(fe.getName());

        price.setText(String.format("%.2f$", fe.getPrice()));
        weight.setText(String.format("%.2fKG", fe.getWeight()));
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        orderDt.setText(sf.format(fe.getOrderDt()));

        return convertView;
    }

}
