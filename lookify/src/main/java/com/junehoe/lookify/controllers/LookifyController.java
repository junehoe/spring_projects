package com.junehoe.lookify.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.junehoe.lookify.models.Song;
import com.junehoe.lookify.services.LookifyService;

@Controller
public class LookifyController {
	
	private final LookifyService lookifyService;
	
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = lookifyService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song, Model model) {
		List<Integer> ratings = new ArrayList<Integer>();
		for (int i=1; i<=10; i++) {
			ratings.add(i);
		}
		model.addAttribute("ratings", ratings);
		return "newSong.jsp";
	}
	
	@PostMapping("/songs/new")
	public String createSong(
			@Valid Song song,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("song", song);
			return "redirect:/songs/new";
		}
		else {
			lookifyService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/songs/{id}")
	public String showSong(
			@PathVariable("id") Long id,
			Model model) {
		model.addAttribute("song", lookifyService.findSongById(id));
		return "showSong.jsp";
	}
	
	@RequestMapping("/songs/delete/{id}")
	public String destorySong(@PathVariable("id") Long id) {
		lookifyService.destroySong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/songs/top")
	public String showTopTen(Model model) {
		model.addAttribute("topTen", lookifyService.getTopTenSongs());
		return "showTopTen.jsp";
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public String search(@RequestParam(value="artist") String artist) {
		return "redirect:/search/" + artist;
	}
	
	@RequestMapping("/search/{artist}")
	public String showSearchResults(@PathVariable("artist") String artist, Model model) {
		model.addAttribute("artist", artist);
		model.addAttribute("searchResults", lookifyService.getSearchResults(artist));
		return "showSearchResults.jsp";
	}
}