package com.ssafy.travelcompass.alarm.model.service;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.ssafy.travelcompass.alarm.model.dto.RequestJoinTrip;

public interface NotificationService {

	SseEmitter connect(int userId) throws Exception;

	void notifyJoinTrip(int tripDetailId) throws Exception;

}
