package com.example.hlong.zuoye;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.hlong.zuoye.base.BaseV;
import com.example.hlong.zuoye.frament.BlankFragment;
import com.example.hlong.zuoye.frament.Fragment1;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager mVp;
    private TabLayout mTab;
    private ArrayList<Fragment> list;

    //刘东海 1809A
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        list = new ArrayList<>();

        list.add(new Fragment1());
        list.add(new BlankFragment());
        mTab.addTab(mTab.newTab().setText("首页"));
        mTab.addTab(mTab.newTab().setText("收藏"));
        BaseV baseV = new BaseV(getSupportFragmentManager(), list);
        mVp.setAdapter(baseV);
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mVp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mVp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));
    }
}
