package com.example.springbootcrud.repository;

import com.example.springbootcrud.entity.Reading;
import com.example.springbootcrud.response.ReadingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingRepository extends JpaRepository<Reading,Integer> {
    List<Reading> findBySensorId(Integer sensorId);
}
