package com.mvp.prototype.ui.main.splash.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mvp.prototype.Constants;
import com.mvp.prototype.R;
import com.mvp.prototype.ui.base.BaseActivity;
import com.mvp.prototype.ui.main.home.view.HomeActivity;


public class SplashActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        /* New Handler to start the HomeActivity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the HomeActivity. */
                Intent mainIntent = new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, Constants.SPLASH_DISPLAY_LENGTH);
    }}
