package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.*;
import com.example.springbootcrud.repository.*;
import com.example.springbootcrud.requests.ReportRequest;
import com.example.springbootcrud.response.CityReportResponse;
import com.example.springbootcrud.response.DistrictReportResponse;
import com.example.springbootcrud.response.ReportResponse;
import com.example.springbootcrud.response.SensorReportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        reportResponse.setDate(reportRequest.getFromDate().toString());
        List<CityReportResponse> cityReportResponses = new ArrayList<>();
        List<SensorReportResponse> sensorReportResponses = new ArrayList<>();
        DistrictReportResponse districtReportResponse = new DistrictReportResponse();
        SensorReportResponse sensorReportResponse = new SensorReportResponse();


        Optional<CityHall> cityHall = cityHallRepository.findById(reportRequest.getCityHallId());
        if (cityHall.isPresent()) {
            reportResponse.setCityHallName(cityHall.get().getCityHallName());
            getCitiesForCityHall(reportRequest, reportResponse, cityReportResponses);
            //changed here for getSensorsForCityHall

            List<Double> readings = readingRepository.findReadingsByCityHallId(reportRequest.getCityHallId());
            DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
            for (Double d : readings) {
                doubleSummaryStatistics.accept(d);
            }
            reportResponse.setCityHallMax(doubleSummaryStatistics.getMax());
            reportResponse.setCityHallMin(doubleSummaryStatistics.getMin());
            reportResponse.setCityHallAverage(doubleSummaryStatistics.getAverage());


        }


        return reportResponse;
    }



    private void getCitiesForCityHall(ReportRequest reportRequest, ReportResponse reportResponse, List<CityReportResponse> cityReportResponses) {
        List<DistrictReportResponse> districtsReportResponses = new ArrayList<>();
        List<City> cities = cityRepository.findByCityHall_CityHallId(reportRequest.getCityHallId());
        for (City city : cities) {
            List<Reading> cityReadings = readingRepository.findByCityId(city.getCityId());
            getDistrictsForCity(city.getCityId(), districtsReportResponses);

            CityReportResponse cityReportResponse = new CityReportResponse();
            cityReportResponse.setCityId(city.getCityId());
            cityReportResponse.setCityName(city.getCityName());
            List<Double> readingValues = cityReadings.stream().map(Reading::getValue).collect(Collectors.toList());

            DoubleSummaryStatistics doubleSummaryCityReadingsStatistics = new DoubleSummaryStatistics();
            for (Double d : readingValues) {

                doubleSummaryCityReadingsStatistics.accept(d);
            }
            cityReportResponse.setCityMax(doubleSummaryCityReadingsStatistics.getMax());
            cityReportResponse.setCityMin(doubleSummaryCityReadingsStatistics.getMin());
            cityReportResponse.setCityAverage(doubleSummaryCityReadingsStatistics.getAverage());
            cityReportResponse.setNumberOfDistricts(districtsReportResponses.size());
            cityReportResponse.setDistricts(districtsReportResponses);
            cityReportResponses.add(cityReportResponse);
        }
        reportResponse.setCities(cityReportResponses);

    }


    private void getDistrictsForCity(Integer cityId, List<DistrictReportResponse> districtsReportResponses) {
        List<District> districts = districtRepository.findByCity_cityId(cityId);
    //
        for (District district : districts) {
            List<Reading> districtReadings = readingRepository.findByDistrictId(district.getDistrictId());

            DistrictReportResponse districtsReportResponse = new DistrictReportResponse();
            districtsReportResponse.setDistrictId(district.getDistrictId());
            districtsReportResponse.setDistrictName(district.getDistrictName());
            List<Double> readingValues = districtReadings.stream().map(Reading::getValue).collect(Collectors.toList());

            DoubleSummaryStatistics doubleSummaryDistrictReadingsStatistics = new DoubleSummaryStatistics();
            for (Double d : readingValues) {

                doubleSummaryDistrictReadingsStatistics.accept(d);
            }
            districtsReportResponse.setDistrictMax(doubleSummaryDistrictReadingsStatistics.getMax());
            districtsReportResponse.setDistrictMin(doubleSummaryDistrictReadingsStatistics.getMin());
            districtsReportResponse.setDistrictAverage(doubleSummaryDistrictReadingsStatistics.getAverage());
            districtsReportResponse.setSensors(getSensorsForDistrict(district.getDistrictId()));
            districtsReportResponses.add(districtsReportResponse);
        }
    }

    private List<SensorReportResponse> getSensorsForDistrict(Integer districtId) {
        List<SensorReportResponse> sensorReportResponses = new ArrayList<>();
        List<Sensor> sensors = sensorRepository.findByDistrict_districtId(districtId);
        for (Sensor sensor : sensors) {
            List<Reading> sensorReadings = readingRepository.findBySensor_sensorId(sensor.getSensorId());
            SensorReportResponse sensorsReportResponse = new SensorReportResponse();
            sensorsReportResponse.setSensorId(sensor.getSensorId());
            sensorsReportResponse.setSensorName(sensor.getSensorName());
            List<Double> readingValues = sensorReadings.stream().map(Reading::getValue).collect(Collectors.toList());

            DoubleSummaryStatistics doubleSummarySensorReadingsStatistics = new DoubleSummaryStatistics();
            for (Double d : readingValues) {

                doubleSummarySensorReadingsStatistics.accept(d);
            }
            sensorsReportResponse.setSensorMax(doubleSummarySensorReadingsStatistics.getMax());
            sensorsReportResponse.setSensorMin(doubleSummarySensorReadingsStatistics.getMin());
            sensorsReportResponse.setSensorAverage(doubleSummarySensorReadingsStatistics.getAverage());

            sensorReportResponses.add(sensorsReportResponse);
        }
        return sensorReportResponses;
    }

}
