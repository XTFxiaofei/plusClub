package com.android.renly.plusclub.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.renly.plusclub.R;

import java.util.Calendar;

public class LaunchActivity extends Activity{
    private static final int WAIT_TIME = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_launch);
//        App app = (App) getApplication();
//        app.regReciever();
        setCopyRight();
        new Handler().postDelayed(() -> enterHome(), WAIT_TIME);
    }

    private void enterHome() {
        startActivity(new Intent(LaunchActivity.this,HomeActivity.class));
        finish();
    }

    //自动续命copyright
    private void setCopyRight() {
        int year = 2016;
        int yearNow = Calendar.getInstance().get(Calendar.YEAR);

        if (year < yearNow) {
            year = yearNow;
        }
        ((TextView) findViewById(R.id.copyright))
                .setText("©2016-" + year + " lsuplus.top");
    }

    @Override
    public void finish() {
        super.finish();
        // 去掉自带的转场动画
        overridePendingTransition(R.anim.zoomin, R.anim.zoomout);
    }
}
