package com.example.springbootcrud.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorReportResponse {
    private Integer sensorId;
    private String sensorName;
    private double sensorAverage;
    private double sensorMax;
    private double sensorMin;

}
