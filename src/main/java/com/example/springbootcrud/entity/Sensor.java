package com.example.springbootcrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "sensor")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Integer sensorId;

    @Column(name = "sensor_Name")
    private String sensorName;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JsonIgnore
    @JoinColumn(name = "district_id")
    private District district;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "sensor" , cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Reading> readingList;

   }
