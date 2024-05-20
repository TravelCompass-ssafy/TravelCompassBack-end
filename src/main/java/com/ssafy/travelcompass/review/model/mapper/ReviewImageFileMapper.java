package com.ssafy.travelcompass.review.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewImageFileMapper {

	void addImageByTripReviewId(Map<String, Object> map) throws Exception;

}
