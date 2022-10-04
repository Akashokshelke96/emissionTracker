package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.District;
import com.example.springbootcrud.entity.Reading;
import com.example.springbootcrud.entity.Sensor;
import com.example.springbootcrud.exception.ReadingException;
import com.example.springbootcrud.repository.DistrictRepository;
import com.example.springbootcrud.repository.ReadingRepository;
import com.example.springbootcrud.repository.SensorRepository;
import com.example.springbootcrud.requests.ReadingRequest;
import com.example.springbootcrud.response.ReadingResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ReadingServiceImpl implements ReadingService {


    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    SensorRepository sensorRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public ResponseEntity<List<ReadingResponse>> getAllReadings() {
        List<Reading> readings = readingRepository.findAll();
        List<ReadingResponse> readingResponses = new ArrayList<>();
        for (Reading reading : readings) {
            ReadingResponse readingResponse = new ReadingResponse();
            BeanUtils.copyProperties(reading, readingResponse);
            readingResponse.setSensorId(reading.getSensor().getSensorId());
            readingResponse.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(reading.getReadingTime()));
            readingResponses.add(readingResponse);
        }
        return ResponseEntity.ok(readingResponses);
    }

    @Override
    public ReadingResponse getReadingByReadingId(Integer readingId) throws ReadingException {
        Optional<Reading> readingByReadingId = readingRepository.findById(readingId);
        if (readingByReadingId.isPresent()) {
            Reading reading = readingByReadingId.get();
            ReadingResponse readingResponse = new ReadingResponse();
            BeanUtils.copyProperties(reading, readingResponse);
            readingResponse.setSensorId(reading.getSensor().getSensorId());
            readingResponse.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(reading.getReadingTime()));
            return readingResponse;
        } else {
            throw new ReadingException("Invalid Reading Id");
        }
    }


    @Override
    public List<ReadingResponse> getReadingsBySensorId(Integer sensorId) throws ReadingException {
        List<Reading> readingsBySensorId = readingRepository.findBySensor_sensorId(sensorId);
        List<ReadingResponse> readingResponses = new ArrayList<>();
        if (!readingsBySensorId.isEmpty()) {
            for (Reading reading : readingsBySensorId) {
                ReadingResponse readingResponse = new ReadingResponse();
                BeanUtils.copyProperties(reading, readingResponse);
                readingResponse.setSensorId(reading.getSensor().getSensorId());
                readingResponse.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(reading.getReadingTime()));
                readingResponses.add(readingResponse);
            }
            return readingResponses;

        } else {
            throw new ReadingException("Invalid Reading Id");
        }

    }


    @Override
    public ResponseEntity<List<ReadingResponse>> getReadingsByDistrictId(Integer districtId) {
        List<Reading> readingsByDistrictId = readingRepository.findByDistrictId(districtId);
//        Optional<District> district = districtRepository.findById(districtId);
        List<ReadingResponse> readingResponses = new ArrayList<>();
        for(Reading reading:readingsByDistrictId){
            ReadingResponse readingResponse = new ReadingResponse();
            BeanUtils.copyProperties(reading, readingResponse);
            readingResponse.setSensorId(reading.getSensor().getSensorId());
            readingResponse.setDate(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(reading.getReadingTime()));
            readingResponses.add(readingResponse);
        }
        return ResponseEntity.ok(readingResponses);
        }

    @Override
    public String deleteReadingByReadingId(Integer readingId) {
        Optional<Reading> reading = readingRepository.findById(readingId);
        if (reading.isPresent()) {
            readingRepository.delete(reading.get());
            return "Reading Deleted Successfully";
        }
        return "Could Not Found Reading!!";
    }

    @Override
    public ReadingResponse createNewReading(ReadingRequest readingRequest) throws ReadingException {
        Reading reading = new Reading();

        BeanUtils.copyProperties(readingRequest, reading);
        Optional<Sensor> sensor = sensorRepository.findById(readingRequest.getSensorId());

        if (sensor.isPresent()) {
            reading.setReadingTime(readingRequest.getReadingTime());
            reading.setValue(readingRequest.getValue());
            reading.getSensor().setSensorId(readingRequest.getSensorId());
            ReadingResponse readingResponse = new ReadingResponse();
            BeanUtils.copyProperties(reading, readingResponse);
            readingRepository.save(reading);
            return readingResponse;
        } else {
            throw new ReadingException("Reading with reading request not Found");
        }
    }

    @Override
    public ReadingResponse updateSensorReading(ReadingRequest readingRequest, Integer readingId) throws ReadingException {
        return null;
    }

    @Override
    public String deleteReadingBySensorId(Integer sensorId) {
        List<Reading> readingsList = readingRepository.findBySensor_sensorId(sensorId);
        if (!readingsList.isEmpty()) {
            for(Reading reading:readingsList){
                readingRepository.deleteById(reading.getReadingId());
            }
            return "Readings with SensorId Deleted Successfully";
        }
        return "Could Not Found Reading!!";
    }



}
