package wang.androids.plugindev.lib.db;

import android.database.sqlite.SQLiteOpenHelper;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * 数据库Dao类
 *  @author wang
 * @param <T>
 * @param <V>
 */
public interface DataDao<T, V> {
	/**
	 * 得到某个Database的Dao对象
	 *
	 * @param helper
	 * @param cls
	 * @return
	 */
	public Dao<T, V> getDao(OrmLiteSqliteOpenHelper helper, Class<?> cls);
	/**
	 * 根据where 条件查询记录
	 * 
	 * @param record
	 * @param qb
	 * @return
	 * @throws SQLException
	 */

	/**
	 * 是否存在此记录
	 * 
	 * @param record
	 * @param object
	 * @return
	 * @throws SQLException
	 */
	public boolean isExist(Dao<T, V> record, V object) throws SQLException;

	/**
	 * 查询记录数
	 * 
	 * @param record
	 * @param qb
	 * @return
	 * @throws SQLException
	 */
	public long queryCount(Dao<T, V> record, QueryBuilder<T, V> qb) throws SQLException;

	/**
	 * 增加记录
	 * 
	 * @param object
	 * @throws SQLException
	 */
	public int add(Dao<T, V> record, T object) throws SQLException;

	/**
	 * 获取所有记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<T> queryForAll(Dao<T, V> record) throws SQLException;

	/**
	 * 删除指定id的记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public int delete(Dao<T, V> record, T object) throws Exception;

	public int deleteByArg(Dao<T, V> record, String arg1, String value1) throws SQLException;


	public int update(Dao<T, V> record, T object) throws SQLException;


	/**
	 * 产生或更新对象
	 * 
	 * @param record
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public T createOrUpdate(Dao<T, V> record, T object) throws SQLException;

}
