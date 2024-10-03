package com.mea.encoders;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pwd1 = encoder.encode("rani");
		String pwd2 = encoder.encode("rajesh");
		String pwd3 = encoder.encode("mahesh");
		String pwd4 = encoder.encode("suresh");
		
		System.out.println(pwd1);
		System.out.println(pwd2);
		System.out.println(pwd3);
		System.out.println(pwd4);
	}
}
