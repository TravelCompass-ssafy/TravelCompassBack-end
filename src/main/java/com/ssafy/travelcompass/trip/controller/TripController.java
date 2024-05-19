package com.ssafy.travelcompass.trip.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.trip.model.dto.TripDetailDto;
import com.ssafy.travelcompass.trip.model.service.TripService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/trip")
@RequiredArgsConstructor
public class TripController {
	private final TripService tripService;
	
	@GetMapping
	public ResponseEntity<?> getTripList() {
		return null;
	}
	
	@PostMapping
	public ResponseEntity<?> registTrip(@RequestBody TripDetailDto tripDetailDto) {
		System.out.println(tripDetailDto);
		tripService.registTripDetail(tripDetailDto);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
