package com.kushkumardhawan.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All Details of User")
public class User {
	
	private Integer Id;
	
	@Size(min=6, message = "Name should have Atlest 6 characters")
	private String Name;
	
	@Past
	@ApiModelProperty(notes="Birth Date should be in the Past")
	private Date BirthDate;
	
	
	
	protected User() {
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		Id = id;
		Name = name;
		BirthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", BirthDate=" + BirthDate + "]";
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(Date birthDate) {
		BirthDate = birthDate;
	}
	
	
	
	

}
