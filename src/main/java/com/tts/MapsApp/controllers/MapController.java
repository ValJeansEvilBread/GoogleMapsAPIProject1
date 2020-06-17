package com.tts.MapsApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.MapsApp.models.Location;
import com.tts.MapsApp.service.MapService;

@Controller
public class MapController {
	
	@Autowired
	MapService mapService;
	
	@GetMapping("/home")
	public String getDefaultMap(Model model) {
	    model.addAttribute(new Location());
	    return "index.html";
	}
	
	@PostMapping("/home")
	public String getMapForLocation(Location location, Model model) {
	    mapService.addCoordinates(location);
	    model.addAttribute(location);
	    return "index.html";
	}
	
	@PostMapping("/random")
	public String random(Location location, Model model) {
		
		mapService.randomCoordinates(location);
		model.addAttribute(location);
		return "index.html";
	}

	
    
}
