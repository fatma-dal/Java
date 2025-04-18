package com.example.carsfull3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	@Autowired
	private CarRepo carRepo;
	
	
	public Car createCar(Car car) {
		return carRepo.save(car);
	}
	
	//read one
	public Car findCarById(Long id) {
		Optional<Car> optCar = carRepo.findById(id);
		if (optCar.isPresent()) {
			return optCar.get();
		} 
		return null;
	}
	
	// read all 
	public List<Car> allCars() {
		return carRepo.findAll();
		
	}
	
	public Car updateCar(Car car) {
		return carRepo.save(car);
		
	}
	
	// delete
	
	public void deleteCar(Long id) {
		carRepo.deleteById(id);
	}

	
}
