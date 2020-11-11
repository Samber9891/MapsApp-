package com.tts.transitapi.model;

public class BusRequest {
    
// used on the front end form

    public String address; 
    public String city;

    public BusRequest() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "BusRequest [address=" + address + ", city=" + city + "]";
    }

   
    
}
