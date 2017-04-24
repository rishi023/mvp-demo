package com.mvp.prototype.ui.main.home.presenter;

import com.mvp.prototype.data.remote.LocationApi;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HomePresenter_MembersInjector implements MembersInjector<HomePresenter> {
  private final Provider<LocationApi> locationApiProvider;

  public HomePresenter_MembersInjector(Provider<LocationApi> locationApiProvider) {  
    assert locationApiProvider != null;
    this.locationApiProvider = locationApiProvider;
  }

  @Override
  public void injectMembers(HomePresenter instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.locationApi = locationApiProvider.get();
  }

  public static MembersInjector<HomePresenter> create(Provider<LocationApi> locationApiProvider) {  
      return new HomePresenter_MembersInjector(locationApiProvider);
  }
}

