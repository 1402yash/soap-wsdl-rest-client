package com.soap.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SoapCourseUdemyClientApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SoapCourseUdemyClientApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SoapCourseUdemyClientApplication.class);
	}

}
