package com.example.springbootcrud.response;

import com.example.springbootcrud.entity.City;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class CityHallResponse implements Serializable {

    @JsonProperty(value= "city_hall_Id")
    private Integer cityHallId;

    @JsonProperty(value ="city_hall_name")
    private String cityHallName;

    @JsonProperty(value ="city_hall_location")
    private String cityHallLocation;

    @JsonProperty(value = "city_hall_address")
    private String cityHallAddress;

    @Column(name = "active")
    @JsonIgnore
    private boolean active;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(value = "create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty(value = "last update")
    private Date lastUpdate;


    @Column(name = "email")
    private String email;

    @JsonProperty(value = "cities")
    private String cities;


    private List<City> cityList;
}
