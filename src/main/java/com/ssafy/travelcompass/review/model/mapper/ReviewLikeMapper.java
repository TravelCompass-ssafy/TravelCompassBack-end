package com.ssafy.travelcompass.review.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.review.model.dto.like.ReviewLikeDto;

@Mapper
public interface ReviewLikeMapper {

	boolean isLiked(ReviewLikeDto like) throws SQLException;

	void deleteLike(ReviewLikeDto like) throws SQLException;

	void saveLike(ReviewLikeDto like) throws SQLException;

}
