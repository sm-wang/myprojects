
package wang.androids.plugindev.lib.db;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

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
 *
 * @param <T,V>：T实体对象，V key对象
 * @author wang
 */
public class DataDaoImpl<T, V> implements DataDao<T, V> {
    private Dao<T, V> dao;
    OrmLiteBusinessHelper helper;
    public DataDaoImpl(Context context) {
        helper = OrmLiteBusinessHelper.getHelper(context);
    }


    @Override
    public long queryCount(Dao<T, V> record, QueryBuilder<T, V> qb) throws SQLException {
        return record.countOf(qb.prepare());
    }

    @Override
    public Dao<T, V> getDao(SQLiteOpenHelper helper, Class<?> cls) {
        if (helper == null)
            return null;
        OrmLiteSqliteOpenHelper ormLiteSqliteOpenHelper = (OrmLiteSqliteOpenHelper) helper;//强转ｈｅｌｏｐ
        try {
            dao = (Dao<T, V>) ormLiteSqliteOpenHelper.getDao(cls);
        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }
        return dao;
    }


    @Override
    public boolean isExist(Dao<T, V> record, V object) throws SQLException {
        return record.idExists(object);
    }

    @Override
    public int add(final Dao<T, V> record, T object) throws SQLException {

        return record.create(object);

    }

    @Override
    public List<T> queryForAll(Dao<T, V> record) throws SQLException {


        return record.queryForAll();
    }

    @Override
    public int delete(Dao<T, V> record, T object) throws SQLException {

        int ret = -1;
        Dao<T, V> dao = (Dao<T, V>) record;
        ret = dao.delete(object);
        return ret;
    }


    @Override
    public int update(final Dao<T, V> record, T object) throws SQLException {
        int ret = -1;

        ret = record.update(object);
        return ret;
    }

    public int updateByBuilder(Dao<T, V> record, UpdateBuilder<T, V> ub) throws SQLException {
        int ret = 1;
        ret = ub.update();
        return ret;
    }

    @Override
    public T createOrUpdate(Dao<T, V> record, final T object) throws SQLException {

        record.createOrUpdate(object);
        return object;
    }


    @Override
    public int deleteByArg(Dao<T, V> record, String arg1, String value1) throws SQLException {
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

}
