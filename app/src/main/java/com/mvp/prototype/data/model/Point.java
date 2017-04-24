package com.mvp.prototype.data.model;

import com.google.gson.annotations.SerializedName;


public class Point {
    @SerializedName("lat")
    private String latitude;
    @SerializedName("long")
    private String longitude;
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "{" +
                "lat='" + latitude + '\'' +
                ", long='" + longitude + '\'' +
                '}';
    }
}