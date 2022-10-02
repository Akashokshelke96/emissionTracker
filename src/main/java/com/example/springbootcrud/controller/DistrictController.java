package com.example.springbootcrud.controller;

import com.example.springbootcrud.entity.District;
import com.example.springbootcrud.exception.NoDataFoundException;
import com.example.springbootcrud.requests.DistrictRequest;
import com.example.springbootcrud.response.DistrictResponse;
import com.example.springbootcrud.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DistrictController {

    @Autowired
    DistrictService districtService;

    @GetMapping("/cities/districts")
    public List<District> getAllDistricts(){
        return districtService.getAllDistricts();
    }

    @PostMapping("/cities/districts")
    public ResponseEntity<DistrictResponse> createDistrict(@Valid  @RequestBody DistrictRequest districtRequest) throws NoDataFoundException {
        DistrictResponse districtResponse = districtService.createDistrict(districtRequest);
        return ResponseEntity.ok(districtResponse);
    }

    @DeleteMapping("/cities/districts/{districtId}")
    public String deleteDistrict(@PathVariable(value = "districtId") Integer districtId) throws NoDataFoundException {
        return districtService.deleteDistrict(districtId);
    }

    @PutMapping("/cities/districts")
    public ResponseEntity<DistrictResponse> updateDistrict(@Valid @RequestBody DistrictRequest districtRequest) throws NoDataFoundException {
        DistrictResponse districtResponse = districtService.updateDistrict(districtRequest);
        return ResponseEntity.ok(districtResponse);
    }
}
