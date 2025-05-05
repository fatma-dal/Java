package com.loginandregister.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.loginandregister.models.Course;



public interface CourseRepo extends CrudRepository<Course,Long> {
	List<Course> findAll(); 

}
