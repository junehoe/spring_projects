package com.junehoe.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junehoe.dojosninjas.models.Dojo;
import com.junehoe.dojosninjas.models.Ninja;
import com.junehoe.dojosninjas.services.DojoService;
import com.junehoe.dojosninjas.services.NinjaService;

@Controller
public class DojosNinjas {
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojosNinjas(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(
			@Valid Dojo dojo,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("dojo", dojo);
			return "redirect:/dojos/new";
		}
		else {
			dojoService.addDojo(dojo);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(
			@Valid Ninja ninja,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		System.out.println(ninja.getAge());
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("ninja", ninja);
			return "redirect:/ninjas/new";
		}
		else {
			ninjaService.addNinja(ninja);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(
			@PathVariable("id") Long id,
			Model model) {
		model.addAttribute("dojo", dojoService.findDojoById(id));
		return "showDojo.jsp";
	}

}
