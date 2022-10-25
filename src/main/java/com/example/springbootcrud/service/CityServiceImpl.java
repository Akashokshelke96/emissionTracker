package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.City;
import com.example.springbootcrud.entity.CityHall;
import com.example.springbootcrud.exception.CityException;
import com.example.springbootcrud.exception.NoDataFoundException;
import com.example.springbootcrud.repository.CityHallRepository;
import com.example.springbootcrud.repository.CityRepository;
import com.example.springbootcrud.requests.CityRequest;
import com.example.springbootcrud.response.CityResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    CityHallRepository cityHallRepository;

    @Override
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    @Override
    public CityResponse createCity(CityRequest cityRequest) throws CityException {
        City city = new City();
        city.setCityId(cityRequest.getCityId());
        city.setCityName(cityRequest.getCityName());
        city.setCityZip(cityRequest.getCityZip());
        Optional<CityHall> cityHall = cityHallRepository.findById(cityRequest.getCityId());
        if (cityHall.isPresent()) {
            city.setCityHall(cityHall.get());
            city = cityRepository.save(city);
            CityResponse cityResponse = new CityResponse();
            cityResponse.setCityId(city.getCityId());
            cityResponse.setCityName(city.getCityName());
            cityResponse.setCityZip(city.getCityZip());
            cityResponse.setCityHallId(city.getCityHall().getCityHallId());
            return cityResponse;
        } else {
            throw new CityException("Incorrect Mapping with CityHall Id");
        }

    }

    @Override
    public CityResponse updateCity(CityRequest cityRequest) throws CityException {
        Optional<City> updateCity = cityRepository.findById(cityRequest.getCityId());

        if (updateCity.isPresent()) {
            updateCity.get().setCityId(cityRequest.getCityId());
            updateCity.get().setCityName(cityRequest.getCityName());
            updateCity.get().setCityZip(cityRequest.getCityZip());
            Optional<CityHall> cityHall = cityHallRepository.findById(cityRequest.getCityHallId());
            if (cityHall.isPresent()) {
                updateCity.get().setCityHall(cityHall.get());
            }
            updateCity.get().setDistrictList(cityRequest.getDistrictList());
            City save = cityRepository.save(updateCity.get());
            CityResponse cityResponse = new CityResponse();
            BeanUtils.copyProperties(save, cityResponse);
            cityResponse.setCityHallId(save.getCityHall().getCityHallId());
            return cityResponse;
        } else {
            throw new CityException("City not found");
        }

    }

    @Override
    public String deleteCity(Integer cityId) throws NoDataFoundException {
        Optional<City> city = cityRepository.findById(cityId);
        if (city.isPresent()) {
            cityRepository.delete(city.get());
            return "Deleted the City successfully";
        } else {
            return "Not Found the city with City Id";
        }
    }
}
