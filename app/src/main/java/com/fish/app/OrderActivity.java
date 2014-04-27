package com.fish.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fish.entity.DummyDb;
import com.fish.entity.FishEntity;
import com.fish.entity.OrderEntity;
import com.fish.entity.StoreEntity;

import java.util.Date;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class OrderActivity extends RoboActivity implements Button.OnClickListener {

    @InjectView(R.id.order_area_name)
    private TextView mArea;
    @InjectView(R.id.order_fish_name)
    private TextView mFishName;
    @InjectView(R.id.order_store_name)
    private TextView mStoreName;
    @InjectView(R.id.order_fish_price)
    private TextView mFishPrice;
    @InjectView(R.id.order_store_weight)
    private TextView mFiishWeight;
    @InjectView(R.id.order_submit)
    private Button mButton;

    private StoreEntity storeEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        FishEntity fish = (FishEntity)intent.getExtras().get("FISH_ENTITY");

        if(fish != null) {
            mArea.setText(fish.getArea());
            mFishName.setText(fish.getName());
        }
        storeEntity = (StoreEntity)intent.getExtras().get("STORE_ENTITY");
        if(storeEntity != null){
            mStoreName.setText(storeEntity.getName());
            mFishPrice.setText(String.format("%.2f$", storeEntity.getPrice()));
            mFiishWeight.setText(String.format("%.2fKG", storeEntity.getWeight()));
        }


        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog dialog = new AlertDialog.Builder(this)
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

                        OrderEntity orderEntity = new OrderEntity();
                        orderEntity.setName(storeEntity.getName())
                                .setStatus(1)
                                .setWeight(storeEntity.getWeight())
                                .setPrice(storeEntity.getPrice())
                                .setOrderDt(new Date());
                        DummyDb.orderList.add(orderEntity);

                        dialog.dismiss();
                        Intent intent = new Intent(OrderActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("ACCOUNT", true);
                        startActivity(intent);
                    }
                })
                .create();
        dialog.show();
    }
}
