package com.mvp.prototype.common;


import com.mvp.prototype.data.model.LocationResponse;
import com.mvp.prototype.data.model.Point;

public class MockModel {
    public static LocationResponse getLatLong(){
        Point point = new Point();
        point.setLatitude("19.2742053");
        point.setLongitude("72.8788707");
        LocationResponse locationResponse = new LocationResponse();
        locationResponse.setPoint(point);
        return locationResponse;
    }
}
