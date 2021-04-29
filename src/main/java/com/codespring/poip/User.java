package com.codespring.poip;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")


public class User {
	

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

@Column(nullable=false, unique=true,length=45)
private String email;

@Column(nullable=false,length=20)
private String firstName;

@Column(nullable=false,length=20)
private String lastName;

@Column(nullable=false,length=20)
private String userType;


@Column(nullable=false,length=64)
private String Password;



public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}



}
