package com.example.springbootcrud.controller;


import com.example.springbootcrud.entity.Sensor;
import com.example.springbootcrud.exception.SensorException;
import com.example.springbootcrud.requests.SensorRequest;
import com.example.springbootcrud.response.SensorResponse;
import com.example.springbootcrud.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class SensorController {

    @Autowired
    SensorService sensorService;

    @GetMapping("/district/sensor")
    public List<Sensor> getAllSensors(){
        return sensorService.getAllSensors();
    }

    @GetMapping("/district/sensor/{sensorId}")
    public Optional<Sensor> getSenorBySensorId(@PathVariable(value = "sensorId") Integer sensorId){
        return sensorService.getSensorById(sensorId);
    }

    @DeleteMapping("/district/sensor/{sensorId}")
    public String deleteSensorById(@PathVariable(value = "sensorId") Integer sensorId){
        return sensorService.deleteSensorById(sensorId);
    }

    @PostMapping("/district/sensor/")
    public ResponseEntity<SensorResponse> createSensor(@Valid  @RequestBody SensorRequest sensorRequest) throws SensorException {
        return ResponseEntity.ok( sensorService.createNewSensor(sensorRequest));
    }

    @PutMapping("/district/sensor/{sensorId}")
    public ResponseEntity<SensorResponse> updateSensor(@Valid @RequestBody SensorRequest sensorRequest, @PathVariable Integer sensorId) throws SensorException {
        return ResponseEntity.ok(sensorService.updateSensor(sensorRequest,sensorId));
    }

}
