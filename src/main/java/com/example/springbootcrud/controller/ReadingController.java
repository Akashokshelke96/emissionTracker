package com.example.springbootcrud.controller;

import com.example.springbootcrud.exception.ReadingException;
import com.example.springbootcrud.requests.ReadingRequest;
import com.example.springbootcrud.response.ReadingResponse;
import com.example.springbootcrud.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ReadingController {
    //get reading by ReadingId,sensorId,by districtId,//by city id and by cityhall id
    //between two date time co2 data, By date


     @Autowired
     ReadingService readingService;

    //Get all Readings
    @GetMapping("/district/readings")
    public ResponseEntity<List<ReadingResponse>> getAllReadings(){
        return ResponseEntity.ok(readingService.getAllReadings());
    }

    //Get Readings by Sensor Id
    @GetMapping("/readings/sensor/{sensorId}")
    public ResponseEntity<List<ReadingResponse>> getReadingsBySensorId(@PathVariable(value = "sensorId") Integer sensorId) throws ReadingException {
        return ResponseEntity.ok(readingService.getReadingsBySensorId(sensorId));
    }

    //Get Readings by District Id
    @GetMapping("/readings/district/{districtId}")
    public ResponseEntity<List<ReadingResponse>> getReadingsByDistrictId(@PathVariable(value = "districtId") Integer districtId) throws ReadingException {
        return ResponseEntity.ok(readingService.getReadingsByDistrictId(districtId));
    }

    //Get Readings by city Id
    @GetMapping("/readings/city/{cityId}")
    public ResponseEntity<List<ReadingResponse>> getReadingsByCityId(@PathVariable(value = "cityId") Integer cityId) throws ReadingException {
        return ResponseEntity.ok(readingService.getReadingsByCityId(cityId));
    }

    //Get Readings by City Hall Id
    @GetMapping("/readings/cityHall/{cityHallId}")
    public ResponseEntity<List<ReadingResponse>> getReadingsByCityHallId(@PathVariable(value = "cityHallId") Integer cityHallId) throws ReadingException {
        return ResponseEntity.ok(readingService.getReadingsByCityHallId(cityHallId));
    }

    @GetMapping("/readings/fetch/{startDate}/{endDate}")
    public ResponseEntity<List<ReadingResponse>> getReadingsBetweenDates(@PathVariable(value = "startDate")String startDate, @PathVariable(value = "endDate") String endDate){
        return ResponseEntity.ok(readingService.getReadingsBetweenDates(startDate,endDate));
    }



    //Delete Readings by Sensor Id
    @DeleteMapping("/reading/sensor/{sensorId}")
    public ResponseEntity<String> deleteReadingBySensorId(@PathVariable(value = "sensorId") Integer sensorId){
        return ResponseEntity.ok(readingService.deleteReadingBySensorId(sensorId));
    }


    @DeleteMapping("reading/{readingId}")
    public ResponseEntity<String> deleteReadingByReadingId(@PathVariable(value = "readingId") Integer readingId) {
        return ResponseEntity.ok(readingService.deleteReadingByReadingId(readingId));

    }

    @PostMapping("/district/sensor/reading")
    public ResponseEntity<ReadingResponse> createReading(@Valid @RequestBody ReadingRequest readingRequest) throws ReadingException {
        return ResponseEntity.ok( readingService.createNewReading(readingRequest));
    }

    }
