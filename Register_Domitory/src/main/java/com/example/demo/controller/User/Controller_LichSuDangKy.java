package com.example.demo.controller.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.NguoiDung;

import com.example.demo.service.NguoiDungService;

@Controller
@RequestMapping(value="/nguoidung")
public class Controller_LichSuDangKy {
	@Autowired
	private NguoiDungService service_NguoiDung;
	@RequestMapping(value="/lichsu")
	private String xemLichSuDangKy(Model model)
	{
		model.addAttribute("activelichsu","active");
		model.addAttribute("listlichsu",getTaiKhoanDangNhap().getDangKyGiuongs());
		return "/user/lichsudangky";
	}
	public NguoiDung getTaiKhoanDangNhap() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		NguoiDung taiKhoan = new NguoiDung();
		List<NguoiDung> listTaiKhoan = service_NguoiDung.findById(username);
		if (!listTaiKhoan.isEmpty()) {
			taiKhoan = listTaiKhoan.get(0);
		}
		return taiKhoan;
	}
}
