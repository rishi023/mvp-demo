package com.mvp.prototype.data.model;


import com.google.gson.annotations.SerializedName;


public class LocationResponse {

    @SerializedName("latlong")
    private Point point;

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}