package com.ssafy.travelcompass.review.model.service.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.travelcompass.review.model.dto.tag.ReviewTagDto;
import com.ssafy.travelcompass.review.model.mapper.ReviewTagMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class ReviewTagServiceImpl implements ReviewTagService {
	private final ReviewTagMapper reviewTagMapper;
	
	@Override
	public void addTagListByReviewId(int tripReviewId, List<String> reviewTagList) throws Exception {
		
		for(String tag: reviewTagList) {
			Map<String, Object> map = new HashMap<>();
			
			map.put("tripReviewId", tripReviewId);
			map.put("tag", tag);
			
			reviewTagMapper.addTag(map);
		}
	}

	@Override
	public List<ReviewTagDto> findByTripReviewId(int tripReviewId) throws Exception {
		List<ReviewTagDto> tags = reviewTagMapper.findByTripReviewId(tripReviewId);
		return tags;
	}

	@Override
	public void updateTagListByReviewId(int tripReviewId, List<String> reviewTagList) throws Exception {
		reviewTagMapper.deleteTagsByReviewId(tripReviewId);
		
		addTagListByReviewId(tripReviewId, reviewTagList);
	}

}
