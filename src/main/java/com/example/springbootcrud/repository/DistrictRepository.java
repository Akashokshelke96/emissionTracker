package com.example.springbootcrud.repository;

import com.example.springbootcrud.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Integer> {


}
