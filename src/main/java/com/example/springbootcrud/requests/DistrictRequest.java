package com.example.springbootcrud.requests;

import com.example.springbootcrud.entity.City;
import com.example.springbootcrud.entity.Sensor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DistrictRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty(value = "districtId")
    private Integer districtId;

    @JsonProperty(value = "districtName")
    private String districtName;


    @JsonProperty(value =  "districtZip")
    private String districtZip;

    @JsonProperty(value =  "cityId")
    private Integer cityId;

}
