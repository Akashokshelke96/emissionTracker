package com.example.springbootcrud.response;

import com.example.springbootcrud.entity.Sensor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
public class ReadingResponse implements Serializable {


    @JsonProperty(value ="readingId")
    private Integer readingId;


    @JsonProperty(value = "readingTime")
    private LocalDateTime readingTime;

    @JsonProperty(value = "value")
    private Double value;

    @JsonProperty(value = "date")
    private String date;

    @JsonProperty(value = "sensorId")
    private Integer sensorId;

}
