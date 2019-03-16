package com.coderbd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderbd.entity.Student;
import com.coderbd.repository.StudentRepository;

@Controller
public class StudentController {
 @Autowired
	private StudentRepository repo;
	
	@GetMapping(value="/")
	private String view(Model model) {
		model.addAttribute("list", this.repo.findAll());
	return "index";
	
}
	
	@GetMapping(value="/add")
	private String addView(Student student) {		
	return "add-page";
	
}
	@PostMapping(value="/add")
	private String add(@Valid Student student, BindingResult result, Model model ) {
	if (result.hasErrors()) {
		
		return "add-page";
	}
	this.repo.save(student);
	model.addAttribute("student", new Student());
	return "add-page";
	
}
	@GetMapping(value="/edit/{id}")
	private String editView(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", this.repo.findById(id));
	return "edit-page";
	
}
	@PostMapping(value="/edit/{id}")
	private String add(@Valid Student student, @PathVariable("id") Long id, BindingResult result, Model model ) {
	if (result.hasErrors()) {
		
		return "edit-page";
	}
	this.repo.save(student);
	
	return "redirect:/";
	
}
	@GetMapping(value="/del/{id}")
	private String delet(@PathVariable("id") Long id, Model model) {
		if (id != null) {
			this.repo.deleteById(id);
			
		}
		return "redirect:/";
	
}
}
