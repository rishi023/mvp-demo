package com.mvp.prototype.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mvp.prototype.DemoApp;
import com.mvp.prototype.injection.component.ActivityComponent;
import com.mvp.prototype.injection.component.DaggerActivityComponent;
import com.mvp.prototype.injection.module.ActivityModule;

public class BaseActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApp.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }

}
