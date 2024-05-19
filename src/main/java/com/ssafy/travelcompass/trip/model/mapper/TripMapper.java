package com.ssafy.travelcompass.trip.model.mapper;

import java.time.LocalDate;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.trip.model.dto.TripActivityDto;
import com.ssafy.travelcompass.trip.model.dto.TripDetailDto;
import com.ssafy.travelcompass.trip.model.dto.TripPlanDto;

@Mapper
public interface TripMapper {
	void registTripDetail(TripDetailDto tripDetailDto);
	void registTripDetailPlan(TripPlanDto tripPlanDto);
	void registTripActivity(TripActivityDto tripActivityDto);
}
