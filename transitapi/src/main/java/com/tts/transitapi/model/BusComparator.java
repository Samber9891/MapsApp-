package com.tts.transitapi.model;

import java.util.Comparator;

public class BusComparator implements Comparator<Bus> {

    // tells Java how to comapre one bus to another during the sorting process 
    @Override 
    public int compare(Bus o1, Bus o2) {

        if (o1.distance < o2.distance) return -1;
        if (o1.distance > o2.distance) return 1;
        return 0;
    }
    
}
