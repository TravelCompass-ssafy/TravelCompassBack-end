package com.ssafy.travelcompass.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUpdatePassword {

	private String currentPassword;
	private String newPassword;
}
