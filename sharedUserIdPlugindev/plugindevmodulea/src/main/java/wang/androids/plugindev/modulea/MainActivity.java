package wang.androids.plugindev.modulea;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import wang.androids.plugindev.lib.AppBaseActivity;
import wang.androids.plugindev.lib.bean.Case;
import wang.androids.plugindev.lib.db.ORMDataDaoImpl;


public class MainActivity extends AppBaseActivity {
    TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);
        hello = (TextView) findViewById(R.id.ahello);
        hello.setText("ModuleA Hello");

        findViewById(R.id.astartmain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intentPeople = new Intent();
                    intentPeople.setClassName(getTargetContext("wang.androids.plugindev.main"), "wang.androids.plugindev.main.MainActivity");
                    startActivity(intentPeople);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "没有安装main模块", Toast.LENGTH_SHORT).show();
                }

            }
        });
        findViewById(R.id.astartb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intentPeople = new Intent();
                    intentPeople.setClassName(getTargetContext("wang.androids.plugindev.moduleb"), "wang.androids.plugindev.moduleb.MainActivity");
                    startActivity(intentPeople);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "没有安装moduleb模块", Toast.LENGTH_SHORT).show();
                }

            }
        });
        findViewById(R.id.AqueryMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainModule Context

                ORMDataDaoImpl dataDao = new ORMDataDaoImpl(getTargetContext("wang.androids.plugindev.main"), Case.class);
                try {
                    final List<Case> list = dataDao.queryForAll();
                    StringBuilder sb = new StringBuilder("AqueryMain:\r\n");
                    for (Case c : list) {
                        sb.append(c.toString()).append("\r\n");
                    }
                    hello.setText(sb.toString());


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.AaddtoMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ORMDataDaoImpl dataDao = new ORMDataDaoImpl(getTargetContext("wang.androids.plugindev.main"), Case.class);
                try {
                    Case c = new Case();
                    c.setDesc("A add to Main");
                    c.setUpdatetime(new Date().toLocaleString());
                    dataDao.add(c);

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }
}
