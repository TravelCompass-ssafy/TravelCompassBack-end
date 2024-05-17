package com.ssafy.travelcompass.exception.custom;

import org.springframework.http.HttpStatus;

import com.ssafy.travelcompass.exception.CustomException;

public class UnAuthorizedException extends CustomException {
	
	
	public UnAuthorizedException() {
		super("권한이 없습니다.", HttpStatus.UNAUTHORIZED);
		
	}
}
