package com.ssafy.travelcompass.exception.custom;

import org.springframework.http.HttpStatus;

import com.ssafy.travelcompass.exception.CustomException;

public class isNotMemberException extends CustomException {
	
	private static final long serialVersionUID = 1L;

	public isNotMemberException() {
		super("여행 멤버가 아닙니다.", HttpStatus.FORBIDDEN);
	}

}
