package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Course;
import com.example.demo.services.CoursesService;

@RestController
public class MyController {

	@Autowired
	private CoursesService courseServices;
	
	@GetMapping("/home")
	public String testMethod() {
		return "Home Page ";
	}
	
	
	//get all the courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.courseServices.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourseById(@PathVariable String courseId) {
		return this.courseServices.getCourse(Long.parseLong(courseId));
		
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseServices.addCourse(course );
		
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		
		return this.courseServices.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable String courseId) {
		
		String deleteCourse = this.courseServices.deleteCourse(Long.parseLong(courseId));
		
		return  deleteCourse;
		
	}
}
