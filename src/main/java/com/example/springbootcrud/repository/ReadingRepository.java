package com.example.springbootcrud.repository;

import com.example.springbootcrud.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ReadingRepository extends JpaRepository<Reading, Integer> {
/*    @Query(value = "SELECT * from reading r where r.sensor_id = 0?", nativeQuery = true)
    List<Reading> getReadingsBySensorId(Integer sensorId);*/

    List<Reading> findBySensor_sensorId(Integer sensorId);

    @Query(value = "select * from reading r where sensor_id in (select sensor_id from sensor where district_id = 0?)", nativeQuery = true)
    List<Reading> findByDistrictId(Integer districtId);

    @Query(value = "select * from reading r where r.sensor_id in (select sensor_id from sensor s where s.district_id in(select district_id from district d where d.city_id = 0?)) ", nativeQuery = true)
    List<Reading> findByCityId(Integer cityId);

    @Query(value = "select * from reading where sensor_id in (select sensor_id from sensor where district_id in(select district_id from district where city_id in(select city_id from  city where city_hall_id = 0?))); ", nativeQuery = true)
    List<Reading> findByCityHallId(Integer cityHallId);

    @Query(value = "select reading_value from reading where sensor_id in (select sensor_id from sensor where district_id in(select district_id from district where city_id in(select city_id from  city where city_hall_id = 0?))); ", nativeQuery = true)
    List<Double> findReadingsByCityHallId(Integer cityHallId);

    @Query(value = "SELECT * FROM reading r WHERE  r.reading_time BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Reading> getReadingsBetweenDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


    @Query(value = "select * from reading r where sensor_id in (select sensor_id from sensor where district_id in(select district_id from district where city_id in(select city_id from  city where city_hall_id = :cityHallId))) and reading_time between :startDate and :endDate", nativeQuery = true)
    List<Reading> getCityHallIdBetweenDates(@Param("cityHallId") Integer cityHallId, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);


   /* @Query(value = "select max(value) from reading r where sensor_id in (select sensor_id from sensor where district_id in(select district_id from district where city_id in(select city_id from  city where city_hall_id = :cityHallId))) and reading_time between :startDate and :endDate", nativeQuery = true)
    double findMaxReadingByCityHallIdBetweenDates(Integer cityHallId, LocalDate fromDate, LocalDate toDate);*/
}

//    (@Param("startDate") LocalDate date, @Param("endDate") LocalDate date2
//    List<CourierInfo> getData_between(@Param("startDate") LocalDate date, @Param("endDate") LocalDate date2);
//
