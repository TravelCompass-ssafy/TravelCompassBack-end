package com.ssafy.travelcompass.trip.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.trip.model.dto.TripDetailDto;
import com.ssafy.travelcompass.trip.model.mapper.TripMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
	private final TripMapper tripMapper;

	@Override
	public void registTripDetail(TripDetailDto tripDetailDto) {
		tripMapper.registTripDetail(tripDetailDto);
	}
	
}
