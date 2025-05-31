package com.example.springenshu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springenshu.entity.House;

public interface HouseRepository extends JpaRepository<House, Integer> {

}
