package com.ssafy.travelcompass.util.mail;

import javax.mail.MessagingException;

public interface MailSender {
	void sendNewPassword(String email, String password) throws MessagingException;
	String sendEmailAuth(String email) throws MessagingException;
}
