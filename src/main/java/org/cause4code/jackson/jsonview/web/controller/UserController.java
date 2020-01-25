package org.cause4code.jackson.jsonview.web.controller;

import java.util.List;

import org.cause4code.jackson.jsonview.model.User;
import org.cause4code.jackson.jsonview.service.UserService;
import org.cause4code.jackson.jsonview.view.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	private UserService userService;

	@Autowired
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

	/**
	 * This handler demonstrate use of @JsonView to define view to be used to map
	 * request body to model object. Only fields defined in View get considered
	 * while de-serialization and other fields even though passed, get ignored. This
	 * is useful to control what user can send in which request. For example, user
	 * can not send internal fields like id, createdDate, updatedDate audit details
	 * in model. Those fiels will get ignored since not defined in view. So, this
	 * feature helps is to maintain constraints as well as consistency
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(path = "/users", consumes = { "application/json" })
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<User> post(final @RequestBody @JsonView(value = View.UserView.Post.class) User user) {
		User savedUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}

	/**
	 * JsonView will allow use to control what user can update in update call, so we
	 * do not need to create separe model specific to update call to restrict fields
	 * which user can update. {@link PUT} will allow only few fields to get update.
	 */
	@PutMapping(path = "/users/{userId}", consumes = { "application/json" })
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<?> put(final @RequestBody @JsonView(value = View.UserView.PUT.class) User user,
			@PathVariable Integer userId) {
		user.setId(userId);
		// Update user here
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
