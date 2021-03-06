package com.devsuperior.workshopmongo.dto;

import java.io.Serializable;

import com.devsuperior.workshopmongo.domain.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;

	public UserDTO() {
		super();
	}

	public UserDTO(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public UserDTO(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User toEntity() {
		return new User(null, this.name, this.email);
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
