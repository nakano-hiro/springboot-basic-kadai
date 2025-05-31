package com.example.springenshu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.springenshu.entity.House;
import com.example.springenshu.entity.User;
import com.example.springenshu.repository.HouseRepository;
import com.example.springenshu.repository.UserRepository;

@Service
public class HouseService {
	
	private final HouseRepository houseRepository;
	private final UserRepository userRepository;
	
	@Value("${id}")//プロパティファイルから取得。今回はidって名前の=の後の値を取得
	private int idfromProperties;
	
	public HouseService(HouseRepository houseRepository, UserRepository userRepository) {
		this.houseRepository = houseRepository;
		this.userRepository = userRepository;
	}
	
	
	public Optional<House> getHouseById(int id) {
//		House house = new House();
//		house.setAddress("千葉県");
//		return house; 
		
		return houseRepository.findById(idfromProperties);
	
	}
	
	public boolean addUser(User user) {
		userRepository.save(user);
		return true;
	}

}
