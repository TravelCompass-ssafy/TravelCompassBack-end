package com.ssafy.travelcompass.exception.custom;

import org.springframework.http.HttpStatus;

import com.ssafy.travelcompass.exception.CustomException;

public class InvalidEmailAuthTokenException extends CustomException {
	
	private static final long serialVersionUID = 1L;

	public InvalidEmailAuthTokenException() {
		super("유효하지 않은 이메일 인증번호입니다.", HttpStatus.UNAUTHORIZED);
	}
}
