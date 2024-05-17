package com.ssafy.travelcompass.exception.custom;

import org.springframework.http.HttpStatus;

import com.ssafy.travelcompass.exception.CustomException;

public class LoginFailedException extends CustomException {
	
	private static final long serialVersionUID = 1L;

	public LoginFailedException() {
		super("아이디 또는 패스워드 확인이 필요합니다.", HttpStatus.UNAUTHORIZED);
	}

}
