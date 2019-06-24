package com.example.zuoye1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager mVp;
    private TabLayout mTab;
    private String [] arr={"A","B"};
    private Fragment1 fragment1;
    private Fragment2 fragment2;

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
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
//        fragment1.setClikd(new Fragment1.Clikd() {
//            @Override
//            public void Clidke(String url) {
//                fragment2.setRul(url);
//            }
//        });
        fragments.add(fragment1);
        fragments.add(fragment2);
        BaseV baseV = new BaseV(getSupportFragmentManager(), fragments, arr);
        mVp.setAdapter(baseV);
        mTab.setupWithViewPager(mVp);

    }
}
