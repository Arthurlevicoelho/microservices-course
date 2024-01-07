package com.arthurlevi.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arthurlevi.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
