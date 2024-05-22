package com.ssafy.travelcompass.home.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.home.model.dto.BestPlanViewDto;
import com.ssafy.travelcompass.home.model.dto.RecentTripDto;

@Mapper
public interface HomeMapper {
	List<BestPlanViewDto> getBestPlanView();
	List<RecentTripDto> getRecentTrip();
}
