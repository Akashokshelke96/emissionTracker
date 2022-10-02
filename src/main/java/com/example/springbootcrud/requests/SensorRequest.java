package com.example.springbootcrud.requests;

import com.example.springbootcrud.entity.District;
import com.example.springbootcrud.entity.Reading;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorRequest implements Serializable{
    private static final long serialVersionUID = 1L;


    @JsonProperty(value =  "sensorName")
    private String sensorName;

    @JsonProperty(value =  "districtId")
    private Integer districtId;


}
