package com.loginandregister.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginandregister.models.Course;
import com.loginandregister.repositories.CourseRepo;



@Service
public class CourseService {
	@Autowired
	CourseRepo courseRepo;
	
	
	public List<Course> getAllCourses(){
		return courseRepo.findAll();
	}
	
	public Course create (Course newCourse) {
		return courseRepo.save(newCourse);
	}
	
	
	public Course getOneCourse(Long id) {
		Optional<Course> c=courseRepo.findById(id);
		if(c.isEmpty()) {
			return null;
		}
		return c.get();
	}
	
	public Course updateCourse(Long id,Course newCourse) {
		newCourse.setId(id);
		return courseRepo.save(newCourse);
	}
	
	public void deleteCourse(Long id) {
		courseRepo.deleteById(id);
		
	}
	
	
	
	
	

}
