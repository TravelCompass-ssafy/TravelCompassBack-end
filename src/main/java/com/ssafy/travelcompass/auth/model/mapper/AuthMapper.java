package com.ssafy.travelcompass.auth.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.travelcompass.auth.model.dto.UserDto;

@Mapper
public interface AuthMapper {
	List<UserDto> getUser();
}
