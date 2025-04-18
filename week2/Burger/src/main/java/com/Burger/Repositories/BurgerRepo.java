package com.Burger.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Burger.models.Burger;

@Repository
public interface BurgerRepo extends CrudRepository<Burger,Long>{
	
	List<Burger> findAll();
}
