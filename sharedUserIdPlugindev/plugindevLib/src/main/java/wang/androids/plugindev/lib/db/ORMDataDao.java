package wang.androids.plugindev.lib.db;

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
public interface ORMDataDao<T, V> {
	/**
	 * 得到某个Database的Dao对象
	 *
	 * @param helper
	 * @param cls
	 * @return
	 */
	public Dao<T, V> getDao(OrmLiteSqliteOpenHelper helper, Class<T> cls);
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
	public boolean isExist( V object) throws SQLException;

	/**
	 * 查询记录数
	 * 
	 * @param record
	 * @param qb
	 * @return
	 * @throws SQLException
	 */
	public long queryCount( QueryBuilder<T, V> qb) throws SQLException;

	/**
	 * 增加记录
	 * 
	 * @param object
	 * @throws SQLException
	 */
	public int add( T object) throws SQLException;

	/**
	 * 获取所有记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<T> queryForAll() throws SQLException;

	/**
	 * 删除指定id的记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public int delete( T object) throws Exception;

	public int deleteByArg( String arg1, String value1) throws SQLException;


	public int update( T object) throws SQLException;


	/**
	 * 产生或更新对象
	 * 
	 * @param record
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public T createOrUpdate( T object) throws SQLException;

}
