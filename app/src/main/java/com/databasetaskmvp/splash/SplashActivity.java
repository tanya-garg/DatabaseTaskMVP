package com.databasetaskmvp.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.databasetaskmvp.base.BaseActivity;
import com.databasetaskmvp.homepage.HomeActivity;

/**
 * Created by appinventiv on 20/4/18.
 */

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        showSplashScreen();
    }

    /*
     * method to start new activity after 2 seconds
     * */
    public void showSplashScreen() {
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}
