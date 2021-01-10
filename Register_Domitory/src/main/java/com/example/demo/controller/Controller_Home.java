package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Khu;
import com.example.demo.entity.NguoiDung;
import com.example.demo.entity.Phong;
import com.example.demo.service.SERVICE_Khu;
import com.example.demo.service.SERVICE_NguoiDung;
import com.example.demo.service.SERVICE_Phong;

@Controller

public class Controller_Home {

	@Autowired
	private SERVICE_Khu service_Khu;
	@Autowired
	private SERVICE_Phong service_Phong;
	@Autowired
	private SERVICE_NguoiDung service_NguoiDung;

	public NguoiDung getTaiKhoanDangNhap() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		NguoiDung taiKhoan = new NguoiDung();
		List<NguoiDung> listTaiKhoan = service_NguoiDung.getByID(username);
		if (!listTaiKhoan.isEmpty()) {
			taiKhoan = listTaiKhoan.get(0);
		}
		return taiKhoan;
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String login(Model model) {

		return "/index";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		model.addAttribute("activetrangchu", "active");
		List<Khu> listKhu = service_Khu.getAll();
		model.addAttribute("headerForm", "HeaderUser.jsp");
		model.addAttribute("ListKhu", listKhu);
		model.addAttribute("formtang", "NullFile.jsp");
		model.addAttribute("formphong", "NullFile.jsp");
		if (getTaiKhoanDangNhap().getQuyen() != null) {
			if (getTaiKhoanDangNhap().getQuyen() == 1) {
				request.getSession().setAttribute("urlAdmin",
						"<a href=\"/quanly/taikhoan\">Về trang Admin(Quản lý tài khoản)</a>");
			}
		}
		return "/home";
	}

	@RequestMapping(value = { "/home/khu/idkhu={idkhu}&tang={tang}" }, method = RequestMethod.GET)
	public String chonKhu(Model model, @PathVariable long idkhu, @PathVariable long tang) {
		Khu khu = service_Khu.getByID(idkhu).get();
		model.addAttribute("headerForm", "HeaderUser.jsp");
		model.addAttribute("activetrangchu", "active");
		model.addAttribute("khu", khu);
		model.addAttribute("tang",tang);
		//model.addAttribute("phong", phong);
		model.addAttribute("formtang", "tang.jsp");
		model.addAttribute("formphong", "phong.jsp");
		List<Khu> listKhu = service_Khu.getAll();
		model.addAttribute("ListKhu", listKhu);
		return "/home";
	}
	
	@RequestMapping(value = { "/home/khu/idkhu={idkhu}&tang={tang}" }, method = RequestMethod.POST)
	public String chonPhong(Model model, HttpServletRequest request, @PathVariable long idkhu, @PathVariable long tang) {
		Khu khu = service_Khu.getByID(idkhu).get();
		int phong= Integer.parseInt(request.getParameter("phong"));
		model.addAttribute("headerForm", "HeaderUser.jsp");
		model.addAttribute("activetrangchu", "active");
		model.addAttribute("khu", khu);
		model.addAttribute("tang",tang);
		model.addAttribute("phong",phong);
		//model.addAttribute("phong", phong);
		model.addAttribute("formtang", "tang.jsp");
		model.addAttribute("formphong", "phong.jsp");
		List<Khu> listKhu = service_Khu.getAll();
		model.addAttribute("ListKhu", listKhu);
		return "/home";
	}
	
}
