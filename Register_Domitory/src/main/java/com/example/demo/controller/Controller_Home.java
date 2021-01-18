package com.example.demo.controller;

import java.util.Date;
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

import com.example.demo.entity.Giuong;
import com.example.demo.entity.Khu;
import com.example.demo.entity.NguoiDung;
import com.example.demo.service.SERVICE_DangKyGiuong;
import com.example.demo.service.SERVICE_Khu;
import com.example.demo.service.SERVICE_MoDangKy;
import com.example.demo.service.SERVICE_NguoiDung;
import com.example.demo.service.SERVICE_Phong;

@Controller

public class Controller_Home {

	@Autowired
	private SERVICE_Khu service_Khu;
	@Autowired
	private SERVICE_DangKyGiuong service_DangKyGiuong;
	@Autowired
	private SERVICE_Phong service_Phong;
	@Autowired
	private SERVICE_NguoiDung service_NguoiDung;
	@Autowired
	private SERVICE_MoDangKy service_MoDangKy;

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
		model.addAttribute("formgiuong", "NullFile.jsp");
		setGiaTriChoViewtheoTungSession(model, request);
		return "/home";
	}

	@RequestMapping(value = { "/home/khu/idkhu={idkhu}&tang={tang}" }, method = RequestMethod.GET)
	public String chonKhu(Model model, @PathVariable long idkhu, @PathVariable long tang, HttpServletRequest request) {
		Khu khu = service_Khu.getByID(idkhu).get();
		model.addAttribute("headerForm", "HeaderUser.jsp");
		model.addAttribute("activetrangchu", "active");
		model.addAttribute("khu", khu);
		model.addAttribute("tang", tang);
		model.addAttribute("formgiuong", "NullFile.jsp");
		// model.addAttribute("phong", phong);
		model.addAttribute("formtang", "tang.jsp");
		model.addAttribute("formphong", "phong.jsp");
		List<Khu> listKhu = service_Khu.getAll();
		model.addAttribute("ListKhu", listKhu);
		setGiaTriChoViewtheoTungSession(model, request);
		return "/home";
	}

	@RequestMapping(value = { "/home/khu/idkhu={idkhu}&tang={tang}" }, method = RequestMethod.POST)
	public String chonPhong(Model model, HttpServletRequest request, @PathVariable long idkhu,
			@PathVariable long tang) {
		Khu khu = service_Khu.getByID(idkhu).get();
		int idphong = Integer.parseInt(request.getParameter("idphong"));
		List<Giuong> listGiuong = service_Phong.getByID(idphong).get().getGiuongs();
		model.addAttribute("listgiuong", listGiuong);
		model.addAttribute("headerForm", "HeaderUser.jsp");
		model.addAttribute("activetrangchu", "active");
		model.addAttribute("khu", khu);
		model.addAttribute("tang", tang);
		model.addAttribute("phong", service_Phong.getByID(idphong).get());
		model.addAttribute("formgiuong", "giuong.jsp");
		// model.addAttribute("phong", phong);
		model.addAttribute("formtang", "tang.jsp");
		model.addAttribute("formphong", "phong.jsp");
		List<Khu> listKhu = service_Khu.getAll();
		setGiaTriChoViewtheoTungSession(model, request);
		model.addAttribute("ListKhu", listKhu);
		return "/home";
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
		List<NguoiDung> listTaiKhoan = service_NguoiDung.getByID(username);
		if (!listTaiKhoan.isEmpty()) {
			taiKhoan = listTaiKhoan.get(0);
		}
		return taiKhoan;
	}

	public void setGiaTriChoViewtheoTungSession(Model model, HttpServletRequest request) {

		NguoiDung nguoiDung = getTaiKhoanDangNhap();
		Date date = new Date();
		request.getSession().setAttribute("disable", true);
		for (int i = 0; i < nguoiDung.getDangKyGiuongs().size(); i++) {
			if (nguoiDung.getDangKyGiuongs().get(i).getTinhTrangDangKy() == 0) {
				request.getSession().setAttribute("disable", false);
				model.addAttribute("noidungalert",
						"Bạn đã ở phòng: " + nguoiDung.getDangKyGiuongs().get(i).getIdGiuong().getIdPhong().getPhongSo()
								+ " Giường: " + nguoiDung.getDangKyGiuongs().get(i).getIdGiuong().getViTriGiuong()
								+ " Khu: "
								+ nguoiDung.getDangKyGiuongs().get(i).getIdGiuong().getIdPhong().getIdKhu().getTenKhu()

				);
				model.addAttribute("alert", "success");
				break;
			}
			if (nguoiDung.getDangKyGiuongs().get(i).getTinhTrangDangKy() == 2 && nguoiDung.getDangKyGiuongs().get(i)
					.getNgayDangKy().after(service_MoDangKy.getByID(1).get().getThoiGianDong())) {
				nguoiDung.getDangKyGiuongs().get(i).setTinhTrangDangKy(3);
				service_DangKyGiuong.update(nguoiDung.getDangKyGiuongs().get(i));
				request.getSession().setAttribute("disable", true);
				model.addAttribute("noidungalert", "Đã hết thời hạn mà bạn đăng ký");
				model.addAttribute("alert", "danger");

			} else if (nguoiDung.getDangKyGiuongs().get(i).getTinhTrangDangKy() == 2 && nguoiDung.getDangKyGiuongs()
					.get(i).getNgayDangKy().before(service_MoDangKy.getByID(1).get().getThoiGianDong())) {
				request.getSession().setAttribute("disable", true);
				model.addAttribute("noidungalert",
						"Bạn đã đăng ký " + "Phòng: "
								+ nguoiDung.getDangKyGiuongs().get(i).getIdGiuong().getIdPhong().getPhongSo()
								+ " Giường: " + nguoiDung.getDangKyGiuongs().get(i).getIdGiuong().getViTriGiuong()
								+ " Khu: "
								+ nguoiDung.getDangKyGiuongs().get(i).getIdGiuong().getIdPhong().getIdKhu().getTenKhu()
						);
				model.addAttribute("alert", "danger");
				model.addAttribute("giuongdadangky", nguoiDung.getDangKyGiuongs().get(i).getIdDangKyGiuong());
				break;
			}
		}
		if (date.after(service_MoDangKy.getByID(1).get().getThoiGianDong())) {
			request.getSession().setAttribute("disable", false);
			model.addAttribute("noidungalert", "Đã hết thời hạn đăng ký");
			model.addAttribute("alert", "danger");
		}

		if (nguoiDung.getQuyen() != null) {
			if (nguoiDung.getQuyen() == 1) {
				request.getSession().setAttribute("urlAdmin",
						"<a href=\"/quanly/taikhoan\">Về trang Admin(Quản lý tài khoản)</a>");
			}
			request.getSession().setAttribute("taikhoan", nguoiDung);
			request.getSession().setAttribute("tennguoidung", nguoiDung.getHoTen());
		}
	}

}
