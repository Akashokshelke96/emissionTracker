package com.example.springbootcrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="city_id")
    private Integer cityId;

    @Column(name = "city_name")
    @NotNull
    private String cityName;

    @Column(name ="city_zip" )
    @NotNull
    private String cityZip;

    @ManyToOne(fetch = FetchType.LAZY,optional = true)
    @JsonIgnore
    @NotNull
    @JoinColumn(name = "city_hall_id")
    private CityHall cityHall;

    @LazyCollection(LazyCollectionOption.FALSE)
    @NotNull
    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL,fetch  =FetchType.EAGER)
    private List<District> districtList;


}
