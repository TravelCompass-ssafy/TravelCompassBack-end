package com.ssafy.travelcompass.trip.model.service.trip;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.ssafy.travelcompass.trip.model.dto.trip.TripDetailDto;
import com.ssafy.travelcompass.trip.model.dto.trip.TripDetailImageDto;

public interface TripService {
	List<TripDetailDto> getTripDetailList(LocalDate date, int sidoCode, String keyword);
	List<TripDetailDto> getShareList(LocalDate date, int sidoCode, String keyword);
	TripDetailDto getTripDetail(int tripDetailId);
	void registTripDetail(TripDetailDto tripDetailDto ) throws Exception;
	boolean getDuplicationTripId(int userId, LocalDate startDate, LocalDate endDate);
	TripDetailDto getProceedTrip(int userId);
	void upCountViewI(int tripDetailId);
	void deleteTripDetail(int tripDetailId);
	void updateTripDetail(TripDetailDto tripDetailDto);
}
