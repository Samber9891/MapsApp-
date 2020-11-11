package com.tts.transitapi.model;

public class Geocoding {
    
    // used in the GeocodingResponse model sets up Geometry

    public Geometry geometry;

    
    public Geocoding() {
    }

    

    public Geocoding(Geometry geometry) {
        this.geometry = geometry;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    

    
}
