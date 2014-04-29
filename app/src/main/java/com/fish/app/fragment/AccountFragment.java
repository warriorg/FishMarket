package com.fish.app.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.fish.adapter.OrderAdapter;
import com.fish.app.OrderActivity;
import com.fish.app.R;
import com.fish.entity.DummyDb;
import com.fish.entity.OrderEntity;

import java.util.Collections;
import java.util.Comparator;

//我的账户
public class AccountFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private OrderAdapter mAdapter;
    private float accountBalance = 88888.88f;
    private TextView mBalance;

    public static AccountFragment newInstance() {
        AccountFragment fragment = new AccountFragment();

        return fragment;
    }
    public AccountFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Comparator<OrderEntity> comparator = new Comparator<OrderEntity>() {
            @Override
            public int compare(OrderEntity lhs, OrderEntity rhs) {
                return (int)(lhs.getOrderDt().getTime() - rhs.getOrderDt().getTime());
            }
        };

        Collections.sort(DummyDb.orderList, comparator);
        mAdapter = new OrderAdapter(getActivity(), DummyDb.orderList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        mBalance = (TextView)view.findViewById(R.id.account_balance);
        mBalance.setText(String.format("%.2f$",accountBalance));
        mListView = (ListView)view.findViewById(R.id.account_order_list);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        final OrderEntity orderEntity = DummyDb.orderList.get(position);
        if(orderEntity.getStatus() == 0)
            return;
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("通知")
                .setMessage("请确认下单，保证金将从你的账户扣除")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        orderEntity.setStatus(0);
                        accountBalance -= orderEntity.getPrice();
                        mBalance.setText(String.format("%.2f$",accountBalance));
                        mAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                })
                .create();
        dialog.show();
    }
}
