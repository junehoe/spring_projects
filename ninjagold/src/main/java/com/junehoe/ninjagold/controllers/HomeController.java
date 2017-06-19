package com.junehoe.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	SimpleDateFormat dF = new SimpleDateFormat("MMMM dd yyyy HH:mm aa");
	List<String> results = new ArrayList<String>();
	int gold = 0;
	
	@RequestMapping(path="/")
	public String index(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if (session.getAttribute("results") == null) {
			session.setAttribute("results", new ArrayList<String>());
		}
		return "index.jsp";
	}
	
	@RequestMapping(path="/process", method=RequestMethod.POST)
	public String processGold(HttpSession session, @RequestParam(value="location") String location) {
		Random rand = new Random();
		String result;
		int randomGold = 0;
		if (location.equals("farm")) {
			randomGold = rand.nextInt(11) + 10;
		}
		else if (location.equals("cave")) {
			randomGold = rand.nextInt(6) + 5;
		}
		else if (location.equals("house")) {
			randomGold = rand.nextInt(4) + 2;
		}
		else if (location.equals("casino")) {
			randomGold = rand.nextInt(101) - 50;
		}
		if (randomGold < 0) {
			result = "You entered a " + location + " and lost " + (-randomGold) + " gold! (" + dF.format(new Date()) + ")";
		}
		else {
			result = "You entered a " + location + " and won " + randomGold + " gold! (" + dF.format(new Date()) + ")";
		}
		int currentGold = (int) session.getAttribute("gold") + randomGold;
		session.setAttribute("gold", currentGold);
		results.add(result);
		session.setAttribute("results", results);
		return "redirect:/";
	}

}
