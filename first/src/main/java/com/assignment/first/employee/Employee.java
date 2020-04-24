package com.assignment.first.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	private int id;

	@NotBlank
	@NotEmpty
	private String name;

	@Email
	@Column(unique = true)
	private String email;

	private String location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Employee(int id, @NotBlank @NotEmpty String name, @Email String email, String location) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.location = location;
	}

	public Employee() {

	}

}
