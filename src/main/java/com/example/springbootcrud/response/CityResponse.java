package com.example.springbootcrud.response;

import com.example.springbootcrud.entity.CityHall;
import com.example.springbootcrud.entity.District;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Component
public class CityResponse implements Serializable {


    @JsonProperty(value ="city_id")
    private Integer cityId;

    @JsonProperty(value = "city_name")
    private String cityName;

    @JsonProperty(value = "city_zip" )
    private String cityZip;

    @JsonProperty(value ="city_hall_id")
    private Integer cityHallId;

   @JsonProperty(value ="district_list")
    private List<District> districtList;
}
