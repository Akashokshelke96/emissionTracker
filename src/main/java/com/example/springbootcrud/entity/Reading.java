package com.example.springbootcrud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "reading")
public class Reading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer readingId;


    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:SS")
    @Column(name = "reading_time")
    private String readingTime;

    @Column(name = "value")
    private Double value;

    @Column(name = "date")
    private String date;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JsonIgnore
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JsonIgnore
    @JoinColumn(name = "district_id")
    private District district;

}
