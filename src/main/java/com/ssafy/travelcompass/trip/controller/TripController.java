package com.ssafy.travelcompass.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.travelcompass.trip.model.service.TripService;

@RestController
@RequestMapping("/api/trip")
public class TripController {
	private TripService tripService;
	
	@Autowired
	public TripController(TripService tripService) {
		super();
		this.tripService = tripService;
	}
}
