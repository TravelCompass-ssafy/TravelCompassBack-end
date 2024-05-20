package com.ssafy.travelcompass.trip.model.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.trip.model.dto.plan.TripActivityDto;
import com.ssafy.travelcompass.trip.model.dto.plan.TripPlanDto;
import com.ssafy.travelcompass.trip.model.dto.trip.TripDetailDto;

@Mapper
public interface TripMapper {
	List<TripDetailDto> getTripDetailList(LocalDate date, int sidoCode, String keyword);
	void registTripDetail(TripDetailDto tripDetailDto);
	void registTripDetailPlan(TripPlanDto tripPlanDto);
	void registTripActivity(TripActivityDto tripActivityDto);
}
