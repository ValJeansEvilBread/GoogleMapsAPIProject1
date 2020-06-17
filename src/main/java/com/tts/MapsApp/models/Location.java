package com.tts.MapsApp.models;

import lombok.Data;

@Data
public class Location {
    public String city;
    private String state;
    private String lat;
    private String lng;
}
