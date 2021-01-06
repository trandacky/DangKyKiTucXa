package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Khu;
import com.example.demo.service.SERVICE_Khu;
import com.example.demo.service.SERVICE_Phong;

@Controller

public class Controller_HomeAdmin {

	@Autowired
	private SERVICE_Khu service_Khu;
	@Autowired
	private SERVICE_Phong service_Phong;
	@RequestMapping(value = { "/","/index" }, method = RequestMethod.GET)
	public String login(Model model) {
		
		return "/index";
	}
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("activetrangchu","active");
		List<Khu> listKhu = service_Khu.getAll();
		model.addAttribute("ListKhu", listKhu);
		return "/home";
	}
}
