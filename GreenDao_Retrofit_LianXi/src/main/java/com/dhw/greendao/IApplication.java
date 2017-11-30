package com.dhw.greendao;

import android.app.Application;
import com.dhw.greendao.dao.DaoMaster;
import com.dhw.greendao.dao.DaoSession;
import org.greenrobot.greendao.database.Database;

/**
 *全局配置初始化数据库
 */
public class IApplication extends Application {

    //设置session为公用
    public static DaoSession session;

    @Override
    public void onCreate() {
        super.onCreate();

        //初始化数据库
        DaoMaster.DevOpenHelper database = new DaoMaster.DevOpenHelper(this, "DHW");

        //获取数据库
        //Database data = database.getEncryptedWritableDb("data");
        Database db = database.getWritableDb();

        //操作数据库,等于打开数据库
        session = new DaoMaster(db).newSession();
    }
}
