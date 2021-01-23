package com.example.demo.controller.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.DangKyGiuong;
import com.example.demo.entity.NguoiDung;
import com.example.demo.service.SERVICE_DangKyGiuong;
import com.example.demo.service.SERVICE_Giuong;

import com.example.demo.service.SERVICE_NguoiDung;

@Controller
@RequestMapping(value = "/nguoidung")
public class Controller_DangKyGiuong {

	
	@Autowired
	private SERVICE_DangKyGiuong service_DangKyGiuong;
	
	@Autowired
	private SERVICE_Giuong service_Giuong;
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

	@RequestMapping(value = "/dangky/idgiuong={idgiuong}", method = RequestMethod.POST)
	private String dangKyGiuong(Model model, HttpServletRequest request, @PathVariable long idgiuong) {
		if (request.getParameter("giuongdadangky") != "") {
			DangKyGiuong dangKyGiuong = service_DangKyGiuong
					.getByID(Integer.parseInt( request.getParameter("giuongdadangky"))).get();
			dangKyGiuong.setTinhTrangDangKy(3);
			service_DangKyGiuong.update(dangKyGiuong);
			dangKyGiuong= new DangKyGiuong();
			dangKyGiuong.setIdGiuong(service_Giuong.getByID(idgiuong).get());
			dangKyGiuong.setTenDangNhap(getTaiKhoanDangNhap());
			dangKyGiuong.setTinhTrangDangKy(2);
			service_DangKyGiuong.setData(dangKyGiuong);
		}
		else
		{
			DangKyGiuong dangKyGiuong= new DangKyGiuong();
			dangKyGiuong.setIdGiuong(service_Giuong.getByID(idgiuong).get());
			dangKyGiuong.setTenDangNhap(getTaiKhoanDangNhap());
			dangKyGiuong.setTinhTrangDangKy(2);
			service_DangKyGiuong.setData(dangKyGiuong);
			
		}
		return "redirect:/home";
	}
}
