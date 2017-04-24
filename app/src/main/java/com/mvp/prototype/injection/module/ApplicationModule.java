
package com.mvp.prototype.injection.module;

import android.app.Application;
import android.content.Context;

import com.mvp.prototype.data.remote.LocationApi;
import com.mvp.prototype.data.remote.LocationApiService;
import com.mvp.prototype.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies. Mainly singleton object that can be injected from
 * anywhere in the app.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    LocationApi provideLocationApi() {
        return LocationApiService.getLocationApi();
    }



}
