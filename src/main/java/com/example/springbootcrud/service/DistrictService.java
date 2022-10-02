package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.District;
import com.example.springbootcrud.exception.NoDataFoundException;
import com.example.springbootcrud.requests.DistrictRequest;
import com.example.springbootcrud.response.DistrictResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DistrictService {
    List<District> getAllDistricts();

    DistrictResponse createDistrict(DistrictRequest districtRequest) throws NoDataFoundException;

    String deleteDistrict(Integer districtId) throws NoDataFoundException;

    DistrictResponse updateDistrict(DistrictRequest districtRequest) throws NoDataFoundException;
}
