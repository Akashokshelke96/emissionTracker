package com.example.springbootcrud.repository;

import com.example.springbootcrud.entity.City;
import com.example.springbootcrud.entity.District;
import com.example.springbootcrud.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer> {

   List<District> findByCity_CityId(Optional<City> cityId);

   @Query(value = "select district_id from district where city_id in(select city_id from  city where city_hall_id = 0?)",nativeQuery = true)
   List<District> findByCityHallId(Integer cityHallId);

}
