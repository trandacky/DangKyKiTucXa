package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/quanly/quangcao")
public class QuangCaoController {
	@RequestMapping(value={"",""}, method=RequestMethod.GET)
	private String quangCao(Model model)
	{
		model.addAttribute("activequangcao","active");
		return "/admin/quangcao";
	}
}
