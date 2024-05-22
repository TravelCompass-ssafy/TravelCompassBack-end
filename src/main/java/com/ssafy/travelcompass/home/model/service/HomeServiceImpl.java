package com.ssafy.travelcompass.home.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.home.model.dto.BestPlanViewDto;
import com.ssafy.travelcompass.home.model.dto.RecentTripDto;
import com.ssafy.travelcompass.home.model.mapper.HomeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {
	private final HomeMapper homeMapper;

	@Override
	public List<BestPlanViewDto> getBestPlanView() {
		return homeMapper.getBestPlanView();
	}

	@Override
	public List<RecentTripDto> getRecentTrip() {
		return homeMapper.getRecentTrip();
	}
}
