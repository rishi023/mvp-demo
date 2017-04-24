package com.mvp.prototype.injection.component;

import android.app.Application;
import android.content.Context;
import com.mvp.prototype.DemoApp;
import com.mvp.prototype.data.remote.LocationApi;
import com.mvp.prototype.injection.module.ApplicationModule;
import com.mvp.prototype.injection.module.ApplicationModule_ProvideApplicationFactory;
import com.mvp.prototype.injection.module.ApplicationModule_ProvideContextFactory;
import com.mvp.prototype.injection.module.ApplicationModule_ProvideLocationApiFactory;
import dagger.internal.MembersInjectors;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerApplicationComponent implements ApplicationComponent {
  private Provider<Context> provideContextProvider;
  private Provider<Application> provideApplicationProvider;
  private Provider<LocationApi> provideLocationApiProvider;

  private DaggerApplicationComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.provideContextProvider = ApplicationModule_ProvideContextFactory.create(builder.applicationModule);
    this.provideApplicationProvider = ApplicationModule_ProvideApplicationFactory.create(builder.applicationModule);
    this.provideLocationApiProvider = ScopedProvider.create(ApplicationModule_ProvideLocationApiFactory.create(builder.applicationModule));
  }

  @Override
  public void inject(DemoApp demoApp) {  
    MembersInjectors.noOp().injectMembers(demoApp);
  }

  @Override
  public Context context() {  
    return provideContextProvider.get();
  }

  @Override
  public Application application() {  
    return provideApplicationProvider.get();
  }

  @Override
  public LocationApi locationApi() {  
    return provideLocationApiProvider.get();
  }

  public static final class Builder {
    private ApplicationModule applicationModule;
  
    private Builder() {  
    }
  
    public ApplicationComponent build() {  
      if (applicationModule == null) {
        throw new IllegalStateException("applicationModule must be set");
      }
      return new DaggerApplicationComponent(this);
    }
  
    public Builder applicationModule(ApplicationModule applicationModule) {  
      if (applicationModule == null) {
        throw new NullPointerException("applicationModule");
      }
      this.applicationModule = applicationModule;
      return this;
    }
  }
}

