package com.ssafy.travelcompass.review.model.service.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.exception.custom.isNotMemberException;
import com.ssafy.travelcompass.review.model.dto.review.TripReviewDto;
import com.ssafy.travelcompass.review.model.mapper.ReviewMapper;
import com.ssafy.travelcompass.review.model.service.tag.ReviewTagService;
import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	private final ReviewMapper reviewMapper;
	private final ReviewTagService reviewTagService;
	private final MemberService memberService;
	
	@Override
	public void writeReview(TripReviewDto requestTripReview) throws Exception {
		TripDetailMemberDto member = memberService.findByUserId(requestTripReview.getUserId());
		if(member != null) {
			throw new isNotMemberException();
		}
		else {
			reviewMapper.writeReview(requestTripReview);
			reviewTagService.addTagListByReviewId(requestTripReview.getTripReviewId(), requestTripReview.getReviewTagList());
		}
	}
}
