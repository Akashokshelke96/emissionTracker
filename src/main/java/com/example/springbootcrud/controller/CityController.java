package com.example.springbootcrud.controller;


import com.example.springbootcrud.entity.City;
import com.example.springbootcrud.exception.CityException;
import com.example.springbootcrud.exception.NoDataFoundException;
import com.example.springbootcrud.requests.CityRequest;
import com.example.springbootcrud.response.CityResponse;
import com.example.springbootcrud.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CityController {


    @Autowired
    private CityService cityService;


    // Get All Cities
    @GetMapping("/cities")
    public List<City> getAllCities() {

        return cityService.getCities();
    }

    @PostMapping("/cities")
    public ResponseEntity<CityResponse> createNewCity(@Valid @RequestBody CityRequest cityRequest) throws CityException {
        CityResponse cityResponse = cityService.createCity(cityRequest);
        return ResponseEntity.ok(cityResponse);
    }

    @DeleteMapping("/cities/{cityId}")
    public ResponseEntity<String> deleteCity(@PathVariable(value = "cityId") Integer cityId) throws NoDataFoundException {
        return  ResponseEntity.ok(cityService.deleteCity(cityId));
    }

    @PutMapping("/cities/")
    public  ResponseEntity<CityResponse> updateCity(@Valid @RequestBody CityRequest cityRequest) throws CityException {
        CityResponse updatedCity = cityService.updateCity(cityRequest);
        return ResponseEntity.ok(updatedCity);

    }


//
//	// Create a new City
//	@PostMapping("/cities")
//	public ResponseEntity createCity(@Valid @RequestBody CityRequest cityRequest) throws CityException {
//
//
//		City city = cityService.createCity(cityRequest);
//
//		if (Objects.isNull(city)) {
//			logger.info("Error saving city");
//			throw new CityException("Error saving city");
//
//		}
//
//
//		return HttpResponseUtils.getResponse(HttpStatus.CREATED, ResponseMessages.CREATED.getCustomErrorMessage(),
//				city);
//
//	}
//
//	// Get a City
//	@GetMapping("/cities/{cityId}")
//	public City getCityById(@PathVariable(value = "cityId") Integer cityId) throws Exception, ResourceNotFoundException {
//
//
//		City city = cityService.getCityById(cityId);
//		if (city == null) {
//			logger.info("Inside class-name:[{}] method-name:[{}] type:[{}] error-code:[{}] error-msg:[{}] id:[{}]",
//					"CityController", "getCityById", "response", ResponseMessages.RESOURCE_NOT_FOUND.getCode(),
//					ResponseMessages.RESOURCE_NOT_FOUND.getCustomErrorMessage(), cityId);
//			throw new ResourceNotFoundException(String.format("No city hall found for id %d", cityId));
//
//		}
//
//		return city;
//
//	}
//
//	// Update a City
//	@PutMapping("/cities/{cityId}")
//	public City updateCity(@PathVariable(value = "cityId") Integer cityId,@Valid @RequestBody CityRequest cityRequest)
//			throws NoDataFoundException {
//
//
//		City updatedCity = null;
//		try {
//			updatedCity = cityService.updateCity(cityRequest);
//		} catch (InternalServerErrorException e) {
//			logger.error("Error occured while updating city with id []", cityId);
//			logger.error(Arrays.asList(e.getStackTrace()).toString());
//
//		}
//
//		return updatedCity;
//
//	}
//
//	// Delete a City
//	@DeleteMapping("/cities/{id}")
//	public String deleteCity(@PathVariable(value = "id") Integer cityId) throws CityHallException {
//
//
//		return cityService.deleteCity(cityId);
//	}
}
