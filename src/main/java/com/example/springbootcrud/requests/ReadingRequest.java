package com.example.springbootcrud.requests;

import com.example.springbootcrud.entity.Sensor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadingRequest implements Serializable {

    private static final long serialVersionUID = 1L;


    @JsonProperty(value = "reading_time")
    private LocalDateTime readingTime;

    @JsonProperty(value = "value")
    private Double value;

    @JsonProperty(value = "sensor_id")
    private Integer sensorId;

}
