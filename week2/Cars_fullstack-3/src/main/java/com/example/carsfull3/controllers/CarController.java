package com.example.carsfull3.controllers;

import java.util.List;

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

import com.example.carsfull3.models.Car;
import com.example.carsfull3.models.User;
import com.example.carsfull3.services.CarService;
import com.example.carsfull3.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CarController {
	@Autowired
	private CarService carServ;
	@Autowired
	private UserService userServ;
	
	@GetMapping("/cars")
	public String home(Model model, HttpSession session) {
		//route garde
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		
		List<Car> allCars = carServ.allCars();
		model.addAttribute("allCars",allCars);
		return "home.jsp";
	}
	
	//create
	@GetMapping("/cars/new")
	public String createCar(@ModelAttribute("car") Car car,
							HttpSession session) 
	{
		//route garde
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		return "new.jsp";
	}
	
	@PostMapping("/processCar")
	public String createCar(@Valid @ModelAttribute("car") Car car,
							BindingResult result,
							HttpSession session)
	{
		//route garde
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) { return "new.jsp"; }
		else {
			//! grab the user by their id
			User user = userServ.findUserById(userId);
			//! set the car's owner as the current loggedin user
			car.setOwner(user);
			Car newCar = carServ.createCar(car);
			return "redirect:/cars/show/" + newCar.getId();
		}
	}
	
	// show one
	@GetMapping("/cars/show/{id}")
	public String home(@PathVariable("id") Long id, Model model, HttpSession session) {
		//route garde
				Long userId = (Long) session.getAttribute("user_id");
				if (userId == null) {
					return "redirect:/";
				}
		Car car = carServ.findCarById(id);
		model.addAttribute("car",car);
		return "show.jsp";
	}
	
	// EDIT
	@GetMapping("/cars/edit/{id}")
	public String updateCar(Model model, @PathVariable("id") Long id, HttpSession session) {
		//route garde
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		// find the car by the id
		Car selectedcar = carServ.findCarById(id);
		model.addAttribute("car", selectedcar);
		return "edit.jsp";
	}
	
	@PutMapping("/cars/update/{id}")
	public String editCar(@Valid @ModelAttribute("car") Car car, 
							BindingResult result,
							HttpSession session,
							@PathVariable("id") Long id) {
		//route garde
				Long userId = (Long) session.getAttribute("user_id");
				if (userId == null) {
					return "redirect:/";
				}
				
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			User user = userServ.findUserById(userId);
			Car oldCar = carServ.findCarById(id);
			if (user.getId() == oldCar.getOwner().getId()) {
				car.setOwner(user);
				carServ.updateCar(car);
			}
			return "redirect:/cars";
		}
	}
	
	//delete
	@DeleteMapping("/cars/{id}")
	public String deleteCar(@PathVariable("id") Long id, HttpSession session) {
		//route garde
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		
		carServ.deleteCar(id);
		return "redirect:/cars";
	}
	
	
}
