package com.ssafy.travelcompass.alarm.model.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmitterRepository {

	// 모든 Emitters를 저장하는 ConcurrentHashMap
    private final Map<Integer, SseEmitter> emitters = new ConcurrentHashMap<>();

    /**
     * 주어진 아이디와 이미터를 저장
     *
     * @param userId      - 사용자 아이디.
     * @param emitter - 이벤트 Emitter.
     */
    public void save(int userId, SseEmitter emitter) {
        emitters.put(userId, emitter);
    }

    /**
     * 주어진 아이디의 Emitter를 제거
     *
     * @param userId - 사용자 아이디.
     */
    public void deleteById(int userId) {
        emitters.remove(userId);
    }

    /**
     * 주어진 아이디의 Emitter를 가져옴.
     *
     * @param userId - 사용자 아이디.
     * @return SseEmitter - 이벤트 Emitter.
     */
    public SseEmitter get(int userId) {
        return emitters.get(userId);
    }
}
