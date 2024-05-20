package com.ssafy.travelcompass.review.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.review.model.dto.review.TripReviewDto;

@Mapper
public interface ReviewMapper {
	void writeReview(TripReviewDto requestTripReview) throws SQLException;

	void addTag(Map<String, Object> map) throws SQLException;
}
