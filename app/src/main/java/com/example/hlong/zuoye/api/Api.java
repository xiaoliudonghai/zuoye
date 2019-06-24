package com.example.hlong.zuoye.api;

import com.example.hlong.zuoye.bean.Student;

import javax.crypto.interfaces.PBEKey;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    //的风格受到广泛
    //爱上的人体育回家看了
    public String url="https://api.apiopen.top/";
    @GET("getJoke?page=1&count=20&type=video")
    Observable<Student> get();
}
