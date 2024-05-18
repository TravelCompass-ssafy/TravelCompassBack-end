package com.ssafy.travelcompass.exception;

import java.sql.SQLException;

import javax.mail.MessagingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> handleCustomException(CustomException ex) {
		log.error(ex.getMessage());
		return ResponseEntity.status(ex.getHttpStatus()).body(ex.getMessage());
	}
	
	@ExceptionHandler(MessagingException.class)
	public ResponseEntity<?> handleMessagingException(MessagingException ex) {
		log.error(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("메시지 전송 에러");
	}
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<?> handleSQLException(SQLException ex) {
		log.error(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("SQL 에러");
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> runtimException(RuntimeException ex) {
		log.error(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("런타임에러");
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception ex) {
		log.error(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("서버에러");
	}
}
