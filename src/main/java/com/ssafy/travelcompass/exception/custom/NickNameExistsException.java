package com.ssafy.travelcompass.exception.custom;

import org.springframework.http.HttpStatus;

import com.ssafy.travelcompass.exception.CustomException;

public class NickNameExistsException extends CustomException {

	private static final long serialVersionUID = 1L;
	
	public NickNameExistsException() {
		super("이미 존재하는 닉네임 입니다.", HttpStatus.CONFLICT);
	}
}
