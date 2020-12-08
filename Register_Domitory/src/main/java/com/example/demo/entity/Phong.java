package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
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
    private Integer tang;

    @Column(name = "so_giuong")
    private Integer soGiuong;

    @Column(name = "so_nguoi_dang_ky")
    private Integer soNguoiDangKy;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idPhong")
    private Set<DangKyGiuong> dangKyGiuongs = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idPhong")
    private Set<Giuong> giuongs = new HashSet<>();

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

	public Set<DangKyGiuong> getDangKyGiuongs() {
		return dangKyGiuongs;
	}

	public void setDangKyGiuongs(Set<DangKyGiuong> dangKyGiuongs) {
		this.dangKyGiuongs = dangKyGiuongs;
	}

	public Set<Giuong> getGiuongs() {
		return giuongs;
	}

	public void setGiuongs(Set<Giuong> giuongs) {
		this.giuongs = giuongs;
	}

	public Khu getIdKhu() {
		return idKhu;
	}

	public void setIdKhu(Khu idKhu) {
		this.idKhu = idKhu;
	}

    
}
