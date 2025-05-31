package com.example.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Optional<Users> findByUsername(String username);

}
