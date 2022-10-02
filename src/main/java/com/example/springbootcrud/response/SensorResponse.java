package com.example.springbootcrud.response;

import com.example.springbootcrud.entity.District;
import com.example.springbootcrud.entity.Reading;
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
public class SensorResponse implements Serializable {
    @JsonProperty(value =  "sensorId")
    private Integer sensorId;

    @JsonProperty(value =  "sensorName")
    private String sensorName;

    @JsonProperty(value =  "districtId")
    private Integer districtId;

    @JsonProperty(value = "readingIdList")
    private List<Integer>  readingIdList;
}
