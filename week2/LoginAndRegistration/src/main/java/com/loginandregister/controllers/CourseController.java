package com.loginandregister.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.loginandregister.models.Course;
import com.loginandregister.models.User;
import com.loginandregister.services.CourseService;
import com.loginandregister.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class CourseController {
	@Autowired
	CourseService courseService;
	@Autowired
	UserService userService;
	
	@GetMapping("/classes")
	public String course(HttpSession session,Model model) {
		if (session.getAttribute("user_id")==null) {
			return "redirect:/logout";
		}
		System.out.println(courseService.getAllCourses()+"ygvgjhbjhbh");
		model.addAttribute("user",userService.getUserById((Long)session.getAttribute("user_id")));
		model.addAttribute("course",courseService.getAllCourses());
		
		return"welcome";

	}
	
	@GetMapping("/classes/new")
	public String courseForm(@ModelAttribute("newCourse")Course newcourse,HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/logout";
		}
		return "test";
	}
	
	@PostMapping("/classes/new")
	public String addCourse(@Valid @ModelAttribute("newCourse")Course newCourse,BindingResult result,HttpSession session) {
		if(result.hasErrors()) {
			return "test";
		}
		User user=userService.getUserById((long)session.getAttribute("user_id"));
		System.out.println(session.getAttribute("user_id"));
		newCourse.setUser(user);
		
		courseService.create(newCourse);
		return "redirect:/classes";
	}
	
	
	@GetMapping("/classes/{id}")
	public String showCourse(@PathVariable("id")Long id ,HttpSession session,Model model) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("course",courseService.getOneCourse(id));
		return "showCourse";
	}
	
	@GetMapping("/classes/{id}/edit")
	public String getUpdatePage(@PathVariable("id")Long id,HttpSession session,Model model) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/logout";
		}
		model.addAttribute("newCourse",courseService.getOneCourse(id));
		return "editCourse";
	}
	
	@PutMapping("/classes/{id}/edit")
	public String updateCourse(@Valid @ModelAttribute("newCourse")Course newCourse,BindingResult result,@PathVariable("id")Long id,HttpSession session) {
		if(result.hasErrors()) {
			return "editCourse";
		}
		newCourse.setUser(userService.getUserById((Long)session.getAttribute("user_id")));
		courseService.updateCourse(id, newCourse);
		return "redirect:/classes";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id ) {
		courseService.deleteCourse(id);
		return "redirect:/classes";
	}
	
	
	
}
