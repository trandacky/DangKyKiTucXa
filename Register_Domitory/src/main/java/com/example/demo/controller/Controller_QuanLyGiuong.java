package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Giuong;
import com.example.demo.entity.Khu;
import com.example.demo.entity.Phong;
import com.example.demo.service.SERVICE_DangKyGiuong;
import com.example.demo.service.SERVICE_Giuong;
import com.example.demo.service.SERVICE_Khu;
import com.example.demo.service.SERVICE_Phong;

@Controller
@RequestMapping(value = "/quanly" )
public class Controller_QuanLyGiuong {
	
	@Autowired
	private SERVICE_DangKyGiuong service_DangKyGiuong;
	@Autowired
	private SERVICE_Giuong service_Giuong;
	@Autowired
	private SERVICE_Khu service_Khu;
	@Autowired
	private SERVICE_Phong service_Phong;
	
	@RequestMapping(value = { "","/" }, method = RequestMethod.GET)
	public String index2(Model model) {
		List<Giuong> giuong = service_Giuong.getAll();
		model.addAttribute("activegiuong","active");
		model.addAttribute("listGiuong",giuong);
		return "/admin/QuanLyGiuong";
	}
	@RequestMapping(value = {"/khu/phong/chon/capnhat" }, method = RequestMethod.POST)
	public String index3(Model model, HttpServletRequest request) {
		String back = request.getHeader("Referer");
		 
	
			
		int idkhu = Integer.parseInt(request.getParameter("idkhu"));

		
		if(request.getParameter("tinhtrang").equals("3")) {
			boolean tinhtrang = false; 
			int idgiuong = Integer.parseInt(request.getParameter("idgiuong"));	
			service_Giuong.updateTinhTrang(idgiuong,tinhtrang);
		}else
		if(request.getParameter("tinhtrang").equals("4")) {
			boolean tinhtrang = true; 
			int idgiuong = Integer.parseInt(request.getParameter("idgiuong"));	
			service_Giuong.updateTinhTrang(idgiuong,tinhtrang);
		}
		else {
			int tinhtrang = Integer.parseInt(request.getParameter("tinhtrang"));
			int iddangkygiuong = Integer.parseInt(request.getParameter("iddangkygiuong"));	
			service_DangKyGiuong.updateTinhTrang(iddangkygiuong,tinhtrang);
		}
		Khu khu = new Khu();
		khu = service_Khu.findById(idkhu).get();		
		int soTang = khu.getSoTang();
		request.setAttribute("soTang", soTang);
		return "redirect:"+back;
	}
	@RequestMapping(value = {"/khu/phong/chon/phong={idphong}&khu={idkhu}" }, method = RequestMethod.POST)
	public String themGiuong(Model model, HttpServletRequest request) {
		String back = request.getHeader("Referer");
		int idphong = Integer.parseInt(request.getParameter("idphong"));
		
		Phong phong = new Phong();
		Giuong giuong = new Giuong();
		phong=service_Phong.findById(idphong).get();
		for(int i= 0;i<phong.getGiuongs().size();i++) {
			if(phong.getGiuongs().get(i).getViTriGiuong().equals(request.getParameter("vi-tri-giuong")))
			{
				String s = "Giường đã tồn tại";
				List<Phong> listPhong = service_Khu.findById(phong.getIdKhu().getIdKhu()).get().getPhongs();
				Khu khu = new Khu();
				khu=service_Khu.findById(phong.getIdKhu().getIdKhu()).get();
				phong=service_Phong.findById(idphong).get();
				model.addAttribute("ListPhong", listPhong);
				model.addAttribute("PhongInput", phong);
				model.addAttribute("sogiuong", phong.getGiuongs().size());
				
				model.addAttribute("activekhu", "active");
				model.addAttribute("tenkhu", khu);
				model.addAttribute("form", "CapNhat.jsp");
				int soTang = khu.getSoTang();
				request.setAttribute("soTang", soTang);	
				request.setAttribute("message", s);
				request.setAttribute("alert", "danger");
				return "/admin/QuanLyKTX/QuanLyPhong";
				
			}
		}
		giuong.setViTriGiuong(request.getParameter("vi-tri-giuong"));
		giuong.setIdPhong(phong);
		service_Giuong.setData(giuong);
		return "redirect:"+back;
	}
	
	
}