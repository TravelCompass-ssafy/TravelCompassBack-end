package com.ssafy.travelcompass.trip.model.service.trip;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.ssafy.travelcompass.trip.model.dto.trip.TripDetailDto;

public interface TripService {
	List<TripDetailDto> getTripDetailList(LocalDate date, int sidoCode, String keyword);
	TripDetailDto getTripDetail(int tripDetailId);
	void registTripDetail(TripDetailDto tripDetailDto) throws Exception;
	boolean getDuplicationTripId(int userId, LocalDate startDate, LocalDate endDate);
}
