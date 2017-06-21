package com.junehoe.langre.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junehoe.langre.models.Language;
import com.junehoe.langre.services.LanguageService;

@Controller
public class Languages {
	
	private final LanguageService languageService;
	
	public Languages(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String languages(Model model, Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "languages.jsp";
	}
	
	@PostMapping("/languages/new")
	public String createLanguage(
			@Valid Language language,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("language", language);
			return "redirect:/languages";
		}
		else {
			languageService.addLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{index}")
	public String findLanguageByIndex(
			@PathVariable("index") Long index,
			Model model) {
		model.addAttribute("language", languageService.findLanguageById(index));
		return "showLanguage.jsp";
	}
	
	@RequestMapping("/languages/update/{id}")
	public String editLanguage(
			@PathVariable("id") Long id,
			Model model) {
		Language language = languageService.findLanguageById(id);
		if (language != null) {
			model.addAttribute("language", language);
			return "editLanguage.jsp";
		}
		else {
			return "redirect:/languages/{id}";
		}
	}
	
	@PostMapping("/languages/update/{id}")
	public String updateLanguage(
			@PathVariable("id") int id,
			@Valid Language language,
			BindingResult result) {
		if (result.hasErrors()) {
			return "editLanguage.jsp";
		}
		else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/delete/{id}")
	public String destroyLanguage(@PathVariable("id") Long id) {
		languageService.destroyLanguage(id);
		return "redirect:/languages";
	}

}
