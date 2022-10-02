package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.Reading;
import com.example.springbootcrud.exception.ReadingException;
import com.example.springbootcrud.requests.ReadingRequest;
import com.example.springbootcrud.response.ReadingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReadingService {
    //get reading by ReadingId,sensorId,by districtId, Date time save,
    //between two date time co2 data
    //by city id and by cityhall id

    List<ReadingResponse> getAllReadings();

    ResponseEntity<List<ReadingResponse>> getReadingBySensorId(Integer sensorId);

    String deleteReadingBySensorId(Integer sensorId);

    ReadingResponse createNewReading(ReadingRequest readingRequest) throws ReadingException;

    ReadingResponse updateSensorReading(ReadingRequest readingRequest, Integer readingId) throws ReadingException;
    ResponseEntity<ReadingResponse> getReadingByReadingId(Integer readingId) throws ReadingException;


}
