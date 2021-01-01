package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/quanly/giuong" )
public class Controller_QuanLyGiuong {
	@RequestMapping(value = { "","/" }, method = RequestMethod.GET)
	public String index2(Model model) {
		
		model.addAttribute("activegiuong","active");
		return "/admin/QuanLyGiuong";
	}
}
