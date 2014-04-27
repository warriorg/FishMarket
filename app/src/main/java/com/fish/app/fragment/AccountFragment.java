package com.fish.app.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class AccountFragment extends Fragment implements OrderAdapter.OnOrderChangeListener {

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
        mAdapter.setOnOrderChangeListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        mBalance = (TextView)view.findViewById(R.id.account_balance);
        mBalance.setText(String.format("%.2f$",accountBalance));
        mListView = (ListView)view.findViewById(R.id.account_order_list);
        mListView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void orderChange(OrderEntity orderEntity) {
        orderEntity.setStatus(0);
        mAdapter.notifyDataSetChanged();

        accountBalance -= orderEntity.getPrice();
        mBalance.setText(String.format("%.2f$",accountBalance));
    }
}
