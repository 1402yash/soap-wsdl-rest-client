package com.soap.webservices.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.soap.courses.GetAllCourseDetailsRequest;
import com.soap.courses.GetAllCourseDetailsResponse;
import com.soap.courses.GetCourseDetailsRequest;
import com.soap.courses.GetCourseDetailsResponse;

@Component
public class SoapClient {

	private final static String wsdl = "http://zld03115.vci.att.com:8404/soap-course-udemy/ws";

	@Autowired
	private Jaxb2Marshaller marsherler;

	private WebServiceTemplate template;

	public GetCourseDetailsResponse getCourse(GetCourseDetailsRequest request) {
		template = new WebServiceTemplate(marsherler);
		GetCourseDetailsResponse response = (GetCourseDetailsResponse) template.marshalSendAndReceive(wsdl, request);
		return response;
	}

	public GetAllCourseDetailsResponse getAllCourses(GetAllCourseDetailsRequest getAllCourseDetailsRequest) {
		template = new WebServiceTemplate(marsherler);
		GetAllCourseDetailsResponse response = (GetAllCourseDetailsResponse) template.marshalSendAndReceive(wsdl,
				getAllCourseDetailsRequest);
		return response;
	}

}
