package com.Burger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.Burger.models.Burger;
import com.Burger.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	
	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/")
	public String index(Model model,@ModelAttribute("burger")Burger burger) {
		model.addAttribute("burgers",burgerService.allBurgers());
		return "index";
	}
	
	@PostMapping("/")
	public String crateBurger(@Valid @ModelAttribute("burger")Burger burger,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("burgers",burgerService.allBurgers());
			return"index";
		}
		
		burgerService.createBurger(burger);
		return"redirect:/";
	}
	
	@GetMapping("/burgers/edit/{id}")
	public String edit(@PathVariable("id")Long id,@ModelAttribute("burger")Burger burger,Model model) {
		model.addAttribute("burger",burgerService.getBurger(id));
		return "editBurger";
	}
	
	@PutMapping("/burgers/edit/{id}")
	public String update(@PathVariable("id")Long id,@Valid @ModelAttribute("burger")Burger burger,BindingResult result) {
		if(result.hasErrors()) {
			return "editBurger";
		}
		burgerService.updateBurger(id, burger);
		return "redirect:/";
	}
}
