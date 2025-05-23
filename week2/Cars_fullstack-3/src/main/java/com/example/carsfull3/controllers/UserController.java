package com.example.carsfull3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.carsfull3.models.LoginUser;
import com.example.carsfull3.models.User;
import com.example.carsfull3.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


//TODO - add all this class
@Controller
public class UserController {

   @Autowired
   private UserService userServ;
  
  @GetMapping("/")
  public String index(Model model) {
  
      // Bind empty User and LoginUser objects to the JSP
      // to capture the form input
      model.addAttribute("newUser", new User());
      model.addAttribute("newLogin", new LoginUser());
      return "index.jsp";
  }
  
  @PostMapping("/register")
  public String register(@Valid @ModelAttribute("newUser") User newUser, 
          BindingResult result, Model model, HttpSession session) {
      
      // call a register method in the service to do some
      // extra validations and create a new user!
      userServ.register(newUser, result);
      if(result.hasErrors()) {
          // Be sure to send in the empty LoginUser before 
          // re-rendering the page.
          model.addAttribute("newLogin", new LoginUser());
          return "index.jsp";
      }
      
      // No errors! 
      // Store their ID from the DB in session, 
      // in other words, log them in.
      session.setAttribute("user_id", newUser.getId());
      return "redirect:/cars";
  }
  
  @PostMapping("/login")
  public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
          BindingResult result, Model model, HttpSession session) {
      
       User user = userServ.login(newLogin, result);
  
      if(result.hasErrors()) {
          model.addAttribute("newUser", new User());
          return "index.jsp";
      }
  
      // No errors! 
      // Store their ID from the DB in session, 
      // in other words, log them in.
      session.setAttribute("user_id", user.getId());
      return "redirect:/cars";
  }
  
  @GetMapping("/logout")
  public String logout(HttpSession session) {
	  session.invalidate();
  	return "redirect:/";
  }
  
}
