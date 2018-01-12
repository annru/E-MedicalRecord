package priv.annru.emedicalrecord.base;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import priv.annru.emedicalrecord.gen.DaoMaster;
import priv.annru.emedicalrecord.gen.DaoSession;

/**
 * Created on 2018/1/9.
 *
 * @author 00224524
 */

public class MyApplication extends Application {
    public static MyApplication instance;
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setDataBase();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    private void setDataBase() {
        mHelper = new DaoMaster.DevOpenHelper(this, "medical-db", null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
}

