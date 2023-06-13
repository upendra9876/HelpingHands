package com.helpinghands.HelpingHands;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class HelpingHandsApplication {
	public void init(){
		// Setting Spring Boot SetTimeZone
		//TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}

	public static void main(String[] args) {
		SpringApplication.run(HelpingHandsApplication.class, args);
	}

}
