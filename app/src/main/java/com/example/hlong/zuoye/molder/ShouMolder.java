package com.example.hlong.zuoye.molder;

import com.example.hlong.zuoye.bean.Stu;
import com.example.hlong.zuoye.callbake.ShouCallBake;

public interface ShouMolder {
    void getData(Stu stu);
    void getFan(ShouCallBake shouCallBake);
}
