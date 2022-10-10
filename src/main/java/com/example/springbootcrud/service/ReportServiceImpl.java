package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.*;
import com.example.springbootcrud.repository.*;
import com.example.springbootcrud.requests.ReportRequest;
import com.example.springbootcrud.response.ReportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
@Component
public class ReportServiceImpl implements ReportService {


    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    CityHallRepository cityHallRepository;
    @Autowired
    CityRepository cityRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    SensorRepository sensorRepository;

    @Override
    public ReportResponse getReportByCityHallId(ReportRequest reportRequest) {
        ReportResponse reportResponse = new ReportResponse();
        reportResponse.setCityHallId(reportRequest.getCityHallId());
        Optional<CityHall> cityHall = cityHallRepository.findById(reportRequest.getCityHallId());

        reportResponse.setCityHallName(cityHall.get().getCityHallName());
//        reportResponse.getCityHallMax()
        List<City> city = cityRepository.findByCityHall_CityHallId(reportRequest.getCityHallId());
        List<District> district = districtRepository.findByCityHallId(reportRequest.getCityHallId());
        List<Sensor> sensor = sensorRepository.findByCityHallId(reportRequest.getCityHallId());
        List<Sensor> readingsByCityHallId = sensorRepository.findByCityHallId(reportRequest.getCityHallId());

        //get all sensor readings  against city hall name within date range
        List<Reading> requestedReadingByCityHallIdBetweenDates = readingRepository.findByCityHallIdBetweenDates(reportRequest.getCityHallId(), reportRequest.getFromDate(), reportRequest.getToDate());
        return reportResponse;
    }

}
