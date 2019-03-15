package com.coderbd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderbd.entity.Student;
import com.coderbd.repository.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	private StudentRepository repo;
	
	@GetMapping(value="/")
	public String view(Model model) {
		model.addAttribute("list", this.repo.findAll());
		return "index";
	}
	@GetMapping(value="/add")
	public String addView(Student student) {
		return "add-page";
	}
	@PostMapping(value="/add")
	public String add(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-page";
		}
		this.repo.save(student);
		return "add-page";
	}

}
