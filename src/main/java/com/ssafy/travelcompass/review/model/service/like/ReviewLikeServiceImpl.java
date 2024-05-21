package com.ssafy.travelcompass.review.model.service.like;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.travelcompass.review.model.dto.like.ReviewLikeDto;
import com.ssafy.travelcompass.review.model.mapper.ReviewLikeMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class ReviewLikeServiceImpl implements ReviewLikeService{

	private final ReviewLikeMapper reviewLikeMapper;

	@Override
	public void toggleLike(ReviewLikeDto like) throws Exception {
		if(isLiked(like.getTripReviewId(), like.getUserId())) {
			System.out.println("아아아");
			reviewLikeMapper.deleteLike(like);
		}
		else {
			System.out.println("dbdbdb");
			reviewLikeMapper.saveLike(like);
		}
	}

	@Override
	public boolean isLiked(int tripReviewId, int userId) throws Exception {
		ReviewLikeDto reviewLikeDto = ReviewLikeDto.builder()
										.tripReviewId(tripReviewId)
										.userId(userId)
										.build();
		return reviewLikeMapper.isLiked(reviewLikeDto);
	}
	
	
}
