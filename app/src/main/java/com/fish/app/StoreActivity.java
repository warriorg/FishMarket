package com.fish.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.fish.adapter.StoreAdapter;
import com.fish.entity.DummyDb;
import com.fish.entity.FishEntity;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

public class StoreActivity extends RoboActivity implements ListView.OnItemClickListener {

    @InjectView(R.id.store_list)
    private ListView mList;
    @InjectView(R.id.store_area_name)
    private TextView mAreaName;
    @InjectView(R.id.store_fish_name)
    private TextView mFishName;

    private StoreAdapter mAdapter;

    FishEntity fish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Intent intent = getIntent();
        fish = (FishEntity)intent.getExtras().get("FISH_ENTITY");

        if(fish != null) {
            mAreaName.setText(fish.getArea());
            mFishName.setText(fish.getName());
        }

        mAdapter = new StoreAdapter(this, DummyDb.storeList);
        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("FISH_ENTITY", fish);
        intent.putExtra("STORE_ENTITY", DummyDb.storeList.get(position));
        startActivity(intent);
    }
}
