package com.soap.webservices.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.courses.CourseDetails;
import com.soap.courses.DeleteCourseDetailsRequest;
import com.soap.courses.DeleteCourseDetailsResponse;
import com.soap.courses.GetAllCourseDetailsRequest;
import com.soap.courses.GetAllCourseDetailsResponse;
import com.soap.courses.GetCourseDetailsRequest;
import com.soap.courses.GetCourseDetailsResponse;
import com.soap.webservices.bean.Course;
import com.soap.webservices.service.CourseDetailsService;
import com.soap.webservices.service.CourseDetailsService.Status;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	CourseDetailsService service;

	@PayloadRoot(namespace = "http://soap.com/courses", localPart = "GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {

		Course course = service.findById(request.getId());

		return mapCourseDetails(course);
	}

	@PayloadRoot(namespace = "http://soap.com/courses", localPart = "DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse processDeleteCourseDetailsRequest(
			@RequestPayload DeleteCourseDetailsRequest request) {

		Status status = service.deleteById(request.getId());
		DeleteCourseDetailsResponse deleteCourseDetailsResponse = new DeleteCourseDetailsResponse();
		deleteCourseDetailsResponse.setStatus(mapStatus(status));
		return deleteCourseDetailsResponse;
	}

	private com.soap.courses.Status mapStatus(Status status) {
		if (status == Status.FAILURE)
			return com.soap.courses.Status.FAILURE;
		return com.soap.courses.Status.SUCCESS;
	}

	private GetCourseDetailsResponse mapCourseDetails(Course course) {
		GetCourseDetailsResponse getCourseDetailsResponse = new GetCourseDetailsResponse();
		getCourseDetailsResponse.setCourseDetails(mapCourse(course));
		return getCourseDetailsResponse;
	}

	private GetAllCourseDetailsResponse mapAllCourseDetails(List<Course> courses) {
		GetAllCourseDetailsResponse getAllCourseDetailsResponse = new GetAllCourseDetailsResponse();
		for (Course course2 : courses) {
			CourseDetails details = mapCourse(course2);
			getAllCourseDetailsResponse.getCourseDetails().add(details);
		}

		return getAllCourseDetailsResponse;
	}

	private CourseDetails mapCourse(Course course) {
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setDescription(course.getDescription());
		courseDetails.setName(course.getName());
		return courseDetails;
	}

	@PayloadRoot(namespace = "http://soap.com/courses", localPart = "GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(
			@RequestPayload GetAllCourseDetailsRequest request) {

		List<Course> allCourses = service.findAll();
		GetAllCourseDetailsResponse getAllCourseDetailsResponse = new GetAllCourseDetailsResponse();
		return mapAllCourseDetails(allCourses);

	}
}
