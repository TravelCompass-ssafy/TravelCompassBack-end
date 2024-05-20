package com.ssafy.travelcompass.review.model.service.review;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.travelcompass.exception.custom.isNotMemberException;
import com.ssafy.travelcompass.review.model.dto.review.RequestWriteReview;
import com.ssafy.travelcompass.review.model.dto.review.TripReviewDto;
import com.ssafy.travelcompass.review.model.mapper.ReviewMapper;
import com.ssafy.travelcompass.review.model.service.image.ReviewImageFileService;
import com.ssafy.travelcompass.review.model.service.tag.ReviewTagService;
import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	private final ReviewMapper reviewMapper;
	private final ReviewTagService reviewTagService;
	private final MemberService memberService;
	private final ReviewImageFileService reviewImageFileService;
	
	@Override
	public void writeReview(RequestWriteReview  requestWriteReview) throws Exception {
		TripDetailMemberDto member = memberService.findByUserId(requestWriteReview.getUserId());
		if(member == null) {
			throw new isNotMemberException();
		}
		else {
			TripReviewDto tripReviewDto = new TripReviewDto();
			tripReviewDto.setUserId(requestWriteReview.getUserId());
			tripReviewDto.setContentId(requestWriteReview.getContentId());
			tripReviewDto.setTripDetailId(requestWriteReview.getTripDetailId());
			tripReviewDto.setContent(requestWriteReview.getContent());
			tripReviewDto.setStar(requestWriteReview.getStar());
			
			reviewMapper.writeReview(tripReviewDto);
			reviewTagService.addTagListByReviewId(tripReviewDto.getTripReviewId(), requestWriteReview.getReviewTagList());
			reviewImageFileService.saveImage(tripReviewDto.getTripReviewId(), requestWriteReview.getReviewImageList());
			
		}
	}
}
