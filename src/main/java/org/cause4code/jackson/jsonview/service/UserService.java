package org.cause4code.jackson.jsonview.service;

import java.util.List;

import org.cause4code.jackson.jsonview.model.User;
import org.cause4code.jackson.jsonview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author amipatil
 *
 */
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
