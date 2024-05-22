package com.ssafy.travelcompass.review.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.review.model.dto.tag.ReviewTagDto;

@Mapper
public interface ReviewTagMapper {

	void addTag(Map<String, Object> map) throws SQLException;

	List<ReviewTagDto> findByTripReviewId(int tripReviewId) throws SQLException;

	void deleteTagsByReviewId(int tripReviewId) throws SQLException;

}
