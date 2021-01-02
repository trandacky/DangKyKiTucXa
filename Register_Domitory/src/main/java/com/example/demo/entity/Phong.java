package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A Phong.
 */
@Entity
@Table(name = "phong")
public class Phong{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPhong;

    @Column(name = "phong_so")
    private Integer phongSo;

    @Column(name = "tang")
    private Integer tang=0;

    @Column(name = "so_giuong")
    private Integer soGiuong=0;

    @Column(name = "so_nguoi_dang_ky")
    private Integer soNguoiDangKy=0;

    @Column(name = "tinh_trang")
    private Integer tinhTrang=1;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idPhong")
    private List<DangKyGiuong> dangKyGiuongs = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idPhong")
    private List<Giuong> giuongs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idKhu", nullable = false)
    private Khu idKhu;

	

	public Integer getPhongSo() {
		return phongSo;
	}

	public void setPhongSo(Integer phongSo) {
		this.phongSo = phongSo;
	}

	public Integer getTang() {
		return tang;
	}

	public void setTang(Integer tang) {
		this.tang = tang;
	}

	public Integer getSoGiuong() {
		return soGiuong;
	}

	public void setSoGiuong(Integer soGiuong) {
		this.soGiuong = soGiuong;
	}

	public Integer getSoNguoiDangKy() {
		return soNguoiDangKy;
	}

	public void setSoNguoiDangKy(Integer soNguoiDangKy) {
		this.soNguoiDangKy = soNguoiDangKy;
	}

	public Integer getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Integer tinhTrang) {
		this.tinhTrang = tinhTrang;
	}



	public Long getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(Long idPhong) {
		this.idPhong = idPhong;
	}

	public List<DangKyGiuong> getDangKyGiuongs() {
		return dangKyGiuongs;
	}

	public void setDangKyGiuongs(List<DangKyGiuong> dangKyGiuongs) {
		this.dangKyGiuongs = dangKyGiuongs;
	}

	public List<Giuong> getGiuongs() {
		return giuongs;
	}

	public void setGiuongs(List<Giuong> giuongs) {
		this.giuongs = giuongs;
	}

	public Khu getIdKhu() {
		return idKhu;
	}

	public void setIdKhu(Khu idKhu) {
		this.idKhu = idKhu;
	}

    
}
