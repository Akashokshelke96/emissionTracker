package com.example.springbootcrud.requests;

import com.example.springbootcrud.entity.CityHall;
import com.example.springbootcrud.entity.District;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty(value= "cityId")
    private Integer cityId;

    @JsonProperty(value ="cityName")
    private String cityName;

    @JsonProperty(value ="cityZip")
    private String cityZip;

    @JsonProperty(value = "cityHallId")
    private Integer cityHallId;

    @JsonProperty(value = "districtList")
    private List<District> districtList;

    @JsonProperty(value = "cities")
    private String cities;
}
