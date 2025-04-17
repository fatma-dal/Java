package com.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojosandninjas.models.Ninja;
import com.dojosandninjas.services.DojoService;
import com.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/ninjas/new")
	public String getNinjaForm(@ModelAttribute("ninja")Ninja ninja,Model model) {
		model.addAttribute("dojos",dojoService.allDojo());
		return "ninjaNew";
	}
	
	@PostMapping("/ninjas/new")
	public String saveNinja(@Valid @ModelAttribute("ninja")Ninja ninja,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos",dojoService.allDojo());
			return "ninjaNew";
		}
		ninjaService.create(ninja);
		return "redirect:/ninjas/new";
	}
}
