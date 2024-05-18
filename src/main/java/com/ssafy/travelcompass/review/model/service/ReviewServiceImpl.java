package com.ssafy.travelcompass.review.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.review.model.dto.TripReviewDto;
import com.ssafy.travelcompass.review.model.mapper.ReviewMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	private final ReviewMapper reviewMapper;

	@Override
	public List<TripReviewDto> getReviewList(String searchType, String searchKeyword) {
		List<TripReviewDto> reviewList = reviewMapper.getReviewList(searchType, searchKeyword);
		
		return reviewList;
	}
}
