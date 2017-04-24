package com.mvp.prototype.injection.component;

import com.mvp.prototype.data.remote.LocationApi;
import com.mvp.prototype.injection.module.ActivityModule;
import com.mvp.prototype.ui.main.home.presenter.HomePresenter;
import com.mvp.prototype.ui.main.home.presenter.HomePresenter_Factory;
import com.mvp.prototype.ui.main.home.presenter.HomePresenter_MembersInjector;
import com.mvp.prototype.ui.main.home.view.HomeActivity;
import com.mvp.prototype.ui.main.home.view.HomeActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class DaggerActivityComponent implements ActivityComponent {
  private Provider<LocationApi> locationApiProvider;
  private MembersInjector<HomePresenter> homePresenterMembersInjector;
  private Provider<HomePresenter> homePresenterProvider;
  private MembersInjector<HomeActivity> homeActivityMembersInjector;

  private DaggerActivityComponent(Builder builder) {  
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {  
    return new Builder();
  }

  private void initialize(final Builder builder) {  
    this.locationApiProvider = new Factory<LocationApi>() {
      private final ApplicationComponent applicationComponent = builder.applicationComponent;
      @Override public LocationApi get() {
        LocationApi provided = applicationComponent.locationApi();
        if (provided == null) {
          throw new NullPointerException("Cannot return null from a non-@Nullable component method");
        }
        return provided;
      }
    };
    this.homePresenterMembersInjector = HomePresenter_MembersInjector.create(locationApiProvider);
    this.homePresenterProvider = HomePresenter_Factory.create(homePresenterMembersInjector);
    this.homeActivityMembersInjector = HomeActivity_MembersInjector.create((MembersInjector) MembersInjectors.noOp(), homePresenterProvider);
  }

  @Override
  public void inject(HomeActivity homeActivity) {  
    homeActivityMembersInjector.injectMembers(homeActivity);
  }

  public static final class Builder {
    private ActivityModule activityModule;
    private ApplicationComponent applicationComponent;
  
    private Builder() {  
    }
  
    public ActivityComponent build() {  
      if (activityModule == null) {
        throw new IllegalStateException("activityModule must be set");
      }
      if (applicationComponent == null) {
        throw new IllegalStateException("applicationComponent must be set");
      }
      return new DaggerActivityComponent(this);
    }
  
    public Builder activityModule(ActivityModule activityModule) {  
      if (activityModule == null) {
        throw new NullPointerException("activityModule");
      }
      this.activityModule = activityModule;
      return this;
    }
  
    public Builder applicationComponent(ApplicationComponent applicationComponent) {  
      if (applicationComponent == null) {
        throw new NullPointerException("applicationComponent");
      }
      this.applicationComponent = applicationComponent;
      return this;
    }
  }
}

