package com.ssafy.travelcompass.auth.model.service;

import java.util.List;

import com.ssafy.travelcompass.auth.model.dto.UserDto;

public interface AuthService {
	List<UserDto> getUser();
}
