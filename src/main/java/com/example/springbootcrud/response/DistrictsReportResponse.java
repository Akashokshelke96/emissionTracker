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
public class DistrictsReportResponse {

    private Integer districtId;
    private  String districtName;
    private  double districtAverage;
    private  double districtMax;
    private  double districtMin;
    private Long noOfSensors;
    private List<SensorReportResponse> sensors;


}
