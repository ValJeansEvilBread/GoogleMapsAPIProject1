package com.tts.MapsApp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tts.MapsApp.models.GeocodingResponse;
import com.tts.MapsApp.models.Location;

@Service
public class MapService {
	
    @Value("${api_key}")
    private String apiKey;

    public void addCoordinates(Location location) {
    	
    	try {
    	
	    	String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + 
	    		    location.getCity() + "," + location.getState() + "&key=" + apiKey;
	    	
	    	RestTemplate restTemplate = new RestTemplate();
	    	GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
	    	Location coordinates = response.getResults().get(0).getGeometry().getLocation();
	    	
	    	location.setLat(coordinates.getLat());
	    	location.setLng(coordinates.getLng());
	    	
    	} catch(Exception ex) {
    		location.setLat("42.434722");
    		location.setLng("-83.985");
    		location.setCity("Hell");
    		location.setState("Michigan.  An error occured and you were sent here automatically. Try again.");
    	}
    	
    }
    
    public void randomCoordinates(Location location) {

    	try {
    	
			String randomLat = Double.toString((Math.random() * (90 - -90)) + -90);
			String randomLng = Double.toString((Math.random() * (180 - -180)) + -180);
			location.setLat(randomLat);
			location.setLng(randomLng);
			
			String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + 
	    		    location.getLat() + "," + location.getLng() + "&key=" + apiKey;
	    	
	    	RestTemplate restTemplate = new RestTemplate();
	    	GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
	    	Location coordinates = response.getResults().get(0).getGeometry().getLocation();
	    	
	    	location.setCity(coordinates.getCity());
	    	location.setState(coordinates.getState());
    	} catch(Exception ex) {
    		location.setLat("42.434722");
    		location.setLng("-83.985");
    		location.setCity("Hell");
    		location.setState("Michigan. An error occured and you were sent here automatically. Try again.");
    	}
    }
    
}