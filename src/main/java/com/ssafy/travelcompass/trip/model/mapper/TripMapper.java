package com.ssafy.travelcompass.trip.model.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.attraction.model.dto.AttractionInfoDto;
import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.dto.plan.TripActivityDto;
import com.ssafy.travelcompass.trip.model.dto.plan.TripPlanAttractionDto;
import com.ssafy.travelcompass.trip.model.dto.plan.TripPlanDto;
import com.ssafy.travelcompass.trip.model.dto.trip.TripDetailDto;

@Mapper
public interface TripMapper {
	List<TripDetailDto> getTripDetailList(LocalDate date, int sidoCode, String keyword);
	TripDetailDto getTripDetail(int tripDetailId);
	List<TripDetailMemberDto> getTripMemberList(int tripDetailId);
	List<TripPlanAttractionDto> getPlanAttractionList(int tripDetailId);
	Integer getDuplicationTripId(int userId, LocalDate startDate, LocalDate endDate);
	TripDetailDto getProceedTrip(int userId);
	
	void registTripDetail(TripDetailDto tripDetailDto);
	void registTripDetailPlan(TripPlanDto tripPlanDto);
	void registTripActivity(TripActivityDto tripActivityDto);
}
