package com.Counter.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CounterController {
	@RequestMapping("/your_server")
	public String index(HttpSession session) {
		if(session.getAttribute("counter")==null) {
			session.setAttribute("counter",0);
			
		}
		session.setAttribute("counter", (int) session.getAttribute("counter")+1);
		return "index.jsp";
	}
	
	@RequestMapping("/your_server/counter")
	public String counter() {
		return "counter.jsp";
	}
	
	@RequestMapping("/counterTwo")
		public String countTwo(HttpSession session) {
			session.setAttribute("counter",(int) session.getAttribute("counter")+2);
			return "redirect:/your_server/counter";
		}
	
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		session.removeAttribute("counter");
		return "redirect:/your_server";
	}
	
}
