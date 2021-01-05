package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Giuong;
import com.example.demo.service.SERVICE_Giuong;
import com.example.demo.service.SERVICE_Khu;

@Controller
@RequestMapping(value = "/quanly/giuong" )
public class Controller_QuanLyGiuong {
	
	@Autowired
	private SERVICE_Giuong service_Giuong;
	
	@RequestMapping(value = { "","/" }, method = RequestMethod.GET)
	public String index2(Model model) {
		List<Giuong> giuong = service_Giuong.getAll();
		model.addAttribute("activegiuong","active");
		model.addAttribute("listGiuong",giuong);
		return "/admin/QuanLyGiuong";
	}
}