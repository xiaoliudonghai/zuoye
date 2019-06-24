package com.example.hlong.zuoye.shu;

import com.example.hlong.zuoye.bean.Stu;
import com.example.hlong.zuoye.dao.DaoMaster;
import com.example.hlong.zuoye.dao.DaoSession;
import com.example.hlong.zuoye.dao.StuDao;

import java.util.List;

public class Shu  {
    private static  Shu shu;
    private final StuDao stuDao;

    public Shu() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.getApp(), "r.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        stuDao = daoSession.getStuDao();
    }

    public static Shu getShu() {
        if (shu==null){
            synchronized (Shu.class){
                if (shu==null){
                     shu = new Shu();
                }
            }
        }
        return shu;
    }
    public void insert(Stu stu){
       if (has(stu)){
           return;
       }
       stuDao.insertOrReplace(stu);
    }
    public void delete(Stu stu){

        stuDao.delete(stu);
    }
    public boolean has(Stu stu){
        List<Stu> list = stuDao.queryBuilder().where(StuDao.Properties.Text.eq(stu.getText())).list();
        if (list.size()>0&&list!=null){
            return true;
        }
        return false;
    }
    public List<Stu> query(){
        List<Stu> list = stuDao.queryBuilder().list();
       return list;
    }
}
