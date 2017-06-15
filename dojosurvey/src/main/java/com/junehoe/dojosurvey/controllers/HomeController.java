package com.junehoe.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping(path="/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/result", method=RequestMethod.POST)
	public String result(Model model, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment", required=false, defaultValue="") String comment) {
		if (language.equals("Java")) {
			return "redirect:/javamemebro";
		}
		else {
			model.addAttribute("name", name);
			model.addAttribute("location", location);
			model.addAttribute("language", language);
			model.addAttribute("comment", comment);
			return "results.jsp";
		}
	}
	
	@RequestMapping(path="/javamemebro")
	public String javaMeme() {
		return "javaMeme.jsp";
	}

}
