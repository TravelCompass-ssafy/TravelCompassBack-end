package com.ssafy.travelcompass.auth.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RequestEmailVerification {

	private int emailAuthNumberId;
	private String authNumber;
	
	public RequestEmailVerification(int emailAuthNumberId, String authNumber) {
		this.emailAuthNumberId = emailAuthNumberId;
		this.authNumber = authNumber;
	}
}
