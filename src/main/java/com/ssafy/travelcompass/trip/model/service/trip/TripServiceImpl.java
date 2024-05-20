package com.ssafy.travelcompass.trip.model.service.trip;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.attraction.model.dto.AttractionInfoDto;
import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.dto.plan.TripActivityDto;
import com.ssafy.travelcompass.trip.model.dto.plan.TripPlanAttractionDto;
import com.ssafy.travelcompass.trip.model.dto.plan.TripPlanDto;
import com.ssafy.travelcompass.trip.model.dto.trip.TripDetailDto;
import com.ssafy.travelcompass.trip.model.mapper.TripMapper;
import com.ssafy.travelcompass.trip.model.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
	private final TripMapper tripMapper;
	private final MemberService memberService;
	
	@Override
	public List<TripDetailDto> getTripDetailList(LocalDate date, int sidoCode, String keyword) {
		return tripMapper.getTripDetailList(date, sidoCode, keyword);
	}
	
	@Override
	public TripDetailDto getTripDetail(int tripDetailId) {
		TripDetailDto tripDetailDto = tripMapper.getTripDetail(tripDetailId);
		tripDetailDto.setMemberList(tripMapper.getTripMemberList(tripDetailId));
		

		List<TripPlanAttractionDto> tripPlanAttractionDto = tripMapper.getPlanAttractionList(tripDetailId);
		List<List<TripPlanAttractionDto>> tripPlanAttractionList = new ArrayList<>();
		
		int planSize = 0;
		int listIndex = 0;
		
		for (LocalDate l = tripDetailDto.getStartDate(); !l.isAfter(tripDetailDto.getEndDate()); l = l.plusDays(1)) {
			tripPlanAttractionList.add(new ArrayList<>());
			
			while (tripPlanAttractionDto.size() > planSize) {
				if (!tripPlanAttractionDto.get(planSize).getTripDate().equals(l)) {
					break;
				}
				
				tripPlanAttractionList.get(listIndex).add(tripPlanAttractionDto.get(planSize++));
			}
			
			listIndex++;
		}
		
		tripDetailDto.setTripPlanAttractionList(tripPlanAttractionList);
		
		return tripDetailDto;
	}

	@Override
	public void registTripDetail(TripDetailDto tripDetailDto) throws Exception {
		tripMapper.registTripDetail(tripDetailDto);
		TripDetailMemberDto tripDetailMemberDto = new TripDetailMemberDto();
		tripDetailMemberDto.setUserId(tripDetailDto.getUserId());
		tripDetailMemberDto.setTripDetailId(tripDetailDto.getTripDetailId());
		memberService.regist(tripDetailMemberDto);

		List<List<TripPlanAttractionDto>> planList = tripDetailDto.getTripPlanAttractionList();
		for (int i = 0; i < planList.size(); i++) {
			for (int j = 0; j < planList.get(i).size(); j++) {
				TripPlanDto tripPlanDto = new TripPlanDto();
				tripPlanDto.setTripDetailId(tripDetailDto.getTripDetailId());
				tripPlanDto.setTripDate(tripDetailDto.getStartDate().plusDays(i));
				tripMapper.registTripDetailPlan(tripPlanDto);
				
				TripActivityDto tripActivityDto = new TripActivityDto();
				tripActivityDto.setTripPlanId(tripPlanDto.getTripPlanId());
				tripActivityDto.setContentId(planList.get(i).get(j).getContentId());
				tripActivityDto.setActivityOrder(j + 1);
				tripMapper.registTripActivity(tripActivityDto);
			}
		}
	}
}
