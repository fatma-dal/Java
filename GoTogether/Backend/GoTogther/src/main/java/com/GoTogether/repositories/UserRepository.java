package com.GoTogether.repositories;

import com.GoTogether.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	 Optional<User> findByEmail(Object object);
	 Optional<User> findById(long id);
	 User deleteById(long id);
}

