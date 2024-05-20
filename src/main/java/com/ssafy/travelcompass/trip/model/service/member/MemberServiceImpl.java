package com.ssafy.travelcompass.trip.model.service.member;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.exception.custom.MemberDuplicationException;
import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberMapper;

	@Override
	public void regist(TripDetailMemberDto tripDetailMemberDto) throws Exception {
		TripDetailMemberDto result = memberMapper.findByUserId(tripDetailMemberDto.getUserId());
		
		if(result != null) {
			throw new MemberDuplicationException();
		}
		else {
			memberMapper.regist(tripDetailMemberDto);
		}
	}
}
