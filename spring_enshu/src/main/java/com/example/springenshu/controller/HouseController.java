package com.example.springenshu.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springenshu.entity.House;
import com.example.springenshu.entity.User;
import com.example.springenshu.service.HouseService;

@RestController
public class HouseController {
	
	private final HouseService houseService;
	
	public HouseController(HouseService houseService) {
		this.houseService = houseService;
	}
	
	@GetMapping("house/{id}")
	public Optional<House> getHouseById(@PathVariable int id) {
		return houseService.getHouseById(id);
	}
	
	@PostMapping("user/add")
	public boolean addUser(@RequestBody User user) {
		return houseService.addUser(user);
	}

}
