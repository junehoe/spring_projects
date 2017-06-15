package com.junehoe.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionCounter")
public class HomeController {
	
	private int sessionCounter = 0;
	
	@ModelAttribute("sessionCounter")
	public int getSessionCounter() {
		return this.sessionCounter;
	}

	@RequestMapping("/")
	public String index(@ModelAttribute("sessionCounter") int sessionCounter) {
		this.sessionCounter++;
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(Model model) {
		int counter = getSessionCounter();
		model.addAttribute("sessionCounter", counter);
		return "counterPage.jsp";
	}
	
	@RequestMapping("/add-two")
	public String incrementTwo(@ModelAttribute("sessionCounter") int sessionCounter) {
		this.sessionCounter += 2;
		return "incrementTwo.jsp";
	}
	
	@RequestMapping("/reset")
	public String resetCounter(@ModelAttribute("sessionCounter") int sessionCounter) {
		this.sessionCounter = 0;
		return "resetCounter.jsp";
	}
}
