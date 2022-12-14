package com.cognixia.jump.model;

import java.util.HashSet;
import java.util.Set;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class User {
	
	public static enum Role{
			USER,
			ADMIN
}

	@Id
	private String userId;
	
	@NotBlank(message= "The user name must not be blank")
	private String username;
	
	@NotBlank
	@Size(max = 20)
	private String password;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@NotBlank(message = "boolean default true")
	private boolean enabled;
	
	private Role role;
	
	
	
	public User() {
		
	}

	public User(String userId, @NotBlank(message = "The user name must not be blank") String username,
			@NotBlank @Size(max = 20) String password, @NotBlank @Size(max = 50) @Email String email, Role role,
			@NotBlank(message = "boolean default true") boolean enabled ) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.enabled = enabled;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", enabled=" + enabled + ", role=" + role + "]";
	}
	
	
	
	
	
	
}
