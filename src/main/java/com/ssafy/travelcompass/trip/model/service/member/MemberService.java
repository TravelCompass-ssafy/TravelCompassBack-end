package com.ssafy.travelcompass.trip.model.service.member;

import java.util.List;

import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;

public interface MemberService {

	void regist(TripDetailMemberDto tripDetailMemberDto) throws Exception;

	TripDetailMemberDto findByUserId(int userId) throws Exception;

	List<TripDetailMemberDto> findByTripDetailId(int tripDetailId) throws Exception;

}
