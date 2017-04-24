

package com.mvp.prototype.injection.component;


import com.mvp.prototype.injection.PreActivity;
import com.mvp.prototype.injection.module.ActivityModule;
import com.mvp.prototype.ui.main.home.view.HomeActivity;

import dagger.Component;


@PreActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)

public interface ActivityComponent {

    void inject(HomeActivity homeActivity);





}
