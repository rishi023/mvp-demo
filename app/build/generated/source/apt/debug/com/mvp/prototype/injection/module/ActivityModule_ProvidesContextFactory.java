package com.mvp.prototype.injection.module;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ActivityModule_ProvidesContextFactory implements Factory<Context> {
  private final ActivityModule module;

  public ActivityModule_ProvidesContextFactory(ActivityModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public Context get() {  
    Context provided = module.providesContext();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<Context> create(ActivityModule module) {  
    return new ActivityModule_ProvidesContextFactory(module);
  }
}

