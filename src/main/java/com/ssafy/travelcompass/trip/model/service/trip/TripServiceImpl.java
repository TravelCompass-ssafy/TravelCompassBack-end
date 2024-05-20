package com.ssafy.travelcompass.trip.model.service.trip;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.attraction.model.dto.AttractionInfoDto;
import com.ssafy.travelcompass.trip.model.dto.plan.TripActivityDto;
import com.ssafy.travelcompass.trip.model.dto.plan.TripPlanDto;
import com.ssafy.travelcompass.trip.model.dto.trip.TripDetailDto;
import com.ssafy.travelcompass.trip.model.mapper.TripMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
	private final TripMapper tripMapper;
	
	@Override
	public List<TripDetailDto> getTripDetailList(LocalDate date, int sidoCode, String keyword) {
		System.out.println(2);
		return tripMapper.getTripDetailList(date, sidoCode, keyword);
	}

	@Override
	public void registTripDetail(TripDetailDto tripDetailDto) {
		tripMapper.registTripDetail(tripDetailDto);

		List<List<AttractionInfoDto>> planList = tripDetailDto.getAttractionInfoList();
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
