

package com.mvp.prototype.injection.component;


import android.app.Application;
import android.content.Context;

import com.mvp.prototype.DemoApp;
import com.mvp.prototype.data.remote.LocationApi;
import com.mvp.prototype.injection.ApplicationContext;
import com.mvp.prototype.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules =
        {
                ApplicationModule.class
        }
)
public interface ApplicationComponent {

    void inject(DemoApp demoApp);

    @ApplicationContext
    Context context();

    Application application();

    LocationApi locationApi();

}
