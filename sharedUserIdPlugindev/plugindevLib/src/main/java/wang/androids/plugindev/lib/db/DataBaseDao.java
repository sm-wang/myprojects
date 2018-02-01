package wang.androids.plugindev.lib.db;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

/**
 * Created by Administrator on 2017/12/19.
 */

public interface DataBaseDao<T,V> {
    int add(V e) throws SQLException;
    int delete(T record, V object) throws Exception;
    boolean isExist() throws SQLException;
    int update(T record, V object) throws SQLException;
    long queryCount() throws SQLException;
    List<V> queryForAll() throws SQLException;
    int deleteByArg(T record, String arg1, String value1) throws SQLException;
    T createOrUpdate(T record, V object) throws SQLException;
}
