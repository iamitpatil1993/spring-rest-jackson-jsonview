package com.example.jackson.jsonview.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.jackson.jsonview.model.User;

@Repository
public interface UserRepository {

	public List<User> getAll();
}