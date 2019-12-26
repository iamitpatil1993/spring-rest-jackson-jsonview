package com.example.jackson.jsonview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jackson.jsonview.model.User;
import com.example.jackson.jsonview.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.getAll();
	}
	
	public User saveUser(final User user) {
		return userRepository.save(user);
	}

}
