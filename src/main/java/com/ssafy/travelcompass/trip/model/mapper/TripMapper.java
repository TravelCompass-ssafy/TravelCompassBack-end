package com.ssafy.travelcompass.trip.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.trip.model.dto.TripDetailDto;

@Mapper
public interface TripMapper {
	void registTripDetail(TripDetailDto tripDetailDto);
}
