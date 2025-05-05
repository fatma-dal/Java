package com.loginandregister.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginandregister.models.LoginUser;
import com.loginandregister.models.User;
import com.loginandregister.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index (Model model) {
		model.addAttribute("newUser",new User());
		model.addAttribute("newLogin",new LoginUser());
		return "index";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser")User newUser,BindingResult result,HttpSession session ,Model model) {
		User user=userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin",new LoginUser());
			return "index";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/classes";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin")LoginUser newLogin,BindingResult result,HttpSession session,Model model) {
		User user=userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser",new User());
			return "index";
		}
		session.setAttribute("user_id", user.getId());
		return "redirect:/classes";
	}
	
	
	
	@GetMapping("/logout")
	public String  logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
