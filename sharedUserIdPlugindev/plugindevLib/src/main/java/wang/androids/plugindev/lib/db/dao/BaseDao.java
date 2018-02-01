package wang.androids.plugindev.lib.db.dao;

import android.content.Context;

import wang.androids.plugindev.lib.db.ORMDataDaoImpl;

/**
 * 普通逻辑基类
 *
 * @author lucfier.wang
 */
public abstract class BaseDao<T, V> {
    // 系统数据对象
    protected Context context;
    ORMDataDaoImpl dao;

    //    helper = BusinessHelper.getHelper(context);
// dao=   new dao() 对象多次使用导致close
// dao ->save ->close
// dao->query ->excepeton database have close
// 多关闭了  所以暂时close 方法给注销了 数据库保持长时间打开
    public BaseDao(Context context, Class<?> cls) {
        this.context = context;
        dao = new ORMDataDaoImpl(context, cls);
    }

    protected void open() {
    }

    protected void close() {
    }

    protected void finalize() throws Throwable {
        super.finalize();

    }


}
