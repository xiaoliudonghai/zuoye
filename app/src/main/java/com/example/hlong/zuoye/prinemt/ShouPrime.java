package com.example.hlong.zuoye.prinemt;

import com.example.hlong.zuoye.bean.Stu;
import com.example.hlong.zuoye.bean.Student;
import com.example.hlong.zuoye.callbake.ShouCallBake;
import com.example.hlong.zuoye.molder.ShouMolder;
import com.example.hlong.zuoye.shu.Shu;
import com.example.hlong.zuoye.view.Shouview;

public class ShouPrime implements ShouPrim, ShouCallBake {
    private ShouMolder shouMolder;
    private Shouview shouview;

    public ShouPrime(ShouMolder shouMolder, Shouview shouview) {
        this.shouMolder = shouMolder;
        this.shouview = shouview;
    }

    @Override
    public void getData() {
        if (shouMolder!=null){
            shouMolder.getFan(this);
        }
    }

    @Override
    public void getShu(Stu shu) {
        if (shouMolder!=null){
            shouMolder.getData(shu);
        }
    }

    @Override
    public void getCheng(Student student) {
        shouview.getCheng(student);
    }

    @Override
    public void getShi(String s) {
    shouview.getShi(s);
    }
}
