package com.example.task.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.task.entity.Users;
import com.example.task.repository.UsersRepository;

@Service
public class UsersService implements UserDetailsService{
	
	private UsersRepository usersRepository;
	
//	@Autowired
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Users> user = usersRepository.findByUsername(username);
		
		return User.withUsername(user.get().getUsername())
			   .password(user.get().getPassword())
			   .roles(user.get().getRole())
			   .build();
		
	}
}
