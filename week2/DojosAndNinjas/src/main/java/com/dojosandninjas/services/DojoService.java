package com.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojosandninjas.models.Dojo;
import com.dojosandninjas.repository.DojoRepo;

@Service
public class DojoService {
	
	@Autowired
	DojoRepo dojoRepo;
	
	public List<Dojo> allDojo(){
		return dojoRepo.findAll();
	}
	
	public Dojo getOne(Long id) {
		Optional<Dojo>  dojo=dojoRepo.findById(id);
		if(dojo.isEmpty()) {
			return null;
		}
		return dojo.get();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
}
