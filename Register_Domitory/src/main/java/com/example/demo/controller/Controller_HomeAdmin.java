package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class Controller_HomeAdmin {
	@RequestMapping(value = { "/","/index" }, method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("activetrangchu","active");
		return "/index";
	}
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		return "/home";
	}
}
