package com.example.jackson.jsonview.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.jackson.jsonview.model.User;
import com.example.jackson.jsonview.service.UserService;
import com.example.jackson.jsonview.view.View;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class UserController {

	private UserService userService;

	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/int/users")
	@ResponseStatus(code = HttpStatus.OK)
	// Spring supports @JsonView annotation to define view to be used to serialize
	// object using ObjectMapper [In case of Json response]
	// Since this is this end point is for internal users, we define view to be
	// Internal
	@JsonView(value = View.UserView.Internal.class)
	public List<User> getAllInternal() {
		return userService.getAllUsers();
	}

	@GetMapping("/ext/users")
	@ResponseStatus(code = HttpStatus.OK)
	// Since this is this end point is for internal users, we define view to be
	// External
	@JsonView(value = View.UserView.External.class)
	public List<User> getAllExternal() {
		return userService.getAllUsers();
	}
}
