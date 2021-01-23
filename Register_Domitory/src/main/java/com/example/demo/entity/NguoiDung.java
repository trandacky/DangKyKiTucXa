package com.example.demo.entity;


import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A NguoiDung.
 */
@Entity
@Table(name = "nguoi_dung")
public class NguoiDung{
    @Id
    @Column(length = 100, name="ten_dang_nhap")
    private String tenDangNhap;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "quyen")
    private Integer quyen;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "ngay_thang_nam_sinh")
    private LocalDate ngayThangNamSinh;

    @Column(name = "que_quan")
    private String queQuan;

    @Column(name = "so_dien_thoai_lien_he")
    private String soDienThoaiLienHe;

    @Column(name = "email")
    private String email;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "tenDangNhap")
    private List<DangKyGiuong> dangKyGiuongs = new ArrayList<>();

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Integer getQuyen() {
		return quyen;
	}

	public void setQuyen(Integer quyen) {
		this.quyen = quyen;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public LocalDate getNgayThangNamSinh() {
		return ngayThangNamSinh;
	}

	public void setNgayThangNamSinh(LocalDate ngayThangNamSinh) {
		this.ngayThangNamSinh = ngayThangNamSinh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getSoDienThoaiLienHe() {
		return soDienThoaiLienHe;
	}

	public void setSoDienThoaiLienHe(String soDienThoaiLienHe) {
		this.soDienThoaiLienHe = soDienThoaiLienHe;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public List<DangKyGiuong> getDangKyGiuongs() {
		return dangKyGiuongs;
	}

	public void setDangKyGiuongs(List<DangKyGiuong> dangKyGiuongs) {
		this.dangKyGiuongs = dangKyGiuongs;
	}

    
}
