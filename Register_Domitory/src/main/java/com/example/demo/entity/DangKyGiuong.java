package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;

import javax.persistence.*;

/**
 * A DangKyGiuong.
 */
@Entity
@Table(name = "dang_ky_giuong")
public class DangKyGiuong {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_dang_ky_giuong")
	private Long idDangKyGiuong;
	
	@Column(name = "ngay_dang_ky")
	private LocalDate ngayDangKy= LocalDate.now();
	
	@Column(name = "tinh_trang_dang_ky")
	private Integer tinhTrangDangKy = 0;


	@ManyToOne
	@JoinColumn(name = "tenDangNhap", nullable = false)
	private NguoiDung tenDangNhap;

	@ManyToOne
	@JoinColumn(name = "idGiuong", nullable = false)
	private Giuong idGiuong;



	public Long getIdDangKyGiuong() {
		return idDangKyGiuong;
	}

	public void setIdDangKyGiuong(Long idDangKyGiuong) {
		this.idDangKyGiuong = idDangKyGiuong;
	}

	public LocalDate getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(LocalDate ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	public NguoiDung getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(NguoiDung tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public Giuong getIdGiuong() {
		return idGiuong;
	}

	public void setIdGiuong(Giuong idGiuong) {
		this.idGiuong = idGiuong;
	}

	public int getTinhTrangDangKy() {
		return tinhTrangDangKy;
	}

	public void setTinhTrangDangKy(int tinhTrangDangKy) {
		this.tinhTrangDangKy = tinhTrangDangKy;
	}


	
	

}
