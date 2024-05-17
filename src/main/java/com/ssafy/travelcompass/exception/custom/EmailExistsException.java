package com.ssafy.travelcompass.exception.custom;

import org.springframework.http.HttpStatus;

import com.ssafy.travelcompass.exception.CustomException;

public class EmailExistsException extends CustomException {
	
	private static final long serialVersionUID = 1L;


	public EmailExistsException() {
		super("이미 존재하는 이메일 입니다.", HttpStatus.CONFLICT);
	}
}
