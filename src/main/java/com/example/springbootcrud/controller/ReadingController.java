package com.example.springbootcrud.controller;

import com.example.springbootcrud.exception.ReadingException;
import com.example.springbootcrud.requests.ReadingRequest;
import com.example.springbootcrud.response.ReadingResponse;
import com.example.springbootcrud.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReadingController {
    //get reading by ReadingId,sensorId,by districtId, Date time save,
    //between two date time co2 data
    //by city id and by cityhall id

     @Autowired
     ReadingService readingService;

    @GetMapping("/district/readings")
    public ResponseEntity<List<ReadingResponse>> getAllReadings(){
        return readingService.getAllReadings();
    }

    @GetMapping("/district/readings/{sensorId}")
    public ResponseEntity<List<ReadingResponse>> getReadingsBySensorId(@PathVariable(value = "sensorId") Integer sensorId) throws ReadingException {
        return ResponseEntity.ok(readingService.getReadingsBySensorId(sensorId));
    }

    @GetMapping("/{districtId}/readings")
    public ResponseEntity<ResponseEntity<List<ReadingResponse>>> getReadingsByDistrictId(@PathVariable(value = "districtId") Integer districtId) throws ReadingException {
        return ResponseEntity.ok(readingService.getReadingsByDistrictId(districtId));
    }



    @DeleteMapping("/district/{sensorId}/reading")
    public String deleteReadingBySensorId(@PathVariable(value = "sensorId") Integer sensorId){
        return readingService.deleteReadingBySensorId(sensorId);
    }


    @DeleteMapping("/district/sensor/reading/{readingId}")
    public String deleteReadingByReadingId(@PathVariable(value = "readingId") Integer readingId) {
        return readingService.deleteReadingByReadingId(readingId);

    }

    @PostMapping("/district/reading")
    public ResponseEntity<ReadingResponse> createReading(@Valid @RequestBody ReadingRequest readingRequest) throws ReadingException {
        return ResponseEntity.ok( readingService.createNewReading(readingRequest));
    }

    }
