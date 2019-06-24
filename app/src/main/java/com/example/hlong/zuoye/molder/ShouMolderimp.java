package com.example.hlong.zuoye.molder;

import com.example.hlong.zuoye.api.Api;
import com.example.hlong.zuoye.bean.Stu;
import com.example.hlong.zuoye.bean.Student;
import com.example.hlong.zuoye.callbake.ShouCallBake;
import com.example.hlong.zuoye.shu.Shu;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShouMolderimp implements ShouMolder {
    @Override
    public void getData(final Stu stu) {
        new Thread(){
            @Override
            public void run() {
                Shu.getShu().insert(stu);
            }
        }.start();
    }

    @Override
    public void getFan(final ShouCallBake shouCallBake) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(Api.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = build.create(Api.class);
        Observable<Student> studentObservable = api.get();
        studentObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Student>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Student student) {
                        if (student!=null){
                            shouCallBake.getCheng(student);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        shouCallBake.getShi(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
