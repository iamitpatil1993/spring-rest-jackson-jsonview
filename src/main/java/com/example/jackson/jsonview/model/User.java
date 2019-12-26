package com.example.jackson.jsonview.model;

import java.io.Serializable;
import java.util.Calendar;

import com.example.jackson.jsonview.view.View;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = -353971991551040124L;
	
	// This will make this field part of External View
	@JsonView(View.UserView.External.class)
	private Integer id;
	
	@JsonView(View.UserView.External.class)
	private String firstName;
	
	@JsonView(View.UserView.External.class)
	private String lastName;
	
	@JsonView(View.UserView.Internal.class)
	private String ssn;
	
	@JsonView(View.UserView.Internal.class)
	private Calendar dob;
	
	// This will make this field part of Internal View
	@JsonView(View.UserView.Internal.class)
	private String mobileNo;
	
	@JsonView(View.UserView.External.class)
	private Calendar createdOn;
	
	@JsonView(View.UserView.External.class)
	private Calendar updatedOn;
	
	private boolean isDeleted;

}
