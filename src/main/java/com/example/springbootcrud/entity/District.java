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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Integer districtId;


    @Column(name = "district_name")
    private String districtName;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JsonIgnore
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "zip")
    private String districtZip;



    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="district",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @Column(name = "sensor_list")
    private List<Sensor> sensorList;
}
