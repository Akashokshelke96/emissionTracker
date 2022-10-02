package com.example.springbootcrud.service;

import com.example.springbootcrud.entity.District;
import com.example.springbootcrud.entity.Sensor;
import com.example.springbootcrud.exception.SensorException;
import com.example.springbootcrud.repository.DistrictRepository;
import com.example.springbootcrud.repository.SensorRepository;
import com.example.springbootcrud.requests.SensorRequest;
import com.example.springbootcrud.response.SensorResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImpl implements SensorService{
    @Autowired
    SensorRepository sensorRepository;
    @Autowired
    DistrictRepository districtRepository;

    @Override
    public List<Sensor> getAllSensors() {
        return  sensorRepository.findAll();
    }

    @Override
    public Optional<Sensor> getSensorById(Integer sensorId) {
        return sensorRepository.findById(sensorId);
    }

    @Override
    public String deleteSensorById(Integer sensorId) {
        Optional<Sensor> sensor = sensorRepository.findById(sensorId);
        if(sensor.isPresent()){
            sensorRepository.deleteById(sensorId);
            return "Sensor Deleted Successfully";
        }
        return "Sensor Not Found!!";

    }

    @Override
    public SensorResponse createNewSensor(SensorRequest sensorRequest) throws SensorException {
        Sensor sensor = new Sensor();
        BeanUtils.copyProperties(sensorRequest, sensor);

        Optional<District> district = districtRepository.findById(sensorRequest.getDistrictId());

        if (district.isPresent()) {
            sensor.setDistrict(district.get());
            sensor = sensorRepository.save(sensor);
            SensorResponse sensorResponse = new SensorResponse();
            BeanUtils.copyProperties(sensor, sensorResponse);
            sensorResponse.setDistrictId(sensor.getDistrict().getDistrictId());
            return sensorResponse;
        }else{
            throw new SensorException("District Not Found");
        }
    }
    @Override
    public SensorResponse updateSensor(SensorRequest sensorRequest, Integer sensorId) throws SensorException {
        Optional<Sensor> sensorOptional = sensorRepository.findById(sensorId);

        if(sensorOptional.isPresent()){
            Sensor sensor = sensorOptional.get();
            sensor.setSensorName(sensorRequest.getSensorName());
            sensor.getDistrict().setDistrictId(sensorRequest.getDistrictId());

            sensor = sensorRepository.save(sensor);
            SensorResponse sensorResponse = new SensorResponse();
            BeanUtils.copyProperties(sensor,sensorResponse);
            sensorResponse.setDistrictId(sensor.getDistrict().getDistrictId());
            return sensorResponse;
        }else{
            throw new SensorException("Sensor Not Found");
        }
    }


}
