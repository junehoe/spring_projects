package com.junehoe.grouplanguages.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.junehoe.grouplanguages.models.Language;

@Service
public class LanguageService {
	
	private List<Language> languages = new ArrayList(Arrays.asList(
			new Language("Java", "Brian Sung", 3.5),
			new Language("Python", "The Dude", 6.9),
			new Language("Ruby", "The Roobs", 2.1)
			));

	public List<Language> allLanguages() {
		return languages;
	}
	
	public void addLanguage(Language language) {
		languages.add(language);
	}
	
	public Language findLanguageByIndex(int index) {
		if (index < languages.size()) {
			return languages.get(index);
		}
		else {
			return null;
		}
	}
	
	public void updateLanguage(int id, Language language) {
		if (id < languages.size()) {
			languages.set(id, language);
		}
	}
	
	public void destroyLanguage(int id) {
		if (id < languages.size()) {
			languages.remove(id);
		}
	}
}
