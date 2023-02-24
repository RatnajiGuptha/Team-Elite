package com.springbootbackendvolunteering.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailOtpService {

	@Autowired
	private JavaMailSender javaMailSender;

	public String generateOtp() {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		System.out.println(otp);
		return String.valueOf(otp);
	}

	public void sendOtp(String email, String otp) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Otp Verification");
		message.setText("Your otp for verfication is: " + otp);
		javaMailSender.send(message);
	}

	public boolean validateOtp(String sessionOtp, String enteredOtp) {
		return sessionOtp.equals(enteredOtp);
	}

	public void waitBeforeResendingOtp() {
		try {
			TimeUnit.SECONDS.sleep(60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
