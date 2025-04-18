package com.example.carsfull3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.loginandregister.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CarController {
	@Autowired
	private CarService carServ ;
	@Autowired
	private UserService userServ;
	
	
	@GetMapping("/cars")
	public String home (Model model ,HttpSession session) {
		//route garde
		Long userId=(Long) session.getAttribute("user_id");
		if (userId==null) {
			return "redirect:/";
		}
		List<Car> allCars = carServ.allCars();
		model.addAttribute("allCars",allCars);
		return "home.jsp";
	}
	
	@GetMapping("/cars/new")
	public String createCar( Car car,HttpSession session
			) {
		Long userId=(Long) session.getAttribute("user_id");
		if (userId==null) {
			return "redirect:/";
		}
		
			return "new.jsp";
		
	}
	@PostMapping("/processCar")
	public String createCar(@Valid @ModelAttribute("car") Car car, BindingResult result ,
			HttpSession session){
				Long userId=(Long) session.getAttribute("user_id");
				if (userId==null) {
					return "redirect:/";
				}
				if (result.hasErrors()) {
					return "new.jsp";
				}else {
					User user=userServ.findUserById(userId);
					car.setOwner(user);
					Car newCar = carServ.createCar(car);
					return "redirect:/cars/show/"+newCar.getId();
				}
				
			}
			
	//show one 
	@GetMapping("/cars/show/{id}")
	public String home (@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId=(Long) session.getAttribute("user_id");
		if (userId==null) {
			return "redirect:/";
		}
		Car car =carServ.findCarById(id);
		model.addAttribute("car",car);
		return "show.jsp";
	}
	
	// Edit 
	@GetMappping("/cars/edit/{id}")
	public String updateCar(Model model,@PathVariable("id") Long id , HttpSession session) {
		Long userId=(Long) session.getAttribute("user_id");
		if (userId==null) {
			return "redirect:/";
		}
		Car selectedCar=carServ.findCarById(id);
		model.addAttribute("car",selectedCar);
		return "edit.jsp";
	}
	@PutMapping("/cars/update/{id}")
	public String editCar() {
		return"";
	}
			
}
