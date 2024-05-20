package com.ssafy.travelcompass.review.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.review.model.dto.image.ReviewImageFileDto;

@Mapper
public interface ReviewImageFileMapper {

	void addImageByTripReviewId(Map<String, Object> map) throws SQLException;

	List<ReviewImageFileDto> findByTripReviewId(int tripReviewId) throws SQLException;

}
