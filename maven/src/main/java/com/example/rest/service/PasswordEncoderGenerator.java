package com.example.rest.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderGenerator implements PasswordEncoder {
	
//	@Override
	public String encryptPassword(String plainTextPassword) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(plainTextPassword);
			System.out.println(hashedPassword);
			return hashedPassword;
	  }


}
