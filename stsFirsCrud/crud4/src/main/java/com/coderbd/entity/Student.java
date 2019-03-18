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
	
	@Column(name="email")
	private String emain;
	
	@Column(name="pass")
	private String pass;
	
	public Student() {
		super();
	}

	public Student(Long id, String name, String emain, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.emain = emain;
		this.pass = pass;
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

	public String getEmain() {
		return emain;
	}

	public void setEmain(String emain) {
		this.emain = emain;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", emain=" + emain + ", pass=" + pass + "]";
	}
	
	
	
}
