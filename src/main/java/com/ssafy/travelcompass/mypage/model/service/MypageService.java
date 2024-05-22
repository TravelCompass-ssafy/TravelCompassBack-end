package com.ssafy.travelcompass.mypage.model.service;

import java.util.List;

import com.ssafy.travelcompass.mypage.model.dto.MypagePlanDto;
import com.ssafy.travelcompass.mypage.model.dto.MypageTripDto;

public interface MypageService {
	List<MypagePlanDto> getMypagePlan(int userId);
	List<MypageTripDto> getMypageTrip(int userId);
}
