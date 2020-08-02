package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CourseDao;
import com.example.demo.entities.Course;

@Service
public class CourseServiceImpl implements CoursesService {

	@Autowired
	private CourseDao courseDao;
	
	List<Course> list;
	public CourseServiceImpl() {
		
		list=new ArrayList<>();
		list.add(new Course(1,"Java core","This is a example of java core"));
		list.add(new Course(2,"Spring boot","This is a example of spring boot"));
	}
	
	
	@Override
	public List<Course> getCourses() {
		
		return courseDao.findAll();
	}


	@Override
	public Course getCourse(long courseId) {
		/*
		 * Course c = null;
		 * 
		 * for(Course course:list) { if(course.getId()==courseId) { c=course; break; } }
		 */
		return courseDao.getOne(courseId);
	}


	@Override
	public Course addCourse(Course course) {
		courseDao.save(course);
		return course;
	}


	@Override
	public Course updateCourse(Course oneCourse) {
		
		courseDao.save(oneCourse);
		
		return oneCourse;
	}


	@Override
	public String deleteCourse(long courseId) {
		
		courseDao.deleteById(courseId);
		return "Deleted Succesfully";
	}

	
	
}
