package com.ssafy.travelcompass.auth.model.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestEmailAuthNumber {

	private String email;

	public RequestEmailAuthNumber(String email) {
		this.email = email;
	}
}
