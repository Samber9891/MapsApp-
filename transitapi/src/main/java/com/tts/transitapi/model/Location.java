package com.tts.transitapi.model;

public class Location {
    

    // used in the Geometry model, sets up latitude and longitude
    public String lat; 
    public String lng;

    public Location() {
    }


    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "Location [lat=" + lat + ", lng=" + lng + "]";
    }

    
}
