package com.tts.MapsApp.models;

import java.util.List;

import lombok.Data;

@Data
public class GeocodingResponse {
    private List<Geocoding> results;
}