package com.ssafy.travelcompass.home.model.service;

import java.util.List;

import com.ssafy.travelcompass.home.model.dto.BestPlanViewDto;
import com.ssafy.travelcompass.home.model.dto.RecentTripDto;

public interface HomeService {
	List<BestPlanViewDto> getBestPlanView();
	List<RecentTripDto> getRecentTrip();
}
