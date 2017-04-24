package com.mvp.prototype;

import android.app.Application;
import android.content.Context;

import com.mvp.prototype.injection.component.ApplicationComponent;
import com.mvp.prototype.injection.component.DaggerApplicationComponent;
import com.mvp.prototype.injection.module.ApplicationModule;

import java.util.Locale;


public class DemoApp extends Application {
    private ApplicationComponent mApplicationComponent;
    private Locale locale = null;
    private static Context mContext;

    public static DemoApp get(Context context) {
        return (DemoApp) context.getApplicationContext();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }
    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public static Context getContext() {
        return mContext;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }


}
