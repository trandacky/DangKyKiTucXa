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
import com.example.demo.service.DangKyGiuongService;
import com.example.demo.service.GiuongService;

import com.example.demo.service.NguoiDungService;

@Controller
@RequestMapping(value = "/nguoidung")
public class DangKyGiuongController {

	
	@Autowired
	private DangKyGiuongService service_DangKyGiuong;
	
	@Autowired
	private GiuongService service_Giuong;
	@Autowired
	private NguoiDungService service_NguoiDung;
	

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

	@RequestMapping(value = "/dangky/idgiuong={idgiuong}", method = RequestMethod.POST)
	public String dangKyGiuong(Model model, HttpServletRequest request, @PathVariable long idgiuong) {
		if (request.getParameter("giuongdadangky") != "") {
			DangKyGiuong dangKyGiuong = service_DangKyGiuong
					.getByID(Integer.parseInt( request.getParameter("giuongdadangky"))).get();
			dangKyGiuong.setTinhTrangDangKy(3);
			service_DangKyGiuong.update(dangKyGiuong);
			dangKyGiuong= new DangKyGiuong();
			dangKyGiuong.setIdGiuong(service_Giuong.findById(idgiuong).get());
			dangKyGiuong.setTenDangNhap(getTaiKhoanDangNhap());
			dangKyGiuong.setTinhTrangDangKy(2);
			service_DangKyGiuong.setData(dangKyGiuong);
		}
		else
		{
			DangKyGiuong dangKyGiuong= new DangKyGiuong();
			dangKyGiuong.setIdGiuong(service_Giuong.findById(idgiuong).get());
			dangKyGiuong.setTenDangNhap(getTaiKhoanDangNhap());
			dangKyGiuong.setTinhTrangDangKy(2);
			service_DangKyGiuong.setData(dangKyGiuong);
			
		}
		return "redirect:/home";
	}
}
