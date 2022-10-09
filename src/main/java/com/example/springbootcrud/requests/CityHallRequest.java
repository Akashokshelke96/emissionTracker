package com.example.springbootcrud.requests;

import com.example.springbootcrud.entity.City;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class CityHallRequest implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        @JsonProperty(value= "cityHallId")
        private Integer cityHallId;

        @JsonProperty(value ="cityHallName")
        private String cityHallName;

        @JsonProperty(value ="cityHallLocation")
        private String cityHallLocation;

        @JsonProperty(value = "cityHallAddress")
        private String cityHallAddress;

        @JsonProperty(value =  "active")
        private boolean active;

        @JsonProperty(value = "createDate")
        private Date createDate;

        @JsonProperty(value = "lastUpdate")
        private Date lastUpdate;

        @JsonProperty(value =  "email")
        private String email;

        @JsonProperty(value = "cities")
        private String cities;

    }
