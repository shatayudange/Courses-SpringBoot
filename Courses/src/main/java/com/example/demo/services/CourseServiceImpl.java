package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;

@Service
public class CourseServiceImpl implements CoursesService {

	List<Course> list;
	public CourseServiceImpl() {
		
		list=new ArrayList<>();
		list.add(new Course(1,"Java core","This is a example of java core"));
		list.add(new Course(2,"Spring boot","This is a example of spring boot"));
	}
	
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}


	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}


	@Override
	public Course addCourse(Course course) {
		list.add(course);
		
		return course;
	}


	@Override
	public Course updateCourse(Course oneCourse) {
		
		
		for(Course course :list) {
		if(course.getId()== oneCourse.getId()) {
			course.setTitle(oneCourse.getTitle());
			course.setDescription(oneCourse.getDescription());
			break;
		}
		}
		return oneCourse;
	}


	@Override
	public String deleteCourse(long courseId) {
		
		
		
		for (Course course:list) {
			if(course.getId()==courseId) {
				list.remove(course);
				break;
			}
		}
		return "Deleted Succesfully";
	}

	
	
}
