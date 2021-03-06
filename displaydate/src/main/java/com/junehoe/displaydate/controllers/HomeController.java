package com.junehoe.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat dayNamePattern = new SimpleDateFormat("EEEE");
		SimpleDateFormat dayNumberPattern = new SimpleDateFormat("d");
		SimpleDateFormat monthNamePattern = new SimpleDateFormat("MMMMM");
		SimpleDateFormat yearPattern = new SimpleDateFormat("yyyy");
		String dayName = dayNamePattern.format(date);
		String dayNumber = dayNumberPattern.format(date);
		String monthName = monthNamePattern.format(date);
		String year = yearPattern.format(date);
		String dateFormat = dayName + ", the " + dayNumber + " of " + monthName + ", " + year;
		model.addAttribute("date", dateFormat);
		return "showDate.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		SimpleDateFormat timePattern = new SimpleDateFormat("hh:mm a");
		String time = timePattern.format(date);
		model.addAttribute("time", time);
		return "showTime.jsp";
	}
}
