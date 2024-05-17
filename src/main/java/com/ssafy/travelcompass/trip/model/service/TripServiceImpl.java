package com.ssafy.travelcompass.trip.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.trip.model.mapper.TripMapper;

@Service
public class TripServiceImpl implements TripService {
	private TripMapper tripMapper;
	
	public TripServiceImpl(TripMapper tripMapper) {
		super();
		this.tripMapper = tripMapper;
	}
}
