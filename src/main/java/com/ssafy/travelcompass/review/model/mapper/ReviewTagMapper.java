package com.ssafy.travelcompass.review.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewTagMapper {

	void addTag(Map<String, Object> map);

}