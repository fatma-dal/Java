package com.example.carsfull3.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.carsfull3.models.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>{
	List<Car> findAll();
}
