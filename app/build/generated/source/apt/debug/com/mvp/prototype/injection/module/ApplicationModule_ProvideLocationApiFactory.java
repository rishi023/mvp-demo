package com.mvp.prototype.injection.module;

import com.mvp.prototype.data.remote.LocationApi;
import dagger.internal.Factory;
import javax.annotation.Generated;

@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ApplicationModule_ProvideLocationApiFactory implements Factory<LocationApi> {
  private final ApplicationModule module;

  public ApplicationModule_ProvideLocationApiFactory(ApplicationModule module) {  
    assert module != null;
    this.module = module;
  }

  @Override
  public LocationApi get() {  
    LocationApi provided = module.provideLocationApi();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<LocationApi> create(ApplicationModule module) {  
    return new ApplicationModule_ProvideLocationApiFactory(module);
  }
}

