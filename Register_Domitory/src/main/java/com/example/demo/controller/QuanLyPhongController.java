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
import com.example.demo.entity.Phong;
import com.example.demo.service.KhuService;
import com.example.demo.service.PhongService;
@Controller
@RequestMapping(value = "/quanly/khu/phong" )
public class QuanLyPhongController {

	@Autowired
	private KhuService service_Khu;
	@Autowired
	private PhongService service_Phong;
	@RequestMapping(value = "/capnhat", method = RequestMethod.POST)
	public String capNhatThongTinPhong(Model model,HttpServletRequest request) {
		Khu khu = new Khu();
		Phong phong = new Phong();
		
		int idkhu=Integer.parseInt(request.getParameter("idkhu"));
		List<Phong> listPhong = service_Khu.findById(idkhu).get().getPhongs();		
		
		int phongSo=Integer.parseInt(request.getParameter("phongso"));
		int tinhTrang=Integer.parseInt(request.getParameter("tinhtrang"));
		long idPhong=Long.parseLong(request.getParameter("idphong"));
		phong=service_Phong.findById(idPhong).get();
		phong.setIdPhong(idPhong);
		phong.setPhongSo(phongSo);
		phong.setTinhTrang(tinhTrang);
		service_Phong.updateOne(phong);
		
		khu = service_Khu.findById(idkhu).get();
		int soTang = khu.getSoTang();
		model.addAttribute("ListPhong", listPhong);
		model.addAttribute("activekhu", "active");
		model.addAttribute("tenkhu",khu);
		request.setAttribute("soTang", soTang);
		model.addAttribute("message", "Cập nhật thành công");
		model.addAttribute("alert", "success");
		return "/admin/QuanLyKTX/QuanLyPhong";
	}
	@RequestMapping(value = { "/themphong/idkhu={idkhu}&tang={sotang}" }, method = RequestMethod.GET)
	public String loadFormThem(Model model, HttpServletRequest request,@PathVariable long idkhu,@PathVariable long sotang) {
		List<Phong> listPhong = service_Khu.findById(idkhu).get().getPhongs();
		Khu khu = new Khu();
		Phong phong = new Phong();
		
		khu = service_Khu.findById(idkhu).get();
		model.addAttribute("ListPhong", listPhong);
		model.addAttribute("PhongInput", phong);
		model.addAttribute("activekhu", "active");
		model.addAttribute("tenkhu", khu);
		model.addAttribute("tang", sotang);
		model.addAttribute("form", "Them.jsp");
		int soTang = khu.getSoTang();
		request.setAttribute("soTang", soTang);
		return "/admin/QuanLyKTX/QuanLyPhong";
	}
	@RequestMapping(value = { "/chon/phong={idphong}&khu={idkhu}" }, method = RequestMethod.GET)
	public String loadFormUpdate(Model model, HttpServletRequest request,@PathVariable long idphong,@PathVariable long idkhu) {
		List<Phong> listPhong = service_Khu.findById(idkhu).get().getPhongs();
		Khu khu = new Khu();
		Phong phong = new Phong();
		phong=service_Phong.findById(idphong).get();
		khu = service_Khu.findById(idkhu).get();
		model.addAttribute("ListPhong", listPhong);
		model.addAttribute("PhongInput", phong);
		model.addAttribute("sogiuong", phong.getGiuongs().size());
		
		model.addAttribute("activekhu", "active");
		model.addAttribute("tenkhu", khu);
		model.addAttribute("form", "CapNhat.jsp");
		int soTang = khu.getSoTang();
		request.setAttribute("soTang", soTang);
		return "/admin/QuanLyKTX/QuanLyPhong";
	}
	@RequestMapping(value = "/themphong", method = RequestMethod.POST)
	public String themPhong(Model model,HttpServletRequest request) {
		Khu khu = new Khu();
		Phong phong = new Phong();
		
		int idkhu=Integer.parseInt(request.getParameter("idkhu"));
		List<Phong> listPhong = service_Khu.findById(idkhu).get().getPhongs();
		khu=service_Khu.findById(idkhu).get();
		int giaTien=Integer.parseInt(request.getParameter("giaphong"));
		int phongSo=Integer.parseInt(request.getParameter("phongso"));
		int tinhTrang=Integer.parseInt(request.getParameter("tinhtrang"));
		int tang=Integer.parseInt(request.getParameter("tang"));
		phong.setGiaTien(giaTien);
		phong.setPhongSo(phongSo);
		phong.setTinhTrang(tinhTrang);
		phong.setIdKhu(khu);
		phong.setTang(tang);
		service_Phong.saveOne(phong);
		
		khu = service_Khu.findById(idkhu).get();
		
		model.addAttribute("ListPhong", listPhong);
		model.addAttribute("activekhu", "active");
		model.addAttribute("tenkhu",khu);
		int soTang = khu.getSoTang();
		request.setAttribute("soTang", soTang);
		model.addAttribute("message", "Thêm thành công");
		model.addAttribute("alert", "success");
		return "/admin/QuanLyKTX/QuanLyPhong";
	}
	@RequestMapping(value = { "/themtang/idkhu={idkhu}" }, method = RequestMethod.GET)
	public String themTang(Model model, HttpServletRequest request,@PathVariable long idkhu) {
		String back = request.getHeader("Referer");
		Khu khu = new Khu();
		khu = service_Khu.findById(idkhu).get();
		khu.setSoTang(khu.getSoTang()+1);
		service_Khu.saveOne(khu);
		return "redirect:"+back;
	}
}
