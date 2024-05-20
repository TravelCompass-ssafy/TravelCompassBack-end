package com.ssafy.travelcompass.review.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.review.model.dto.comment.ReviewCommentDto;

@Mapper
public interface ReviewCommentMapper {

	public List<ReviewCommentDto> getCommentsByTripReviewId(Map<String, Object> map) throws SQLException;

	public List<ReviewCommentDto> getRepliesByParentReviewCommentId(int reviewCommentId) throws SQLException;

}
