package com.example.springbootcrud.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityReportResponse {
    private Integer cityId;
    private String cityName;
    private  double cityAverage;
    private  double cityMax;
    private double cityMin;
    private long numberOfSensors;
    private long numberOfDistricts;
    private List<DistrictReportResponse> districts;



}
