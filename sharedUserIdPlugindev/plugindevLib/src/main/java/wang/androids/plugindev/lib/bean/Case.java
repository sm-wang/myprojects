package wang.androids.plugindev.lib.bean;

import android.os.SystemClock;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017/12/18.
 */
@DatabaseTable
public class Case {
    @DatabaseField(generatedId = true)
    private int _id;// 自增id
    @DatabaseField
    private String updatetime;
    @DatabaseField
    private String desc;

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "{" +
                "_id=" + _id +
                ", updatetime='" + updatetime + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
