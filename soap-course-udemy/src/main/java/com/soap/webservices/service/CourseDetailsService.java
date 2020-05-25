package com.soap.webservices.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.soap.webservices.bean.Course;

@Component
public class CourseDetailsService {

	public enum Status {
		SUCCESS, FAILURE
	};

	private static List<Course> courses = new ArrayList<Course>();

	static {
		Course course1 = new Course(1, "Name1", "Description 11");
		Course course2 = new Course(2, "Name2", "Description 22");
		Course course3 = new Course(3, "Name3", "Description 33");
		Course course4 = new Course(4, "Name4", "Description 44");
		courses.add(course1);
		courses.add(course2);
		courses.add(course3);
		courses.add(course4);

	}

	public Course findById(int id) {
		for (Course course : courses) {
			if (course.getId() == id)
				return course;
		}
		return null;
	}

	public List<Course> findAll() {
		return courses;
	}

	public Status deleteById(int id) {
		Iterator<Course> it = courses.iterator();
		while (it.hasNext()) {
			Course course = (Course) it.next();
			if (course.getId() == id) {
				it.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}
}
