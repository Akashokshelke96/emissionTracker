package com.example.springbootcrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Integer districtId;



    @Column(name = "district_name")
    private String districtName;


    @Column(name = "zip")
    private String districtZip;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JsonIgnore
    @JoinColumn(name = "city_id")
    private City city;


    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy="district",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Sensor> sensorList;
}
