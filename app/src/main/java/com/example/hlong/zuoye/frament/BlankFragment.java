package com.example.hlong.zuoye.frament;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hlong.zuoye.R;
import com.example.hlong.zuoye.base.BaseX1;
import com.example.hlong.zuoye.bean.Stu;
import com.example.hlong.zuoye.molder.CangMolderimp;
import com.example.hlong.zuoye.prinemt.CangPrime;
import com.example.hlong.zuoye.view.Cangview;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements Cangview {


    private View view;
    private RecyclerView mRlv2;
    private ArrayList<Stu>  stus = new ArrayList<>();
    private BaseX1 baseX1;
    private CangPrime cangPrime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        initView(inflate);
        cangPrime = new CangPrime(new CangMolderimp(), this);
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            cangPrime.getData();
        }else {
            stus.clear();
        }
    }

    private void initView(View inflate) {
        mRlv2 = (RecyclerView) inflate.findViewById(R.id.rlv2);
        mRlv2.setLayoutManager(new LinearLayoutManager(getContext()));

        baseX1 = new BaseX1(stus, getContext());
        mRlv2.setAdapter(baseX1);
        baseX1.setClike(new BaseX1.Clike() {
            @Override
            public void clike(int po, Stu stu) {
                cangPrime.getShu(stu);
                stus.remove(po);
                baseX1.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void getCheng(final List<Stu> stus) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                stus.addAll(stus);
                baseX1.notifyDataSetChanged();
            }
        });
    }
}
