package com.ssafy.travelcompass.trip.model.service.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.exception.custom.MemberDuplicationException;
import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberMapper memberMapper;

	@Override
	public void regist(TripDetailMemberDto tripDetailMemberDto) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", tripDetailMemberDto.getUserId());
		map.put("tripDetailId", tripDetailMemberDto.getTripDetailId());
		
		boolean isMemberExists = memberMapper.isMemberExistsByUserIdAndTripDetailId(map);
		
		if(isMemberExists) {
			throw new MemberDuplicationException();
		}
		else {
			memberMapper.regist(tripDetailMemberDto);
		}
	}
	
	@Override
	public List<TripDetailMemberDto> findByUserId(int userId) throws Exception {
		List<TripDetailMemberDto> member = memberMapper.findByUserId(userId);
		
		return member;
	}

	@Override
	public List<TripDetailMemberDto> findByTripDetailId(int tripDetailId) throws Exception {
		List<TripDetailMemberDto> members = null;
		try {
			members = memberMapper.findByTripDetailId(tripDetailId);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(members);
		return members;
	}

	@Override
	public TripDetailMemberDto findByIdAndUserId(int tripDetailId, int userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("tripDetailId", tripDetailId);
		map.put("userId", userId);
		TripDetailMemberDto member = memberMapper.findByIdAndUserId(map);
		
		return member;
	}

}
