package com.example.springbootcrud.repository;

import com.example.springbootcrud.entity.City;
import com.example.springbootcrud.entity.Reading;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Integer> {


    List<City> findByCityHall_CityHallId(Integer cityHallId);
}
