package org.cause4code.jackson.jsonview.model;

import java.io.Serializable;
import java.util.Calendar;

import org.cause4code.jackson.jsonview.view.View;

import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {

	private static final long serialVersionUID = -353971991551040124L;
	
	// This will make this field part of External View
	@JsonView(value = {View.UserView.External.class, View.UserView.PUT.class})
	private Integer id;
	
	@JsonView(value = {View.UserView.External.class, View.UserView.Post.class, View.UserView.PUT.class})
	private String firstName;
	
	@JsonView(value = {View.UserView.External.class, View.UserView.Post.class, View.UserView.PUT.class})
	private String lastName;
	
	@JsonView(value = {View.UserView.Internal.class, View.UserView.Post.class})
	private String ssn;
	
	@JsonView(value = {View.UserView.Internal.class, View.UserView.Post.class})
	private Calendar dob;
	
	// This will make this field part of Internal View
	@JsonView(value = {View.UserView.Internal.class, View.UserView.Post.class, View.UserView.PUT.class})
	private String mobileNo;
	
	@JsonView(View.UserView.External.class)
	private Calendar createdOn;
	
	@JsonView(View.UserView.External.class)
	private Calendar updatedOn;
	
	private boolean isDeleted;

}
