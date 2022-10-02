package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.Reading;
import com.example.springbootcrud.entity.Sensor;
import com.example.springbootcrud.exception.ReadingException;
import com.example.springbootcrud.repository.ReadingRepository;
import com.example.springbootcrud.repository.SensorRepository;
import com.example.springbootcrud.requests.ReadingRequest;
import com.example.springbootcrud.response.ReadingResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService{


    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    SensorRepository sensorRepository;

    @Override
    public List<ReadingResponse> getAllReadings() {
        return null;
    }

    @Override
    public ResponseEntity<ReadingResponse> getReadingByReadingId(Integer readingId) throws ReadingException {
        Optional<Reading> readingByReadingId = readingRepository.findById(readingId);
        if(readingByReadingId.isPresent()) {
            Reading reading= readingByReadingId.get();
            ReadingResponse readingResponse = new ReadingResponse();
            BeanUtils.copyProperties(reading, readingResponse);
            readingResponse.setSensorId(reading.getSensor().getSensorId());
            readingResponse.setDate(String.valueOf(LocalDateTime.now()));
            return ResponseEntity.ok(readingResponse);
        }
        else{
            throw new ReadingException("Invalid Reading Id");
        }
    }

    @Override
    public ResponseEntity<List<ReadingResponse>> getReadingBySensorId(Integer sensorId) {
        List<Reading> readingBySensorId = readingRepository.findBySensorId(sensorId);
        List<ReadingResponse> readingResponseBySensorId = new ArrayList<>();
        for(Reading reading:readingBySensorId){
            ReadingResponse readingResponse = new ReadingResponse();
            BeanUtils.copyProperties(reading,readingResponse);
            readingResponse.setSensorId(reading.getSensor().getSensorId());
            readingResponse.setDate(String.valueOf(LocalDateTime.now()));
            readingResponseBySensorId.add(readingResponse);
        }
        return ResponseEntity.ok(readingResponseBySensorId );
    }

    @Override
    public String deleteReadingBySensorId(Integer sensorId) {
        Optional<Sensor> sensor = sensorRepository.findById(sensorId);
        if(sensor.isPresent()){
            readingRepository.findById(sensorId);
        }
        return null;
    }

    @Override
    public ReadingResponse createNewReading(ReadingRequest readingRequest) throws ReadingException {
        return null;
    }

    @Override
    public ReadingResponse updateSensorReading(ReadingRequest readingRequest, Integer readingId) throws ReadingException {
        return null;
    }
}
