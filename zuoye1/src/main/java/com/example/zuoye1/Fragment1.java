package com.example.zuoye1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    private View view;
    private RecyclerView mRlv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fragment1, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("百度","https://www.baidu.com"));
        students.add(new Student("新浪","https://www.sina.com.cn"));
        students.add(new Student("微博","https://open.weibo.com"));
        Base base = new Base(students, getContext());
        mRlv.setAdapter(base);
        base.setClike(new Base.Clike() {
            @Override
            public void clikd(String url) {
                //clikd.Clidke(url);
                initData( url);
            }
        });

    }

    private void initData(String url) {
        EventBus.getDefault().postSticky(url);
    }

    private Clikd clikd;

    public void setClikd(Clikd clikd) {
        this.clikd = clikd;
    }

    public interface Clikd{
        void Clidke(String url);
    }
}
