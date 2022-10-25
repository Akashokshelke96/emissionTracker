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
   List<District> findByCity_cityId(Integer cityId);


}
