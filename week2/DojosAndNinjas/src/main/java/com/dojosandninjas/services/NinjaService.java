package com.dojosandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojosandninjas.models.Ninja;
import com.dojosandninjas.repository.NinjaRepo;

@Service
public class NinjaService {
	
	@Autowired
	NinjaRepo ninjaRepo;
	
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	public List<Ninja> getByDojoId(Long id) {
		return ninjaRepo.findAllByDojoId(id);
	}
	
}
