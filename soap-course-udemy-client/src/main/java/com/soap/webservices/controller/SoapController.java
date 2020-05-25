package com.soap.webservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.soap.courses.GetAllCourseDetailsRequest;
import com.soap.courses.GetAllCourseDetailsResponse;
import com.soap.courses.GetCourseDetailsRequest;
import com.soap.courses.GetCourseDetailsResponse;
import com.soap.webservices.client.SoapClient;

@RestController
public class SoapController {

	@Autowired
	private SoapClient client;

	@GetMapping("/getCourse/{id}")
	public GetCourseDetailsResponse getCourse(@PathVariable int id) {
		GetCourseDetailsRequest getCourseDetailsRequest = new GetCourseDetailsRequest();
		getCourseDetailsRequest.setId(id);
		return client.getCourse(getCourseDetailsRequest);
	}

	@GetMapping("/getAllCourse")
	public GetAllCourseDetailsResponse getAllCourse() {
		GetAllCourseDetailsRequest getAllCourseDetailsRequest = new GetAllCourseDetailsRequest();
		return client.getAllCourses(getAllCourseDetailsRequest);
	}

}
