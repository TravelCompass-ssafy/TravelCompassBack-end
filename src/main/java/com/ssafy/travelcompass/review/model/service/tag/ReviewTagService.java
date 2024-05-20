package com.ssafy.travelcompass.review.model.service.tag;

import java.util.List;

public interface ReviewTagService {

	void addTagListByReviewId(int tripReviewId, List<String> reviewTagList) throws Exception;

}
