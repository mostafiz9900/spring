package com.coderbd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

@Column(name="name")
private String name;

@Column(name="gender")
private String gender;

@Column(name="subject")
private String subject;

@Column(name="round")
private String round;

@Column(name="notes")
private String notes;

@Column(name="email")
private String email;

@Column(name="user_name")
private String userName;

@Column(name="password")
private String password;



public Student() {
	super();
}



public Student(Long id, String name, String gender, String subject, String round, String notes, String email,
		String userName, String password) {
	super();
	this.id = id;
	this.name = name;
	this.gender = gender;
	this.subject = subject;
	this.round = round;
	this.notes = notes;
	this.email = email;
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



public String getGender() {
	return gender;
}



public void setGender(String gender) {
	this.gender = gender;
}



public String getSubject() {
	return subject;
}



public void setSubject(String subject) {
	this.subject = subject;
}



public String getRound() {
	return round;
}



public void setRound(String round) {
	this.round = round;
}



public String getNotes() {
	return notes;
}



public void setNotes(String notes) {
	this.notes = notes;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
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
	return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", subject=" + subject + ", round=" + round
			+ ", notes=" + notes + ", email=" + email + ", userName=" + userName + ", password=" + password + "]";
}



}
