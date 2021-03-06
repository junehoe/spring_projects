package com.junehoe.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
	
	@RequestMapping("/me")
	public String aboutMe() {
		return "aboutme.html";
	}
	
	@RequestMapping("/projects")
	public String projects() {
		return "projectspage.html";
	}
}
