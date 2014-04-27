package com.fish.app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.fish.app.fragment.AccountFragment;
import com.fish.app.fragment.FishMarketFragment;
import com.fish.app.fragment.FishPriceFragment;
import com.fish.entity.FishEntity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements ActionBar.TabListener, FishMarketFragment.OnFragmentInteractionListener, FishPriceFragment.OnFragmentInteractionListener {
    private final static String TAG = "MainActivity";

    List<Fragment> mList;
    FishMarketFragment mFishMarket;
    FishPriceFragment mFishPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        mList = new ArrayList<Fragment>();
        mFishMarket = FishMarketFragment.newInstance();
        mList.add(mFishMarket);

        AccountFragment mAccount = AccountFragment.newInstance();
        mList.add(mAccount);

        mFishPrice = FishPriceFragment.newInstance();

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.addTab(actionBar.newTab().setText("鱼市场").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("我的账户").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("设置").setTabListener(this));


        Intent intent = getIntent();
        boolean result = intent.getBooleanExtra("ACCOUNT", false);
        if (result) {
            actionBar.setSelectedNavigationItem(1);
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.d(TAG, "onTabSelected");
        if (mList == null || mList.size() <= tab.getPosition()) {
            return;
        }

        ft.add(R.id.main, mList.get(tab.getPosition()));
        ft.attach(mList.get(tab.getPosition()));

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.d(TAG, "onTabUnselected");
        if (mList == null || mList.size() <= tab.getPosition())
            return;
        ft.detach(mList.get(tab.getPosition()));
        if (mFishPrice.isAdded())
            ft.detach(mFishPrice);
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onFragmentInteraction(int id) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.addToBackStack("tag");
        mFishPrice.setPosition(id);
//        ft.setCustomAnimations(android.R.animator.fade_in,
//                android.R.animator.fade_out);
        ft.detach(mFishMarket);

        if (!mFishPrice.isAdded())
            ft.add(R.id.main, mFishPrice);
        ft.attach(mFishPrice);
//        ft.attach(mFishPrice);
        ft.commit();
    }

    //选择价格
    @Override
    public void onFragmentInteraction(FishEntity fishPort) {
        Intent intent = new Intent(this, StoreActivity.class);
        intent.putExtra("FISH_ENTITY", fishPort);
        startActivity(intent);
    }
}
