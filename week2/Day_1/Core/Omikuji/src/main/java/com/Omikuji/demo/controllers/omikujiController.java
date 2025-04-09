package com.Omikuji.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class omikujiController {
	@GetMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/postForm")
		public String postForm( @RequestParam(value="numb") int numb,
				@RequestParam(value="city") String city,
				@RequestParam(value="name") String name,
				@RequestParam(value="prof") String prof,
				@RequestParam(value="thing") String thing,
				@RequestParam(value="nice") String nice,HttpSession session){
		session.setAttribute("numb", numb);
		session.setAttribute("name", name);
		session.setAttribute("prof", prof);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);
		session.setAttribute("city", city);
			
		return "redirect:/omikuji/show";
		
	}
	
	@GetMapping("/omikuji/show")
	public String show() {
		return "show.jsp";
	}
	
}
