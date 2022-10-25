package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.City;
import com.example.springbootcrud.entity.District;
import com.example.springbootcrud.exception.NoDataFoundException;
import com.example.springbootcrud.repository.CityRepository;
import com.example.springbootcrud.repository.DistrictRepository;
import com.example.springbootcrud.requests.DistrictRequest;
import com.example.springbootcrud.response.DistrictResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    @Override
    public DistrictResponse createDistrict(DistrictRequest districtRequest) throws NoDataFoundException {
        District district =   new District();
       BeanUtils.copyProperties(districtRequest,district);
        district.setDistrictId(districtRequest.getDistrictId());
        district.setDistrictName(districtRequest.getDistrictName());
        district.setDistrictZip(districtRequest.getDistrictZip());


        Optional<City> city = cityRepository.findById(districtRequest.getCityId());

        if(city.isPresent()){
            DistrictResponse districtResponse = new DistrictResponse();
            districtResponse.setCityId(city.get().getCityId());
            districtResponse.setDistrictId(districtRequest.getDistrictId());
            districtResponse.setDistrictName(districtRequest.getDistrictName());
            districtResponse.setDistrictZip(districtRequest.getDistrictZip());


            district = districtRepository.save(district);
            return districtResponse;
        }
        else {
            throw new NoDataFoundException("No such District Found");
        }
    }

    @Override
    public String deleteDistrict(Integer districtId) throws NoDataFoundException {
        Optional<District> district = districtRepository.findById(districtId);
        if (district.isPresent()) {
            districtRepository.deleteById(districtId);
            return "District Deleted!!!";
        }
        else{
            throw new NoDataFoundException("District with Id not found");
        }
    }

    @Override
    public DistrictResponse updateDistrict(DistrictRequest districtRequest) throws NoDataFoundException {
        Optional<District> district = districtRepository.findById(districtRequest.getDistrictId());

        if(district.isPresent()) {
            district.get().setDistrictName(districtRequest.getDistrictName());
            district.get().setDistrictId(districtRequest.getDistrictId());
            district.get().getCity().setCityId(districtRequest.getCityId());
            district.get().setDistrictZip(districtRequest.getDistrictZip());

            District updated =  district.get();
            updated = districtRepository.save(updated);
            DistrictResponse districtResponse = new DistrictResponse();
            BeanUtils.copyProperties(updated,districtResponse);
            districtResponse.setCityId(updated.getCity().getCityId());
            return districtResponse;
        }
        else{
            throw new NoDataFoundException("Not Found such entity!!");
        }
    }
}
