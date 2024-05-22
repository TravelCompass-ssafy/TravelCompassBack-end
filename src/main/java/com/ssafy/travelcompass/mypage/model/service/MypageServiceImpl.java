package com.ssafy.travelcompass.mypage.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.mypage.model.dto.MypagePlanDto;
import com.ssafy.travelcompass.mypage.model.dto.MypageTripDto;
import com.ssafy.travelcompass.mypage.model.mapper.MypageMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {
	private final MypageMapper mypageMapper;

	@Override
	public List<MypagePlanDto> getMypagePlan(int userId) {
		return mypageMapper.getMypagePlan(userId);
	}

	@Override
	public List<MypageTripDto> getMypageTrip(int userId) {
		return mypageMapper.getMypageTrip(userId);
	}
}
