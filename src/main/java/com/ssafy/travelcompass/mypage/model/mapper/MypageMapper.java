package com.ssafy.travelcompass.mypage.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.mypage.model.dto.MypagePlanDto;
import com.ssafy.travelcompass.mypage.model.dto.MypageTripDto;

@Mapper
public interface MypageMapper {
	List<MypagePlanDto> getMypagePlan(int userId);
	List<MypageTripDto> getMypageTrip(int userId);
}
