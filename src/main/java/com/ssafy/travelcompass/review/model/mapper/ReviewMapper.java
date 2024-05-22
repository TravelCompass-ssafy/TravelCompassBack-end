package com.ssafy.travelcompass.review.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.review.model.dto.review.TripReviewDto;

@Mapper
public interface ReviewMapper {
	void writeReview(TripReviewDto tripReviewDto) throws SQLException;

	List<TripReviewDto> getReviews(Map<String, Object> map) throws SQLException;

	List<TripReviewDto> getReviewsByTripDetailId(int tripDetailId) throws SQLException;

	TripReviewDto findById(int tripReviewId) throws SQLException;

	boolean isValid(Map<String, Object> map) throws SQLException;

	void deleteReviewById(int tripReviewId) throws SQLException;

	void updateReviewById(TripReviewDto tripReviewDto) throws SQLException;

	List<TripReviewDto> getReviewsByUserId(int userId) throws SQLException;
}
