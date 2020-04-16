package com.lawencon.elearning.service;

public interface MailService {

	abstract void sendMail(String to, String subject, String body);

}
