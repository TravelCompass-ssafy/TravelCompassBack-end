package com.ssafy.travelcompass.review.model.service.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.travelcompass.exception.custom.UnAuthorizedException;
import com.ssafy.travelcompass.exception.custom.isNotMemberException;
import com.ssafy.travelcompass.review.model.dto.image.ReviewImageFileDto;
import com.ssafy.travelcompass.review.model.dto.review.RequestWriteReview;
import com.ssafy.travelcompass.review.model.dto.review.TripReviewDto;
import com.ssafy.travelcompass.review.model.dto.tag.ReviewTagDto;
import com.ssafy.travelcompass.review.model.mapper.ReviewMapper;
import com.ssafy.travelcompass.review.model.service.image.ReviewImageFileService;
import com.ssafy.travelcompass.review.model.service.like.ReviewLikeService;
import com.ssafy.travelcompass.review.model.service.tag.ReviewTagService;
import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.service.member.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	private final ReviewMapper reviewMapper;
	private final ReviewTagService reviewTagService;
	private final MemberService memberService;
	private final ReviewImageFileService reviewImageFileService;
	private final ReviewLikeService reviewLikeService;
	
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
	
	@Override
	public void updateReview(RequestWriteReview requestUpdateReview) throws Exception {
		isValid(requestUpdateReview.getTripReviewId(), requestUpdateReview.getUserId());
		
		TripReviewDto tripReviewDto = new TripReviewDto();
		tripReviewDto.setTripReviewId(requestUpdateReview.getTripReviewId());
		tripReviewDto.setContent(requestUpdateReview.getContent());
		tripReviewDto.setStar(requestUpdateReview.getStar());
		
		reviewMapper.updateReviewById(tripReviewDto);
		reviewTagService.updateTagListByReviewId(requestUpdateReview.getTripReviewId(), requestUpdateReview.getReviewTagList());
		reviewImageFileService.updateImage(requestUpdateReview.getTripReviewId(), requestUpdateReview.getReviewImageList());
		
	}

	@Override
	public List<TripReviewDto> getReviews(int offset, int size, String keyword, String category) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("offset", offset);
		map.put("size", size);
		map.put("keyword", keyword);
		map.put("category", category);
		List<TripReviewDto> reviews = reviewMapper.getReviews(map);
		
		for(TripReviewDto review : reviews) {
			
			int tripReviewId = review.getTripReviewId();
			
			List<ReviewTagDto> tags = reviewTagService.findByTripReviewId(tripReviewId);
			List<ReviewImageFileDto> images = reviewImageFileService.findByTripReviewId(tripReviewId);
			boolean isLiked = reviewLikeService.isLiked(review.getTripReviewId(), review.getUserId());
			
			List<String> tagList = tags.stream()
							            .map(ReviewTagDto::getTag)
							            .collect(Collectors.toList());
			
			List<String> imagePathList = images.stream()
												.map(ReviewImageFileDto::getPath)
												.collect(Collectors.toList());
			
			review.setReviewTagList(tagList);
			review.setReviewImageList(imagePathList);
			review.setLikeCheck(isLiked);
		}
		
		return reviews;
	}

	@Override
	public List<TripReviewDto> getReviewsByTripDetailId(int tripDetailId) throws Exception {
		List<TripReviewDto> result =  reviewMapper.getReviewsByTripDetailId(tripDetailId);
		
		for(TripReviewDto review : result) {
			int tripReviewId = review.getTripReviewId();
			
			List<ReviewTagDto> tags = reviewTagService.findByTripReviewId(tripReviewId);
			List<ReviewImageFileDto> images = reviewImageFileService.findByTripReviewId(tripReviewId);
			boolean isLiked = reviewLikeService.isLiked(review.getTripReviewId(), review.getUserId());
			
			List<String> tagList = tags.stream()
							            .map(ReviewTagDto::getTag)
							            .collect(Collectors.toList());
			
			List<String> imagePathList = images.stream()
												.map(ReviewImageFileDto::getPath)
												.collect(Collectors.toList());
			
			review.setReviewTagList(tagList);
			review.setReviewImageList(imagePathList);
			review.setLikeCheck(isLiked);
		}
		
		return result;
	}

	@Override
	public TripReviewDto getReviewById(int tripReviewId) throws Exception {
		TripReviewDto result = reviewMapper.findById(tripReviewId);
		
		List<ReviewTagDto> tags = reviewTagService.findByTripReviewId(tripReviewId);
		List<ReviewImageFileDto> images = reviewImageFileService.findByTripReviewId(tripReviewId);
		
		List<String> tagList = tags.stream()
						            .map(ReviewTagDto::getTag)
						            .collect(Collectors.toList());
		
		List<String> imagePathList = images.stream()
											.map(ReviewImageFileDto::getPath)
											.collect(Collectors.toList());
		
		result.setReviewTagList(tagList);
		result.setReviewImageList(imagePathList);
		
		return result;
	}

	@Override
	public void deleteReview(int userId, int tripReviewId) throws Exception {
		isValid(tripReviewId, userId);
		
		reviewImageFileService.deleteReviewImageByReviewId(tripReviewId);
		
		reviewMapper.deleteReviewById(tripReviewId);
		
	}
	
	public void isValid(int tripReviewId, int userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("tripReviewId", tripReviewId);
		map.put("userId", userId);
		
		log.info(tripReviewId + ", " + userId);
		
		boolean isValid = reviewMapper.isValid(map);
		
		if(!isValid) {
			log.info("아아우우");
			throw new UnAuthorizedException();
		}
		
	}

	

}
