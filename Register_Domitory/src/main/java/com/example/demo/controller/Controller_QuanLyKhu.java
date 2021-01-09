package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/quanly/khu")
public class Controller_QuanLyKhu {
	@Autowired
	private SERVICE_Khu service_Khu;
	@Autowired
	private SERVICE_Phong service_Phong;
	
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String index(Model model) {
		List<Khu> listKhu = service_Khu.getAll();
		model.addAttribute("ListKhu", listKhu);
		model.addAttribute("activekhu", "active");
		model.addAttribute("form", "NullFile.jsp");
		return "/admin/QuanLyKTX/QuanLyKhu";
	}

	@RequestMapping(value = { "/chonchitiet/{id}" }, method = RequestMethod.GET)
	public String layIDKhu(Model model, HttpServletRequest request, @PathVariable long id) {
		List<Phong> listPhong = service_Khu.getByID(id).get().getPhongs();
		Khu khu = new Khu();
		khu = service_Khu.getByID(id).get();
		model.addAttribute("ListPhong", listPhong);
		model.addAttribute("activekhu", "active");
		model.addAttribute("tenkhu", khu);
		model.addAttribute("form", "NullFile.jsp");
		int soTang = khu.getSoTang();
		request.setAttribute("soTang", soTang);
		return "/admin/QuanLyKTX/QuanLyPhong";
	}
	@RequestMapping(value = { "/themkhu" }, method = RequestMethod.GET)
	public String loadFormThemKhu(Model model) {
		List<Khu> listKhu = service_Khu.getAll();
		model.addAttribute("ListKhu", listKhu);
		model.addAttribute("activekhu", "active");
		model.addAttribute("form", "Them.jsp");
		return "/admin/QuanLyKTX/QuanLyKhu";
	}
	@RequestMapping(value = { "/themkhu/them" }, method = RequestMethod.POST)
	public String themKhu(Model model, HttpServletRequest request) {
		Khu khu= new Khu();
		String tenKhu=request.getParameter("tenkhu").toString().trim();
		boolean gioiTinh=Boolean.parseBoolean(request.getParameter("gioitinh").toString().trim());
		int soTang= Integer.parseInt(request.getParameter("sotang").toString().trim());
		khu.setGioiTinh(gioiTinh);
		khu.setSoTang(soTang);
		khu.setTenKhu(tenKhu);
		service_Khu.setData(khu);
		List<Khu> listKhu = service_Khu.getAll();
		model.addAttribute("ListKhu", listKhu);
		model.addAttribute("activekhu", "active");
		model.addAttribute("form", "NullFile.jsp");
		return "redirect:/quanly/khu/";
	}
	@RequestMapping(value = { "/chon/khu={idkhu}" }, method = RequestMethod.GET)
	public String loadFormUpdate(Model model, HttpServletRequest request,@PathVariable long idkhu) {
		List<Khu> listKhu = service_Khu.getAll();
		Khu khu = new Khu();
		
		khu = service_Khu.getByID(idkhu).get();
		model.addAttribute("ListKhu", listKhu);
		model.addAttribute("KhuInput", khu);
		
		
		model.addAttribute("activekhu", "active");
		
		model.addAttribute("form", "CapNhat.jsp");
		int soTang = khu.getSoTang();
		request.setAttribute("soTang", soTang);
		return "/admin/QuanLyKTX/QuanLyKhu";
	}
	@RequestMapping(value = "/capnhat", method = RequestMethod.POST)
	public String capNhatThongTinKhu(Model model,HttpServletRequest request) {
		Khu khu = new Khu();
		
		Long idKhu=Long.parseLong(request.getParameter("idkhu"));
		List<Khu> listKhu = service_Khu.getAll();		
		
		String tenKhu=request.getParameter("tenkhu");
		Boolean gioiTinh=Boolean.parseBoolean(request.getParameter("gioitinh"));
		khu=service_Khu.getByID(idKhu).get();
		khu.setIdKhu(idKhu);
		khu.setTenKhu(tenKhu);
		khu.setGioiTinh(gioiTinh);
		service_Khu.update(khu);
		
		int soTang = khu.getSoTang();
		model.addAttribute("ListKhu", listKhu);
		model.addAttribute("activekhu", "active");
		model.addAttribute("tenkhu",khu);
		request.setAttribute("soTang", soTang);
		model.addAttribute("message", "Cập nhật thành công");
		model.addAttribute("alert", "success");
		return "/admin/QuanLyKTX/QuanLyKhu";
	}
}
