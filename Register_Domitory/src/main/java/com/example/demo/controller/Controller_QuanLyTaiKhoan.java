package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.entity.NguoiDung;
import com.example.demo.service.SERVICE_NguoiDung;

@Controller
@RequestMapping(value = "/quanly/taikhoan")
public class Controller_QuanLyTaiKhoan {
	@Autowired
	private SERVICE_NguoiDung service_NguoiDung;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String index(Model model) {
		List<NguoiDung> listNguoiDung = service_NguoiDung.getAll();
		model.addAttribute("FormUpdateOrAdd", "/WEB-INF/jsp/admin/QuanLyTaiKhoan/Them.jsp");
		model.addAttribute("ListNguoiDung", listNguoiDung);
		model.addAttribute("activetaikhoan", "active");
		return "/admin/QuanLyTaiKhoan/QuanLyTaiKhoan";
	}

	@RequestMapping(value = "/them", method = RequestMethod.POST)
	public String themTaiKhoan(Model model, HttpServletRequest request) {
		String tenDangNhap = request.getParameter("tendangnhap");
		if (!service_NguoiDung.getByID(tenDangNhap).isEmpty()) {
			model.addAttribute("themfail", "Thêm thất bại, tên đăng nhập đã tồn tại");
			model.addAttribute("alert", "danger");
			List<NguoiDung> listNguoiDung = service_NguoiDung.getAll();
			model.addAttribute("ListNguoiDung", listNguoiDung);
			model.addAttribute("activetaikhoan", "active");
			model.addAttribute("FormUpdateOrAdd", "/WEB-INF/jsp/admin/QuanLyTaiKhoan/Them.jsp");
			return "/admin/QuanLyTaiKhoan/QuanLyTaiKhoan";
		}
		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setHoTen((request.getParameter("hoten").trim()));
		String matKhau=request.getParameter("matkhau").trim();
		nguoiDung.setMatKhau(encrytePassword(matKhau));
		nguoiDung.setEmail(request.getParameter("email").trim());
		nguoiDung.setTenDangNhap(request.getParameter("tendangnhap").trim());
		nguoiDung.setGioiTinh(Boolean.parseBoolean(request.getParameter("gioitinh").trim()));
		nguoiDung.setQueQuan(request.getParameter("quequan").trim());
		nguoiDung.setQuyen(Integer.parseInt(request.getParameter("quyen").trim()));
		nguoiDung.setSoDienThoaiLienHe(request.getParameter("sodienthoai").trim());
		try {
			nguoiDung.setNgayThangNamSinh(LocalDate.parse(request.getParameter("ngaythangnamsinh").trim()));
		} catch (Exception e) {
			model.addAttribute("themfail", "Thêm thất bại cú pháp bạn nhập thiếu hoặc không hợp lệ");
			model.addAttribute("alert", "danger");
			List<NguoiDung> listNguoiDung = service_NguoiDung.getAll();
			model.addAttribute("ListNguoiDung", listNguoiDung);
			model.addAttribute("FormUpdateOrAdd", "/WEB-INF/jsp/admin/QuanLyTaiKhoan/Them.jsp");
			model.addAttribute("activetaikhoan", "active");
			return "/admin/QuanLyTaiKhoan/QuanLyTaiKhoan";
		}

		service_NguoiDung.setData(nguoiDung);
		List<NguoiDung> listNguoiDung = service_NguoiDung.getAll();
		model.addAttribute("ListNguoiDung", listNguoiDung);
		model.addAttribute("FormUpdateOrAdd", "/WEB-INF/jsp/admin/QuanLyTaiKhoan/Them.jsp");
		model.addAttribute("activetaikhoan", "active");
		return "redirect:/quanly/taikhoan";
	}
	   public static String encrytePassword(String password) {
	        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	        return encoder.encode(password);
	    }
	 
	@RequestMapping(value = "/seach", method = RequestMethod.GET)
	public String timKiem(Model model, HttpServletRequest request) {
		String seachString = ((request.getParameter("seach").trim()));
		List<NguoiDung> listNguoiDung = service_NguoiDung.seach(seachString);
		model.addAttribute("ListNguoiDung", listNguoiDung);
		model.addAttribute("FormUpdateOrAdd", "/WEB-INF/jsp/admin/QuanLyTaiKhoan/Them.jsp");
		model.addAttribute("activetaikhoan", "active");
		return "/admin/QuanLyTaiKhoan/QuanLyTaiKhoan";
	}

	@RequestMapping(value = { "/capnhat/{id}" }, method = RequestMethod.GET)
	public String layIDCapNhat(Model model, HttpServletRequest request, @PathVariable String id) {
		NguoiDung nguoiDung = service_NguoiDung.getByID(id).get(0);
		model.addAttribute("tendangnhap", nguoiDung.getTenDangNhap());
		model.addAttribute("hoten", nguoiDung.getHoTen());
		model.addAttribute("quequan", nguoiDung.getQueQuan());
		model.addAttribute("ngaythangnamsinh", nguoiDung.getNgayThangNamSinh());
		model.addAttribute("email", nguoiDung.getEmail());
		model.addAttribute("gioitinh", nguoiDung.getGioiTinh());
		model.addAttribute("quyen", nguoiDung.getQuyen());
		model.addAttribute("sodienthoai", nguoiDung.getSoDienThoaiLienHe());
		List<NguoiDung> listNguoiDung = service_NguoiDung.getAll();
		model.addAttribute("ListNguoiDung", listNguoiDung);
		model.addAttribute("FormUpdateOrAdd", "/WEB-INF/jsp/admin/QuanLyTaiKhoan/CapNhat.jsp");
		model.addAttribute("activetaikhoan", "active");
		return "/admin/QuanLyTaiKhoan/QuanLyTaiKhoan";
	}
	@RequestMapping(value = "/capnhat", method = RequestMethod.POST)
	public String capNhatTaiKhoan(Model model, HttpServletRequest request) {
		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setHoTen((request.getParameter("hoten").trim()));
		nguoiDung.setEmail(request.getParameter("email").trim());
		nguoiDung.setTenDangNhap(request.getParameter("tendangnhap").trim());
		nguoiDung.setGioiTinh(Boolean.parseBoolean(request.getParameter("gioitinh").trim()));
		nguoiDung.setQueQuan(request.getParameter("quequan").trim());
		nguoiDung.setQuyen(Integer.parseInt(request.getParameter("quyen").trim()));
		nguoiDung.setSoDienThoaiLienHe(request.getParameter("sodienthoai").trim());
		nguoiDung.setNgayThangNamSinh(LocalDate.parse(request.getParameter("ngaythangnamsinh").trim()));
		String matKhau=request.getParameter("matkhau").trim();
		nguoiDung.setMatKhau(encrytePassword(matKhau));

		service_NguoiDung.update(nguoiDung);
		List<NguoiDung> listNguoiDung = service_NguoiDung.getAll();
		model.addAttribute("ListNguoiDung", listNguoiDung);
		model.addAttribute("FormUpdateOrAdd", "/WEB-INF/jsp/admin/QuanLyTaiKhoan/Them.jsp");
		model.addAttribute("activetaikhoan", "active");
		return "redirect:/quanly/taikhoan";
	}
}
