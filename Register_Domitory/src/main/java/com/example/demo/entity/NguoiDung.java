package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NguoiDung")
public class NguoiDung {
	@Id
	@Column(name = "tenDangNhap")
	private long tenDangNhap;

	@Column(name = "matKhau")
	private String matKhau;

	@Column(name = "tinhTrang")
	private boolean tinhtrang;

	@Column(name = "quyen")
	private String quyen;
	
	@Column(name = "hoTen")
	private String hoTen;

	@Column(name = "ngayThangNamSinh")
	private Date ngayThangNamSinh;
	
	@Column(name = "queQuan")
	private String queQuan;
	
	@Column(name = "soDienThoai")
	private String soDienThoai;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gioiTinh")
	private boolean gioiTinh;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "nguoiDung")
	private List<DangKyGiuong> dangKyGiuong;
	// map qua biến nguoiDung bên DangKyGiuong
	
	public long getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(long tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public String isQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

	

	/*
	 * one to many không nên để hàm get để tránh khi get ra mình gặp đệ quy
	 * public List<DangKyGiuong> getDangKyGiuong() { return dangKyGiuong; }
	 */

	public void setDangKyGiuong(List<DangKyGiuong> dangKyGiuong) {
		this.dangKyGiuong = dangKyGiuong;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgayThangNamSinh() {
		return ngayThangNamSinh;
	}

	public void setNgayThangNamSinh(Date ngayThangNamSinh) {
		this.ngayThangNamSinh = ngayThangNamSinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getQuyen() {
		return quyen;
	}

	

}
