package wang.androids.plugindev.lib.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.util.concurrent.atomic.AtomicInteger;

import wang.androids.plugindev.lib.bean.Case;


public class BusinessHelper extends OrmLiteSqliteOpenHelper {
    public static final int BUSINESS_DB_VERSION = 1;
    private static OrmLiteSqliteOpenHelper helper = null;
    private static final  String DB_NAME ="BusinessHelper.db";
    private static AtomicInteger usageCounter = new AtomicInteger(0);

    private BusinessHelper(Context context) {
        super(context, DB_NAME, null, BUSINESS_DB_VERSION);

    }


    public synchronized static OrmLiteSqliteOpenHelper getHelper(Context context) {
        if (helper == null) {
            helper = new BusinessHelper(context);
        }

        usageCounter.incrementAndGet();
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase arg0, ConnectionSource connectionSource) {

        Log.e(BusinessHelper.class.getName(), "开始创建应用数据库");
        try {
            TableUtils.createTable(connectionSource, Case.class);


            Log.i(BusinessHelper.class.getName(), "创建应用数据库成功");
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            Log.e(BusinessHelper.class.getName(), "创建应用数据库异常:" + e.getMessage());
        }

    }


    /**
     * 数据库更新操作
     *
     * @param db
     * @param connectionSource
     * @param oldVersion
     * @param arg3
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int arg3) {

        try {
            if (oldVersion < 2) {// 对某表新增字段
//                String sql = "alter table Case add theft text";
//                db.execSQL(sql);
            }


            Log.i(BusinessHelper.class.getName(), "更新应用数据库成功");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(BusinessHelper.class.getName(), "更新应用数据库异常" + e.getMessage());
        }

    }

    @Override
    public synchronized SQLiteDatabase getReadableDatabase() {
        // TODO Auto-generated method stub

        return super.getReadableDatabase();
    }

    @Override
    public synchronized SQLiteDatabase getWritableDatabase() {
        // TODO Auto-generated method stub

        return super.getWritableDatabase();
    }

    @Override
    public synchronized void close() {
        if (usageCounter.decrementAndGet() == 0) {
            super.close();
            helper = null;
        }
    }

}
