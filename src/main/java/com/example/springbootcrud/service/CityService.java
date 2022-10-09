package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.City;
import com.example.springbootcrud.exception.CityException;
import com.example.springbootcrud.exception.NoDataFoundException;
import com.example.springbootcrud.requests.CityRequest;
import org.springframework.stereotype.Service;
import com.example.springbootcrud.response.CityResponse;
import java.util.List;

@Service
public interface CityService {
    List<City> getCities();

    CityResponse createCity(CityRequest cityRequest) throws CityException;

//    City getCityById(Integer cityId);
//
    CityResponse updateCity(CityRequest cityRequest) throws CityException;
//
    String deleteCity(Integer cityId) throws NoDataFoundException;
}
