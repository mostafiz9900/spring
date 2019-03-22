package com.coderbd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coderbd.entity.Student;
import com.coderbd.repository.StudentRepository;

@Controller
public class LoginController {
	@Autowired
	private StudentRepository repo;
	
	@GetMapping(value="/log")
	public String logview(Model model, Student student) {
		model.addAttribute("student", student);
		return "login-page";
	}
	@PostMapping(value="/log")
	public String logWork(@RequestParam("userName") String userName, Model model) {
		if (userName != null) {
			try {
				Student student=this.repo.findByUserName(userName);
				if (student.getUserName() != null) {
					return "redirect:/list";
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "login-page";
				// TODO: handle exception
			}
			
		}
		
		return "login-page";
	}
}
