package com.ssafy.travelcompass.exception.custom;

import org.springframework.http.HttpStatus;

import com.ssafy.travelcompass.exception.CustomException;

public class MemberDuplicationException extends CustomException {
	
	private static final long serialVersionUID = 1L;

	public MemberDuplicationException() {
		super("이미 동행자입니다.", HttpStatus.CONFLICT);
	}
}
