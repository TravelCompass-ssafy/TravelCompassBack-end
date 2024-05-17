package com.ssafy.travelcompass.auth.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestNewPassword {
	private String email;
	private String authNum;
	
	public RequestNewPassword(String email, String authNum) {
		super();
		this.email = email;
		this.authNum = authNum;
	}
	
}
