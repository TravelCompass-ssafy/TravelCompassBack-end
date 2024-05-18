package com.ssafy.travelcompass.exception.custom;

import org.springframework.http.HttpStatus;

import com.ssafy.travelcompass.exception.CustomException;

public class InvalidPassword extends CustomException {

	private static final long serialVersionUID = 1L;

	public InvalidPassword() {
		super("유효하지 않은 패스워드입니다.", HttpStatus.UNAUTHORIZED);
	}

}
