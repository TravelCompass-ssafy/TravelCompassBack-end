package com.ssafy.travelcompass.review.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.review.model.dto.review.TripReviewDto;

@Mapper
public interface ReviewMapper {
	void writeReview(TripReviewDto tripReviewDto) throws SQLException;

}
