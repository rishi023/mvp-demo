package com.mvp.prototype.data.remote;

import com.mvp.prototype.data.model.LocationResponse;

import retrofit.Callback;
import retrofit.http.GET;


public interface LocationApi {
    @GET("/assignmentapi/v1/index")
    public void getLocation( Callback<LocationResponse> callback);
}
