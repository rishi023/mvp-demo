package com.mvp.prototype.ui.main.home.view;

import com.mvp.prototype.ui.base.BaseActivity;
import com.mvp.prototype.ui.main.home.presenter.HomePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HomeActivity_MembersInjector implements MembersInjector<HomeActivity> {
  private final MembersInjector<BaseActivity> supertypeInjector;
  private final Provider<HomePresenter> mHomePresenterProvider;

  public HomeActivity_MembersInjector(MembersInjector<BaseActivity> supertypeInjector, Provider<HomePresenter> mHomePresenterProvider) {  
    assert supertypeInjector != null;
    this.supertypeInjector = supertypeInjector;
    assert mHomePresenterProvider != null;
    this.mHomePresenterProvider = mHomePresenterProvider;
  }

  @Override
  public void injectMembers(HomeActivity instance) {  
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    supertypeInjector.injectMembers(instance);
    instance.mHomePresenter = mHomePresenterProvider.get();
  }

  public static MembersInjector<HomeActivity> create(MembersInjector<BaseActivity> supertypeInjector, Provider<HomePresenter> mHomePresenterProvider) {  
      return new HomeActivity_MembersInjector(supertypeInjector, mHomePresenterProvider);
  }
}

