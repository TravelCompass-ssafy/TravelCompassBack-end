package com.ssafy.travelcompass.review.model.service.tag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.travelcompass.review.model.mapper.ReviewMapper;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class ReviewTagServiceImpl implements ReviewTagService {
	private final ReviewMapper reviewMapper;
	
	@Override
	public void addTagListByReviewId(int tripReviewId, List<String> reviewTagList) throws Exception {
		
		for(String tag: reviewTagList) {
			Map<String, Object> map = new HashMap<>();
			
			map.put("tripReviewId", tripReviewId);
			map.put("tag", tag);
			
			reviewMapper.addTag(map);
		}
		
		
		
	}

}
