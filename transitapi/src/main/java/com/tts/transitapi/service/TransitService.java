package com.tts.transitapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.tts.transitapi.model.Bus;
import com.tts.transitapi.model.BusComparator;
import com.tts.transitapi.model.BusRequest;
import com.tts.transitapi.model.DistanceResponse;
import com.tts.transitapi.model.GeocodingResponse;
import com.tts.transitapi.model.Location;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransitService {

// imports the values from apllication.properties
    @Value("${transit_url}")
    public String transitUrl;
	
    @Value("${geocoding_url}")
    public String geocodingUrl;
	
    @Value("${distance_url}")
    public String distanceUrl;
	
    @Value("${api_key}")
    public String googleApiKey; 

    // runs through the MARTA api and returns the results
    private List<Bus> getBuses() {
        
        RestTemplate restTemplate = new RestTemplate(); 
        Bus[] buses = restTemplate.getForObject(transitUrl, Bus[].class); 
        return Arrays.asList(buses); 
    }

    // calls to Geocoding api by building the url and returning a response
    private Location getCoordinates(String description) {

        description = description.replace(" ", "+"); 
        String url = geocodingUrl + description + "GA&key=" + googleApiKey; 
        System.out.println(url);
        RestTemplate restTemplate = new RestTemplate(); 
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class); 

        return response.results.get(0).geometry.location; 
    }

    // uses Distance Matrix api to find the distance between two corrdinates

    private double getDistance(Location origin, Location destination) {

        // tells the api what informatin we want to get back
        String url= distanceUrl + "origins=" + origin.lat + "," + origin.lng  + "&destinations=" + destination.lat + "," + destination.lng + "&key=" + googleApiKey;  

        System.out.println("\nGet distance formatted URL: " + url);

        RestTemplate restTemplate = new RestTemplate(); 

        DistanceResponse response = restTemplate.getForObject(url, DistanceResponse.class); 

        System.out.println("Response from distance matrix: " + response);
// converts the distance to miles
        return (response.rows.get(0).elements.get(0).distance.value) * 0.000621371; 
    }
    

   // Brings in all the api calls
public List<Bus> getNearbyBuses(BusRequest request){
    // returns a list of all active buses 
    List<Bus> allBuses = this.getBuses();
    // gets the location of the user basedd on what they pass in through the request object
    Location personLocation = this.getCoordinates(request.address + " " + request.city);
    List<Bus> nearbyBuses = new ArrayList<>();
    // logic that determines (for each bus, determine whether or not it is close)
    for(Bus bus : allBuses) {
        Location busLocation = new Location();
        busLocation.lat = bus.LATITUDE;
        busLocation.lng = bus.LONGITUDE;
           //comparison between each bus and the user 
        double latDistance = Double.parseDouble(busLocation.lat) - Double.parseDouble(personLocation.lat);
        double lngDistance = Double.parseDouble(busLocation.lng) - Double.parseDouble(personLocation.lng);
        if (Math.abs(latDistance) <= 0.02 && Math.abs(lngDistance) <= 0.02) {
              //  checks to see if the distance is less than 1 mile 
            double distance = getDistance(busLocation, personLocation);
            if (distance <= 1) {
                bus.distance = (double) Math.round(distance * 100) / 100;
                nearbyBuses.add(bus);
            }
        }
    }
       // sorts the buses for display on the front end
    Collections.sort(nearbyBuses, new BusComparator());
    return nearbyBuses;
}
    
}
       



