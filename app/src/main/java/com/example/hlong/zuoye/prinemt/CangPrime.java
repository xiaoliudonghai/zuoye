package com.example.hlong.zuoye.prinemt;

import com.example.hlong.zuoye.bean.Stu;
import com.example.hlong.zuoye.bean.Student;
import com.example.hlong.zuoye.callbake.CangCallBake;
import com.example.hlong.zuoye.callbake.ShouCallBake;
import com.example.hlong.zuoye.molder.CangMolder;
import com.example.hlong.zuoye.molder.ShouMolder;
import com.example.hlong.zuoye.view.Cangview;
import com.example.hlong.zuoye.view.Shouview;

import java.util.List;

public class CangPrime implements ShouPrim,CangCallBake {
    private CangMolder cangMolder;
    private Cangview cangview;

    public CangPrime(CangMolder cangMolder, Cangview cangview) {
        this.cangMolder = cangMolder;
        this.cangview = cangview;
    }

    @Override
    public void getData() {
        if (cangMolder!=null){
            cangMolder.getFan(this);
        }
    }

    @Override
    public void getShu(Stu shu) {
        if (cangMolder!=null){
            cangMolder.getData(shu);
        }
    }


    @Override
    public void getCheng(List<Stu> stus) {
        cangview.getCheng(stus);
    }

}
