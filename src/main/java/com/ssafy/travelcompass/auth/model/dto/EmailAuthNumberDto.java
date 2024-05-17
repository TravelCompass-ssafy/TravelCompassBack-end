package com.ssafy.travelcompass.auth.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmailAuthNumberDto {

	private int emailAuthNumberId;
	private String authNum;
	
	public EmailAuthNumberDto(int emailAuthNumberId, String authNum) {
		this.emailAuthNumberId = emailAuthNumberId;
		this.authNum = authNum;
	}
}
