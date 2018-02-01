package wang.androids.plugindev.lib;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import wang.androids.plugindev.lib.viewannotation.AViewProcessor;


/**
 * Created by Administrator on 2017/12/13.
 */

public abstract class AppBaseActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        AViewProcessor.init(this);
        initData();
//        initView();
    }

    protected abstract void initData();

    protected abstract void initView();


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onClick(View v) {

    }

    public Context getTargetContext(String targetPackageName) {
        Context targetContext = null;
        try {
            targetContext = createPackageContext(targetPackageName, Context.CONTEXT_RESTRICTED);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return targetContext;
    }
}
