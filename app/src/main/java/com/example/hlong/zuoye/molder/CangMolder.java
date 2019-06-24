package com.example.hlong.zuoye.molder;

import com.example.hlong.zuoye.bean.Stu;
import com.example.hlong.zuoye.callbake.CangCallBake;
import com.example.hlong.zuoye.callbake.ShouCallBake;

public interface CangMolder {
    void getData(Stu stu);
    void getFan(CangCallBake cangCallBake);
}
