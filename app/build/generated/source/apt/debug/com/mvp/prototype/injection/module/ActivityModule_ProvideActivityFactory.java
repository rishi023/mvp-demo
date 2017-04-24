package com.mvp.prototype.injection.module;

import android.app.Activity;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ActivityModule_ProvideActivityFactory implements Factory<Activity> {
  private final ActivityModule module;

  public ActivityModule_ProvideActivityFactory(ActivityModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Activity get() {  
    Activity provided = module.provideActivity();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Activity> create(ActivityModule module) {  
    return new ActivityModule_ProvideActivityFactory(module);
  }
}

