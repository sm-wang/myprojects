
package wang.androids.plugindev.lib.db;

import android.content.Context;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;

import java.sql.SQLException;
import java.util.List;

/**
 * 通用数据库Dao，封装了最基本的操作，如果不能够满足，可以在业务的Model层对Dao进行操作。
 * OrmLiteSqliteOpenHelper
 * 目前是針對ormlite的具体dao 看看能不能再封装一层上层dao的包装 统一我的dao
 *
 * @param <T,V>：T实体对象，V key对象
 * @author wang
 */
public class ORMDataDaoImpl<T, V> implements ORMDataDao<T, V> {
    protected Dao<T, V> record;
    protected OrmLiteSqliteOpenHelper helper;

    public ORMDataDaoImpl(Context context, Class<T> cls) {
        helper = BusinessHelper.getHelper(context);
        getDao(helper, cls);
    }


    @Override
    public long queryCount(QueryBuilder<T, V> qb) throws SQLException {
        return record.countOf(qb.prepare());
    }

    //针对不同的orm框架获取不同的dao 目前看不行
    @Override
    public Dao<T, V> getDao(OrmLiteSqliteOpenHelper helper, Class<T> cls) {
        if (helper == null)
            return null;
        try {
            record = helper.getDao(cls);
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
        return record;
    }


    @Override
    public boolean isExist(V object) throws SQLException {
        return record.idExists(object);
    }

    @Override
    public int add(final T object) throws SQLException {

        return record.create(object);

    }

    @Override
    public List<T> queryForAll() throws SQLException {


        return record.queryForAll();
    }

    @Override
    public int delete(T object) throws SQLException {

        int ret = -1;
        ret = record.delete(object);
        return ret;
    }


    @Override
    public int update(final T object) throws SQLException {
        int ret = -1;

        ret = record.update(object);
        return ret;
    }

    public int updateByBuilder(UpdateBuilder<T, V> ub) throws SQLException {
        int ret = 1;
        ret = ub.update();
        return ret;
    }

    @Override
    public T createOrUpdate(final T object) throws SQLException {

        record.createOrUpdate(object);
        return object;
    }


    @Override
    public int deleteByArg(String arg1, String value1) throws SQLException {
        int ret = -1;

        if (arg1 == null || value1 == null) {
            return ret;
        }

        DeleteBuilder<T, V> ub = record.deleteBuilder();
        Where<T, V> where = ub.where();
        where.eq(arg1, value1);

        ret = ub.delete();
        return ret;
    }

    protected void open() {
//        helper = BusinessHelper.getHelper(context);
    }

    protected void close() {
    }

    public Dao<T, V> getRecord() {
        return record;
    }
}
