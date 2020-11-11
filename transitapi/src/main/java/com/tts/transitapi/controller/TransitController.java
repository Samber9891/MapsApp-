package com.tts.transitapi.controller;

import java.util.List;

import com.tts.transitapi.model.Bus;
import com.tts.transitapi.model.BusRequest;
import com.tts.transitapi.service.TransitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransitController {
    
    @Autowired
    TransitService transitService; 

    // GETS the index page
    @GetMapping("/buses") 
    public String getBusesPage(Model model){
        model.addAttribute("request", new BusRequest()); 
    return "index"; 
    }

    // POST the nearby buses on the google map
    @PostMapping("/buses")
    public String getNearbyBuses(BusRequest request, Model model){

        List<Bus> buses = transitService.getNearbyBuses(request);

        model.addAttribute("buses", buses); 
        model.addAttribute("request", request);

        return "index"; 

    }

}
