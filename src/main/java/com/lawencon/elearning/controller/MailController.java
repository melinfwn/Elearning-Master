package com.lawencon.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lawencon.elearning.service.MailService;

@RestController
@CrossOrigin("*")
public class MailController {

	@Autowired
	private MailService mailService;

	@PostMapping("/mail/send")
	public ResponseEntity<?> sendEmail(@RequestParam("to") String to, @RequestParam("subject") String subject,
			@RequestParam("body") String body) {
		try {
			mailService.sendMail(to, subject, body);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed to send email", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Success", HttpStatus.OK);
	}
}
