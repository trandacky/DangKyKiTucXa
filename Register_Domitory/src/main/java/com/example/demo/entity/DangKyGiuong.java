package com.example.demo.entity;

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
	private Date ngayDangKy = new Date();
	
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



	public Date getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	public void setTinhTrangDangKy(Integer tinhTrangDangKy) {
		this.tinhTrangDangKy = tinhTrangDangKy;
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



	
	

}
