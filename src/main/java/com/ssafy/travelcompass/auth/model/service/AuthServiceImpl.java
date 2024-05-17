package com.ssafy.travelcompass.auth.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.travelcompass.auth.model.dto.UserDto;
import com.ssafy.travelcompass.auth.model.mapper.AuthMapper;

@Service
public class AuthServiceImpl implements AuthService {
	
	private AuthMapper authMapper;
	
	@Autowired
	public AuthServiceImpl(AuthMapper authMapper) {
		super();
		this.authMapper = authMapper;
	}

	@Override
	public List<UserDto> getUser() {
		return authMapper.getUser();
	}

}
