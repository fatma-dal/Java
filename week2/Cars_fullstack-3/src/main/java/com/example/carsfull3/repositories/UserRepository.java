package com.example.carsfull3.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.carsfull3.models.User;


//TODO - add all this interface
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	// for logging user
	Optional<User> findByEmail(String email);
}
