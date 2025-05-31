package com.example.springenshu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springenshu.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
