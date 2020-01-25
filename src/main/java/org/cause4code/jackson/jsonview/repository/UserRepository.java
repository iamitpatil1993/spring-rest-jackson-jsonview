package org.cause4code.jackson.jsonview.repository;

import java.util.List;

import org.cause4code.jackson.jsonview.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

	public List<User> getAll();
	
	public User save(final User user);
}