package com.example.springbootcrud.repository;

import com.example.springbootcrud.entity.CityHall;
import com.example.springbootcrud.requests.CityHallRequest;
import com.example.springbootcrud.response.CityHallResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityHallRepository extends JpaRepository<CityHall,Integer> {

}
