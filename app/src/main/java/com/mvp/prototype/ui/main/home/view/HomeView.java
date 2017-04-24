package com.mvp.prototype.ui.main.home.view;


import com.mvp.prototype.data.model.LocationResponse;
import com.mvp.prototype.ui.base.MvpView;

import retrofit.RetrofitError;


public interface HomeView extends MvpView {


    void onSuccess(LocationResponse locationResponse);

    void onFailure(RetrofitError error);
}
