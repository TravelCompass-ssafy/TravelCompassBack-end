package com.ssafy.travelcompass.review.model.service.tag;

import java.util.List;

import com.ssafy.travelcompass.review.model.dto.tag.ReviewTagDto;

public interface ReviewTagService {

	void addTagListByReviewId(int tripReviewId, List<String> reviewTagList) throws Exception;

	List<ReviewTagDto> findByTripReviewId(int tripReviewId) throws Exception;

	void updateTagListByReviewId(int tripReviewId, List<String> reviewTagList) throws Exception;

}
