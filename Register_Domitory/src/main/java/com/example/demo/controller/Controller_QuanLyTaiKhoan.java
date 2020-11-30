package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.NguoiDung;
import com.example.demo.service.SERVICE_NguoiDung;

@Controller
public class Controller_QuanLyTaiKhoan {
	public final SERVICE_NguoiDung service_NguoiDung;

	public Controller_QuanLyTaiKhoan(SERVICE_NguoiDung service_NguoiDung) {
		super();
		this.service_NguoiDung = service_NguoiDung;
	}

	@RequestMapping(value = { "/quanlytaikhoan" }, method = RequestMethod.GET)
	public String index(Model model) {
		String message = "Hello Spring Boot + JSP";
		String page="/WEB-INF/jsp/page/QuanLyTaiKhoan.jsp";
		List<NguoiDung> ListNguoiDung = service_NguoiDung.getAll();
		model.addAttribute("ListNguoiDung", ListNguoiDung);
		model.addAttribute("message", message);
		model.addAttribute("page",page);
		model.addAttribute("activetaikhoan","active");
		return "adminMaster";
	}
	
}
