package com.example.springbootcrud.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
@Table(name = "city_hall")
public class CityHall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_hall_Id")
    private Integer cityHallId;

    @Column(name = "city_hall_name")
    private String cityHallName;

    @Column(name = "city_hall_location")
    private String cityHallLocation;

    @Column(name="city_hall_address")
    private String cityHallAddress;

    @Column(name = "active")
    private boolean active;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update")
    private Date lastUpdate;


    @Column(name = "email")
    private String email;

    @Column(name = "cities")
    private String cities;

    @OneToMany(mappedBy = "cityHall", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<City> cityList;
}
