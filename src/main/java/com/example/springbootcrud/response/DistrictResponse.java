package com.example.springbootcrud.response;

import com.example.springbootcrud.entity.City;
import com.example.springbootcrud.entity.Sensor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Component
public class DistrictResponse implements Serializable {
    @JsonProperty(value = "district_id")
    private Integer districtId;



    @JsonProperty(value = "district_name")
    private String districtName;


    @JsonProperty(value =  "districtZip")
    private String districtZip;

    @JsonProperty(value =  "cityId")
    private Integer cityId;


    @JsonProperty(value = "sensorList")
    private List<Sensor> sensorList;
}
