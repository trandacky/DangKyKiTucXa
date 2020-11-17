package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.NguoiDung;
import com.example.demo.service.SERVICE_NguoiDung;

@RestController
public class CONTROLLER_NguoiDung {
	
	private SERVICE_NguoiDung service_NguoiDung;
	public CONTROLLER_NguoiDung(SERVICE_NguoiDung service_NguoiDung)
	{
		super();
		this.service_NguoiDung=service_NguoiDung;
	}
	
	@GetMapping("/view/nguoidung")
	public List<NguoiDung> get() {
		return service_NguoiDung.getAll();
	}

	@GetMapping("/view/nguoidung/{id}")
	public Optional<NguoiDung> getid(@PathVariable Long id) {
		return service_NguoiDung.getByID(id);
	}

	@PostMapping("/create/nguoidung")
	public NguoiDung create() {
		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setTenDangNhap(123);
		nguoiDung.setMatKhau("123");
		nguoiDung.setQuyen("ADMIN");
		// khi có giao diện thì lấy dữ liệu qua đây
		return service_NguoiDung.setData(nguoiDung);

	}

	@PutMapping("/update/nguoidung/{id}")
	public Optional<Object> updateCauHoi(@PathVariable Long id) {
		NguoiDung nguoiDung = new NguoiDung();
		nguoiDung.setTenDangNhap(id);
		nguoiDung.setMatKhau("123");
		nguoiDung.setQuyen("ADMIN");
		return service_NguoiDung.update(nguoiDung);

	}

	@DeleteMapping("/delete/cauhoi/{id}")
	public Optional<Object> deleteCauHoi(@PathVariable long id) {

		return service_NguoiDung.delete(id);
	}

}
