package com.example.demo.controller.User;

import java.time.LocalDate;


import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.entity.NguoiDung;
import com.example.demo.service.SERVICE_NguoiDung;




@Controller
@RequestMapping(value = "/nguoidung/trangcanhan" )
public class Controller_QuanLyTrangCaNhan {
	@Autowired
	private SERVICE_NguoiDung serviceNguoiDung;
//	@Autowired
//	private TaiKhoanService taiKhoanService;
	
	public NguoiDung getTaiKhoanDangNhap()
	{
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
		    username = principal.toString();
		}
		NguoiDung taiKhoan=new NguoiDung();
		taiKhoan = serviceNguoiDung.getByID(username).get(0);
		return taiKhoan;
	}
	
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request) {

		String page = "/WEB-INF/jsp/user/QuanLyTrangCaNhan/TrangCaNhan.jsp";
		  
		  model.addAttribute("taikhoan", getTaiKhoanDangNhap());
		  model.addAttribute("page", page);
		  model.addAttribute("activetrangcanhan", "active");
		return "/user/QuanLyTrangCaNhan/TrangCaNhan";
	}
	
	@RequestMapping(value = { "/capnhat/{tendangnhap}" }, method = RequestMethod.GET)
	public String capNhatTenDangNhap(Model model, HttpServletRequest request, @PathVariable String tendangnhap)
	{
		NguoiDung taikhoan = serviceNguoiDung.getByID(tendangnhap).get(0);
		String page = "/WEB-INF/jsp/user/QuanLyTrangCaNhan/CapNhat.jsp";
		model.addAttribute("page", page);
		model.addAttribute("taikhoan", taikhoan);
		model.addAttribute("activetrangcanhan", "active");
		return "/user/QuanLyTrangCaNhan/CapNhat";
	}
	@RequestMapping(value = { "/capnhat/submit" }, method = RequestMethod.POST)
	public String capNhatSubmit(Model model, HttpServletRequest request)
	{	
		NguoiDung nguoiDung=new NguoiDung();
		nguoiDung.setTenDangNhap(request.getParameter("tendangnhap").trim());
		nguoiDung.setEmail(request.getParameter("email").trim());
		nguoiDung.setGioiTinh(Boolean.parseBoolean(request.getParameter("gioitinh").trim()));
		nguoiDung.setHoTen(request.getParameter("hoten").trim());
		nguoiDung.setNgayThangNamSinh(LocalDate.parse(request.getParameter("ngaythangnamsinh").trim()));
		nguoiDung.setQueQuan(request.getParameter("quequan").trim());
		nguoiDung.setSoDienThoaiLienHe(request.getParameter("sodienthoailienhe").trim());
		
		nguoiDung.setMatKhau(request.getParameter("matkhau").trim());
		nguoiDung.setQuyen(Integer.parseInt(request.getParameter("quyen").trim()));
		
		serviceNguoiDung.update(nguoiDung);
		model.addAttribute("taikhoan", nguoiDung);
		return "redirect:/nguoidung/trangcanhan";
	}
	
}
