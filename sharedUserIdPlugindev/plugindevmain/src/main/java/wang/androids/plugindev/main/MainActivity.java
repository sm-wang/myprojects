package wang.androids.plugindev.main;

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
        setContentView(R.layout.activity_main);
        hello = (TextView) findViewById(R.id.mainhello);
        hello.setText("Main Hello");

        findViewById(R.id.main_start_modulea).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    // A Context ,A activity
                    Intent intentPeople = new Intent();
                    intentPeople.setClassName(getTargetContext("wang.androids.plugindev.modulea"), "wang.androids.plugindev.modulea.activity.TestActivity");
                    startActivity(intentPeople);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "没有安装A模块", Toast.LENGTH_SHORT).show();
                }

            }
        });
        findViewById(R.id.main_start_moduleb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // b Context ,b activity
                    Intent intentPeople = new Intent();
                    intentPeople.setClassName(getTargetContext("wang.androids.plugindev.moduleb"), "wang.androids.plugindev.moduleb.MainActivity");
                    startActivity(intentPeople);
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "没有安装B模块", Toast.LENGTH_SHORT).show();
                }

            }
        });
        findViewById(R.id.queryMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainModule Context

                ORMDataDaoImpl dataDao = new ORMDataDaoImpl(MainActivity.this, Case.class);
                try {
                    final List<Case> list = dataDao.queryForAll();
                    StringBuilder sb = new StringBuilder("queryMain:\r\n");
                    for (Case c : list) {
                        sb.append(c.toString()).append("\r\n");
                    }
                    hello.setText(sb.toString());


                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        findViewById(R.id.addMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ORMDataDaoImpl dataDao = new ORMDataDaoImpl(MainActivity.this, Case.class);
                try {
                    Case c = new Case();
                    c.setDesc("Main itself add");
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
