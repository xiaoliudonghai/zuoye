package com.example.hlong.zuoye.molder;

import com.example.hlong.zuoye.bean.Stu;
import com.example.hlong.zuoye.callbake.CangCallBake;
import com.example.hlong.zuoye.shu.Shu;

import java.util.List;

public class CangMolderimp implements CangMolder {
    @Override
    public void getData(final Stu stu) {
        new Thread(){
            @Override
            public void run() {
                Shu.getShu().delete(stu);
            }
        }.start();
    }

    @Override
    public void getFan(final CangCallBake cangCallBake) {
        new Thread(){
            @Override
            public void run() {
                List<Stu> query = Shu.getShu().query();
                cangCallBake.getCheng(query);
            }
        }.start();
    }
}
