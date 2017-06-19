package com.junehoe.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	private String theCode = "bushido";

	@RequestMapping("/")
	public String index(@ModelAttribute("error") String error) {
		return "index.jsp";
	}
	
	@RequestMapping(path="/check", method=RequestMethod.POST)
	public String checkCode(@RequestParam(value="code") String code, RedirectAttributes redirectAttributes) {
		if (code.equals(theCode)) {
			return "redirect:/code";
		}
		else {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
	
	@RequestMapping("/code")
	public String secretPage() {
		return "secretPage.jsp";
	}
}
