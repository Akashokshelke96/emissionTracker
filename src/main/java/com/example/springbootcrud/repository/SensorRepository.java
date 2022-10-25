package com.example.springbootcrud.repository;

import com.example.springbootcrud.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,Integer> {

    @Query(value = "select sensor_id from sensor where district_id in(select district_id from district where city_id in(select city_id from  city where city_hall_id = 0?)); ",nativeQuery = true)
    List<Sensor> findByCityHallId(Integer cityHallId);

    List<Sensor> findByDistrict_districtId(Integer cityId);
}
