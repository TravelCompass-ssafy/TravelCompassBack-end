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
	public List<TripReviewDto> getReviewList(String type, String key) {
		List<TripReviewDto> reviewList = reviewMapper.getReviewList(type, key);
		
		for (int i = 0; i < reviewList.size(); i++) {
			reviewList.get(i).setReviewCommentList(reviewMapper.getReviewCommentList(reviewList.get(i).getTripReviewId()));
			reviewList.get(i).setReviewImageFileList(reviewMapper.getReviewImageFilList(reviewList.get(i).getTripReviewId()));
			reviewList.get(i).setReviewLikeList(reviewMapper.getReviewLikeList(reviewList.get(i).getTripReviewId()));
			reviewList.get(i).setReviewTagList(reviewMapper.getReviewTagList(reviewList.get(i).getTripReviewId()));
		}
		
		return reviewList;
	}
}
