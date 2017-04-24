

package com.mvp.prototype.ui.main.home.presenter;


import com.mvp.prototype.data.model.LocationResponse;
import com.mvp.prototype.data.remote.LocationApi;
import com.mvp.prototype.ui.base.Presenter;
import com.mvp.prototype.ui.main.home.view.HomeView;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class HomePresenter implements Presenter<HomeView> {
    HomeView homeView;

    @Inject
    LocationApi locationApi;

    @Inject
    public HomePresenter() {
    }
    @Override
    public void attachView(HomeView mvpView) {
        this.homeView = mvpView;
    }
    public void getLocation(){
        locationApi.getLocation(new Callback<LocationResponse>() {
            @Override
            public void success(LocationResponse locationResponse, Response response) {
                homeView.onSuccess(locationResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                homeView.onFailure(error);
            }
        });
    }


    @Override
    public void detachView() {
        this.homeView = null;
    }
}
