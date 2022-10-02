package com.example.springbootcrud.requests;

import com.example.springbootcrud.entity.Sensor;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class ReadingRequest {

    private static final long serialVersionUID = 1L;


    @JsonProperty(value = "reading_time")
    private LocalDateTime readingTime;

    @JsonProperty(value = "value")
    private Double value;


    @JsonProperty(value = "sensor_id")
    private Sensor sensor;

}
