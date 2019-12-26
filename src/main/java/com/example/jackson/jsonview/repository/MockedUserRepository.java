package com.example.jackson.jsonview.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.jackson.jsonview.model.User;

@Repository
public class MockedUserRepository implements UserRepository {

	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			users.add(createMockedUser(i));
		}
		return users;
	}

	private User createMockedUser(int i) {
		final User user = new User();
		user.setId(i);
		user.setCreatedOn(Calendar.getInstance());
		user.setDeleted(false);
		user.setDob(Calendar.getInstance());
		user.setFirstName(UUID.randomUUID().toString());
		user.setLastName(UUID.randomUUID().toString());
		user.setMobileNo("123123123");
		user.setSsn(UUID.randomUUID().toString());
		user.setUpdatedOn(Calendar.getInstance());
		return user;
	}

}
