package com.ssafy.travelcompass.exception.custom;

import org.springframework.http.HttpStatus;

import com.ssafy.travelcompass.exception.CustomException;

public class UserNotFoundException extends CustomException {

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super("존재하지 않는 유저입니다.", HttpStatus.NOT_FOUND);
	}
}
