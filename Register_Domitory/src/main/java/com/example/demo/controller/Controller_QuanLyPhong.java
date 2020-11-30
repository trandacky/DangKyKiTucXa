package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class Controller_QuanLyPhong {
	@RequestMapping(value = { "/quanlyphong" }, method = RequestMethod.GET)
	public String index2(Model model) {
		String page="/WEB-INF/jsp/page/QuanLyPhong.jsp";
		
		model.addAttribute("page",page);
		model.addAttribute("activephong","active");
		return "adminMaster";
	}
}
