package wang.androids.plugindev.lib.db.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;

import wang.androids.plugindev.lib.bean.Case;
import wang.androids.plugindev.lib.db.DataDao;

/**
 * ORMDataDaoImpl 提供了基础的增删改查，复杂的查询没法满足的时候单独扩展
 *
 * @author lucifer.wang
 */
public class CaseInforDao extends BaseDao {
    private DataDao<Case, Integer> dao;
    private Dao<Case, Integer> record;

    public CaseInforDao(Context targetContext) {
        super(targetContext, Case.class);
    }


}
