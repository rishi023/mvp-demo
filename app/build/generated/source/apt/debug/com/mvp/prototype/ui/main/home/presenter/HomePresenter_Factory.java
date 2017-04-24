package com.mvp.prototype.ui.main.home.presenter;

import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class HomePresenter_Factory implements Factory<HomePresenter> {
  private final MembersInjector<HomePresenter> membersInjector;

  public HomePresenter_Factory(MembersInjector<HomePresenter> membersInjector) {  
    assert membersInjector != null;
    this.membersInjector = membersInjector;
  }

  @Override
  public HomePresenter get() {  
    HomePresenter instance = new HomePresenter();
    membersInjector.injectMembers(instance);
    return instance;
  }

  public static Factory<HomePresenter> create(MembersInjector<HomePresenter> membersInjector) {  
    return new HomePresenter_Factory(membersInjector);
  }
}

