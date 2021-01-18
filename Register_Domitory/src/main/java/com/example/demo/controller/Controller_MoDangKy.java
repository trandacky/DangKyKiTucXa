package com.example.demo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.MoDangKy;
import com.example.demo.service.SERVICE_MoDangKy;

@Controller
@RequestMapping(value="/quanly/modangky")
public class Controller_MoDangKy {
	@Autowired
	private SERVICE_MoDangKy service_MoDangKy;
	
	@RequestMapping(value = { "","/" }, method = RequestMethod.GET)
	public String index2(Model model) {
		MoDangKy modangky = new MoDangKy();
		if(service_MoDangKy.getAll().isEmpty()) { model.addAttribute("activedangky","active");	
		return "/admin/QuanLyKTX/MoDangKy";}
		modangky = service_MoDangKy.getByID((long)1).get();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		model.addAttribute("thoigianmo", formatter.format(modangky.getThoiGianMo()));
		model.addAttribute("thoigiandong",  formatter.format(modangky.getThoiGianDong()));
		model.addAttribute("activedangky","active");	
		return "/admin/QuanLyKTX/MoDangKy";
	}
	@RequestMapping(value = { "","/" }, method = RequestMethod.POST)
	public String save(Model model, HttpServletRequest request) throws ParseException {
		String back = request.getHeader("Referer");
		
		MoDangKy modangky = new MoDangKy();
		String mo = request.getParameter("thoigianmo");
		String dong = request.getParameter("thoigiandong");
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date date = (Date)formatter.parse(mo);
		modangky.setThoiGianMo(date);
		Date datedong = (Date)formatter.parse(dong);
		modangky.setThoiGianDong(datedong);
		modangky.setIdMoDangKy((long)1);
		service_MoDangKy.setData(modangky);
		model.addAttribute("activedangky","active");		
	
		return "redirect:"+back;
	}
	
	
	
}
