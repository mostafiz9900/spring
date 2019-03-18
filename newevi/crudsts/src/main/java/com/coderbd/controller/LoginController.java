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
	
	@GetMapping(value="/")
	public String view() {
		
		return "index";
	}
	
	

	@GetMapping(value = "/login")
	public String login(Model model, Student student) {
		model.addAttribute("student", student);
		return "login";
	}
	
	
	@PostMapping(value = "/login")
	public String loginWork(@RequestParam("userName") String userName, Model model) {
		if (userName != null) {
			try {
				Student student = this.repo.findByUserName(userName);
				if (student.getUserName() != null) {
					return "redirect:/list";

				} 
			} catch (NullPointerException ne) {
				model.addAttribute("rejectMsg", "Enter valid UserName");
				return "login";

			}
		}
		return "login";
	}

	
}

