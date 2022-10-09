package com.example.springbootcrud.controller;

import com.example.springbootcrud.entity.CityHall;

import com.example.springbootcrud.exception.InternalServerErrorException;
import com.example.springbootcrud.exception.NoDataFoundException;

import com.example.springbootcrud.requests.CityHallRequest;
import com.example.springbootcrud.response.CityHallResponse;
import com.example.springbootcrud.service.CityHallService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CityHallController {

	private static final Logger _logger = LoggerFactory.getLogger(CityHallController.class);

	@Autowired
	private CityHallService cityHallService;

	// Get All City Halls
	@GetMapping("/city-halls")
	public List<CityHall> getCityHalls() throws NoDataFoundException, Exception, InternalServerErrorException {

		List<CityHall> cityHallList = null;

		cityHallList = cityHallService.getCityHalls();
		return cityHallList;
	}

	// Create a new City Hall
	@PostMapping("/city-halls")
	public ResponseEntity<CityHallResponse> createCityHall(@Valid  @RequestBody CityHallRequest cityHallRequest){

		CityHallResponse cityHallResponse = cityHallService.createCityHall(cityHallRequest);
		return  ResponseEntity.ok(cityHallResponse);
	}

	@DeleteMapping("/city-halls/{cityHallId}")
	public ResponseEntity<String> deleteCityHall(@PathVariable(value = "cityHallId") Integer cityHallId) throws NoDataFoundException {
		return ResponseEntity.ok(cityHallService.deleteCityHall(cityHallId));
	}

	@PutMapping("/city-halls/")
	public ResponseEntity<CityHallResponse> updateCityHall(@Valid @RequestBody CityHallRequest cityHallRequest) throws NoDataFoundException {
		CityHallResponse updatedCityHall = cityHallService.updateCityHall(cityHallRequest);
        return ResponseEntity.ok(updatedCityHall);
	}



}
//	// get a city hall
//	@GetMapping("/city-halls/{cityHallId}")
//	public CityHall getCityHallById(@PathVariable(value = "cityHallId") Integer cityHallId) throws Exception, ResourceNotFoundException {
//		_logger.info("Inside class-name:[{}] method-name:[{}] type:[{}] request-object:city hall id[{}] msg:[{}]",
//				"CityHallController", "getCityHallById", "request", cityHallId, "Request received");
//
//		CityHall cityHall = cityHallService.getCityHallById(cityHallId);
//		if (cityHall == null) {
//			_logger.info("Inside class-name:[{}] method-name:[{}] type:[{}] error-code:[{}] error-msg:[{}] id:[{}]",
//					"CityHallController", "getCityHallById", "response", ResponseMessages.RESOURCE_NOT_FOUND.getCode(),
//					ResponseMessages.RESOURCE_NOT_FOUND.getCustomErrorMessage(), cityHallId);
//			throw new ResourceNotFoundException(String.format("No city hall found for id %d", cityHallId));
//
//		}
//		_logger.info("Inside class-name:[{}] method-name:[{}] type:[{}] requested city hall id[{}] msg:[{}]",
//				"CityHallController", "getCityHallById", "request", cityHallId, "Response received");
//		return cityHall;
//	}
//
//	// update a city hall with a specific cityHallId
//	@PutMapping("/city-halls/{cityHallId}")
//	public CityHall updateCityHall(@PathVariable(value = "cityHallId") Integer cityHallId,
//			@RequestBody CityHallRequest cityHallRequest) throws NoDataFoundException {
//		_logger.info("Inside class-name:[{}] method-name:[{}] type:[{}] request-object:city hall id[{}] msg:[{}]",
//				"CityHallController", "getCityHallById", "request", cityHallId, "Request recieved");
//		CityHall updated = null;
//		updated = cityHallService.updateCityHall(cityHallRequest);
//		_logger.info("Inside class-name:[{}] method-name:[{}] type:[{}] response-object:city hall updated[{}] msg:[{}]",
//				"CityHallController", "updateCityHall", "request", updated, "Response received");
//		return updated;
//	}
//
//	// delete a city hall
//	@DeleteMapping("/city-halls/{cityHallId}")
//	public String deleteCityHall(@PathVariable(value = "cityHallId") Integer cityHallId) throws CityHallException {
//		_logger.info("Inside class-name:[{}] method-name:[{}] type:[{}] request-object:city hall id[{}] msg:[{}]",
//				"CityHallController", "deleteCityHall", "request", cityHallId, "Request received");
//		return cityHallService.deleteCityHall(cityHallId);
//	}

