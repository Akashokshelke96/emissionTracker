package com.example.springbootcrud.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponse implements Serializable {

    @JsonProperty(value = "cityHallId")
    @NotNull
    private Integer cityHallId;

    @JsonProperty(value ="city_hall_name")
    private String cityHallName;

    @JsonProperty(value = "date")
    @NotNull
    private String date;

    @JsonProperty(value ="city_hall_average")
    private double cityHallAverage;

    @JsonProperty(value = "city_hall_max")
    private double cityHallMax;

    @JsonProperty(value = "city_hall_min")
    private double cityHallMin;

    @JsonProperty(value = "Cities")
    private List<CityReportResponse> cities;

//
//    private CityHallReportResponse cityHall;


}
