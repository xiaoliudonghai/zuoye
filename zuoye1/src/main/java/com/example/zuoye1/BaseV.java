package com.example.zuoye1;

import android.support.annotation.ArrayRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

class BaseV  extends FragmentStatePagerAdapter {
    ArrayList<Fragment> list;
    String []arr;
    public BaseV(FragmentManager fm,ArrayList<Fragment> list,
            String []arr) {
        super(fm);
        this.list=list;
        this.arr=arr;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arr[position];
    }
}
