package com.example.hlong.zuoye.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.hlong.zuoye.bean.Stu;

import com.example.hlong.zuoye.dao.StuDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig stuDaoConfig;

    private final StuDao stuDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        stuDaoConfig = daoConfigMap.get(StuDao.class).clone();
        stuDaoConfig.initIdentityScope(type);

        stuDao = new StuDao(stuDaoConfig, this);

        registerDao(Stu.class, stuDao);
    }
    
    public void clear() {
        stuDaoConfig.clearIdentityScope();
    }

    public StuDao getStuDao() {
        return stuDao;
    }

}
