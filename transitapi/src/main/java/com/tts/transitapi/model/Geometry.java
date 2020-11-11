package com.tts.transitapi.model;

public class Geometry {


    // used in the Geocoding model, sets up Location
    
    public Location location;

    public Geometry() {
    }

    

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Geometry [location=" + location + "]";
    }

  


    
}

