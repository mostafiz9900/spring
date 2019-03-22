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
	public String view() {
		
		return "index";
	}
	
	@GetMapping(value="/list")
	public String viewList(Model model) {
		model.addAttribute("list", this.repo.findAll());
		
		return "list-page";
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
		model.addAttribute("student", new Student());		
		return "add-page";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editView(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("student", this.repo.findById(id));
		return "edit-page";
	}
	
	@PostMapping(value="/edit/{id}")
	public String edit(@Valid Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "edit-page";
		}
		this.repo.save(student);				
		return "redirect:/list";
	}
	
	@GetMapping(value="/del/{id}")
	public String dele(@PathVariable("id") Long id, Model model) {
		if (id !=null) {
			this.repo.deleteById(id);
		}
				
		return "redirect:/list";
	}
}
