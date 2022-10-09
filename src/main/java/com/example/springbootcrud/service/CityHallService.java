package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.CityHall;
import com.example.springbootcrud.exception.NoDataFoundException;
import com.example.springbootcrud.requests.CityHallRequest;
import com.example.springbootcrud.response.CityHallResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityHallService {
    List<CityHall> getCityHalls();

    CityHallResponse createCityHall(CityHallRequest cityHallRequest);
//
//    CityHall getCityHallById(Integer cityHallId);
//
CityHallResponse updateCityHall(CityHallRequest cityHallRequest) throws NoDataFoundException;

    String deleteCityHall(Integer cityHallId) throws NoDataFoundException;
//

}
