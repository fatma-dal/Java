package com.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojosandninjas.models.Dojo;
import com.dojosandninjas.services.DojoService;
import com.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	
	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/dojo/new")
	public String getDojoForm(@ModelAttribute("dojo")Dojo dojo) {
		return "dojoNew";
	}
	
	@PostMapping("/dojo/new/delete")
	public String saveDojo(@Valid @ModelAttribute("dojo")Dojo dojo,BindingResult result) {
		if(result.hasErrors()) {
			return "dojoNew";
		}
		dojoService.createDojo(dojo);
		return "redirect:/dojo/new";
	}
	
	@GetMapping("/dojos/{id}")
	public String getDojo(@PathVariable("id")Long id,Model model) {
		Dojo dojo=dojoService.getOne(id);
		model.addAttribute("dojo",dojoService.getOne(id));
		model.addAttribute("ninjas",ninjaService.getByDojoId(id));
		return "showOne";
	}
	
}
