package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Controller_QuanLyGiuong {
	@RequestMapping(value = { "/quanlygiuong" }, method = RequestMethod.GET)
	public String index2(Model model) {
		String page="/WEB-INF/jsp/page/QuanLyGiuong.jsp";
		
		model.addAttribute("page",page);
		model.addAttribute("activegiuong","active");
		return "adminMaster";
	}
}
