package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.CityHall;
import com.example.springbootcrud.exception.NoDataFoundException;
import com.example.springbootcrud.repository.CityHallRepository;
import com.example.springbootcrud.requests.CityHallRequest;
import com.example.springbootcrud.response.CityHallResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityHallServiceImpl implements CityHallService {

    @Autowired
    CityHallRepository cityHallRepository;


    @Override
    public List<CityHall> getCityHalls() {
        return cityHallRepository.findAll();

    }


    @Override
    public CityHallResponse createCityHall(CityHallRequest cityHallRequest) {
        CityHall cityHall = new CityHall();
        BeanUtils.copyProperties(cityHallRequest, cityHall);

        cityHall = cityHallRepository.save(cityHall);
        CityHallResponse cityHallResponse = new CityHallResponse();

        cityHallResponse.setCityHallId(cityHall.getCityHallId());
        cityHallResponse.setCityHallName(cityHall.getCityHallName());
        if (cityHall.getCityHallAddress() != null) {
            cityHallResponse.setCityHallAddress(cityHall.getCityHallAddress());
        }

        cityHallResponse.setActive(cityHall.isActive());
        cityHallResponse.setCreateDate(cityHall.getCreateDate());
        cityHallResponse.setLastUpdate(cityHall.getLastUpdate());
        cityHallResponse.setEmail(cityHall.getEmail());
        cityHallResponse.setCities(cityHall.getCities());
        cityHallResponse.setCityList(cityHall.getCityList());


        return cityHallResponse;
    }

    //
//    @Override
//    public CityHall getCityHallById(Integer cityHallId) {
//    }
//
    @Override
    public CityHallResponse updateCityHall(CityHallRequest cityHallRequest) throws NoDataFoundException {
        Optional<CityHall> cityHall = cityHallRepository.findById(cityHallRequest.getCityHallId());
        if (!cityHall.isPresent()) {
            throw new NoDataFoundException("Not Found!!");
        }
        cityHall.get().setCityHallId(cityHallRequest.getCityHallId());
        cityHall.get().setCityHallName(cityHallRequest.getCityHallName());
        cityHall.get().setCityHallAddress(cityHallRequest.getCityHallAddress());
        cityHall.get().setCityHallLocation(cityHallRequest.getCityHallLocation());
        cityHall.get().setActive(cityHallRequest.isActive());
        cityHall.get().setEmail(cityHallRequest.getEmail());
        cityHall.get().setCities(cityHallRequest.getCities());
        cityHall.get().setCreateDate(cityHallRequest.getCreateDate());
        cityHall.get().setLastUpdate(cityHallRequest.getLastUpdate());

        CityHall save = cityHallRepository.save(cityHall.get());
        CityHallResponse cityHallResponse = new CityHallResponse();
        BeanUtils.copyProperties(save, cityHallResponse);
        return cityHallResponse;
    }

    //
    @Override
    public String deleteCityHall(Integer cityHallId) throws NoDataFoundException {
        Optional<CityHall> cityHall = cityHallRepository.findById(cityHallId);
        if (cityHall.isPresent()) {
            cityHallRepository.delete(cityHall.get());
            return "deleted successfully";
        } else {
            throw new NoDataFoundException("Not present");
        }
    }
}
