package com.example.springbootcrud.repository;

import com.example.springbootcrud.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReadingRepository extends JpaRepository<Reading,Integer> {
/*    @Query(value = "SELECT * from reading r where r.sensor_id = 0?", nativeQuery = true)
    List<Reading> getReadingsBySensorId(Integer sensorId);*/

    List<Reading> findBySensor_sensorId(Integer sensorId);

    @Query(value="select * from reading r where sensor_id in (select sensor_id from sensor where district_id = 0?)", nativeQuery = true)
    List<Reading> findByDistrictId(Integer districtId);

   }
