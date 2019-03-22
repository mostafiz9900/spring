package com.coderbd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
@Id 
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

private String name;
private String userName;
private String password;

public Student() {
	super();
}

public Student(Long id, String name, String userName, String password) {
	super();
	this.id = id;
	this.name = name;
	this.userName = userName;
	this.password = password;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", userName=" + userName + ", password=" + password + "]";
}


}
