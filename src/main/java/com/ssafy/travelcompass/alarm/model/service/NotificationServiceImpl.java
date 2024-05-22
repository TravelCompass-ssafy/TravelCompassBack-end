package com.ssafy.travelcompass.alarm.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import com.ssafy.travelcompass.alarm.model.repository.EmitterRepository;
import com.ssafy.travelcompass.trip.model.dto.member.TripDetailMemberDto;
import com.ssafy.travelcompass.trip.model.service.member.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
	// 기본 타임아웃 설정
    private static final Long DEFAULT_TIMEOUT = 60L * 1000 * 60;
	
    private final MemberService memberService;
    private final EmitterRepository emitterRepository;
    
	@Override
	public SseEmitter connect(int userId) throws Exception {
		SseEmitter emitter = createEmitter(userId);

        sendToClient(userId, "Connected! [userId=" + userId + "]");
        return emitter;
	}

	@Override
	public void notifyJoinTrip(int tripDetailId) throws Exception {
		sendToTripMembers(tripDetailId);
	}

	private void sendToClient(int id, Object data) {
        SseEmitter emitter = emitterRepository.get(id);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event().name("connect").data(data));
            } catch (IOException exception) {
                emitterRepository.deleteById(id);
                emitter.completeWithError(exception);
            }
        }
    }
	
	private void sendToTripMembers(int tripDetailId) throws Exception {
		System.out.println("아아아" + tripDetailId);
		List<TripDetailMemberDto> members =  memberService.findByTripDetailId(tripDetailId);
		
		for(TripDetailMemberDto member : members) {
			System.out.println("후후후:" + member.getUserId());
			log.info("userId: " + member.getUserId());
			SseEmitter emitter = emitterRepository.get(member.getUserId());
			if(emitter != null) {
				try {
					
					emitter.send(SseEmitter.event().name("notifyJoinTripMember").data(member.getNickName() + "님 께서" + member.getTitle() + "에 가입했습니다."));
				} catch (IOException exception) {
                    emitterRepository.deleteById(member.getUserId());
                    emitter.completeWithError(exception);
                }
			}
		}
	}
	
	private SseEmitter createEmitter(int userId) {
        SseEmitter emitter = new SseEmitter(DEFAULT_TIMEOUT);
        emitterRepository.save(userId, emitter);

        // Emitter가 완료될 때(모든 데이터가 성공적으로 전송된 상태) Emitter를 삭제한다.
        emitter.onCompletion(() -> emitterRepository.deleteById(userId));
        // Emitter가 타임아웃 되었을 때(지정된 시간동안 어떠한 이벤트도 전송되지 않았을 때) Emitter를 삭제한다.
        emitter.onTimeout(() -> emitterRepository.deleteById(userId));

        return emitter;
    }

}
