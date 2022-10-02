package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.Sensor;
import com.example.springbootcrud.exception.SensorException;
import com.example.springbootcrud.requests.SensorRequest;
import com.example.springbootcrud.response.SensorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface SensorService {
    List<Sensor> getAllSensors();

    Optional<Sensor> getSensorById(Integer sensorId);

    String deleteSensorById(Integer sensorId);

    SensorResponse createNewSensor(SensorRequest sensorRequest) throws SensorException;

    SensorResponse updateSensor(SensorRequest sensorRequest, Integer sensorId) throws SensorException;

}
