package com.example.hlong.zuoye.frament;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hlong.zuoye.R;
import com.example.hlong.zuoye.base.BaseX;
import com.example.hlong.zuoye.bean.Stu;
import com.example.hlong.zuoye.bean.Student;
import com.example.hlong.zuoye.molder.ShouMolderimp;
import com.example.hlong.zuoye.prinemt.ShouPrime;
import com.example.hlong.zuoye.view.Shouview;

import java.util.ArrayList;


public class Fragment1 extends Fragment implements Shouview {

    private View view;
    private RecyclerView mRlv1;
    private ArrayList<Student.ResultBean> list;
    private BaseX baseX;
    private ShouPrime shouPrime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fragment1, container, false);
        shouPrime = new ShouPrime(new ShouMolderimp(), this);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {

        shouPrime.getData();
    }


    private void initView(View inflate) {
        mRlv1 = (RecyclerView) inflate.findViewById(R.id.rlv1);
        mRlv1.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        baseX = new BaseX(list, getContext());
        mRlv1.setAdapter(baseX);
        baseX.setClike(new BaseX.Clike() {
            @Override
            public void clike(int po, Student.ResultBean resultBean) {
                Stu stu = new Stu();
                stu.setText(resultBean.getText());
                stu.setThumbnail(resultBean.getThumbnail());
                shouPrime.getShu(stu);
            }
        });
    }

    @Override
    public void getCheng(Student student) {
        list.addAll(student.getResult());
        baseX.notifyDataSetChanged();
    }

    @Override
    public void getShi(String s) {
        Log.e("aaaaaaa",s);
    }
}
