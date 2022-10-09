package com.example.springbootcrud.service;

import com.example.springbootcrud.exception.ReadingException;
import com.example.springbootcrud.requests.ReadingRequest;
import com.example.springbootcrud.response.ReadingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface ReadingService {
    //get reading by ReadingId,sensorId,by districtId, Date time save,
    //between two date time co2 data
    //by city id and by cityhall id
    List<ReadingResponse> getAllReadings();

    List<ReadingResponse> getReadingsBySensorId(Integer sensorId) throws ReadingException;

    String deleteReadingBySensorId(Integer sensorId);

    String deleteReadingByReadingId(Integer readingId);

    ReadingResponse createNewReading(ReadingRequest readingRequest) throws ReadingException;

    ReadingResponse updateSensorReading(ReadingRequest readingRequest, Integer readingId) throws ReadingException;
    ReadingResponse getReadingByReadingId(Integer readingId) throws ReadingException;


    List<ReadingResponse> getReadingsByDistrictId(Integer districtId);

    List<ReadingResponse> getReadingsByCityId(Integer cityId);

    List<ReadingResponse> getReadingsByCityHallId(Integer cityHallId);

    List<ReadingResponse> getReadingsBetweenDates(String startDate, String endDate);
}
