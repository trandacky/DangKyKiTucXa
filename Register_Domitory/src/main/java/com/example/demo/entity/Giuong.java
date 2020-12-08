package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * A Giuong.
 */
@Entity
@Table(name = "giuong")
public class Giuong{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idgiuong;

    @Column(name = "vi_tri_giuong")
    private String viTriGiuong;

    @Column(name = "tinh_trang_dang_ky")
    private Integer tinhTrangDangKy;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idGiuong")
    private Set<DangKyGiuong> dangKyGiuongs = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idPhong", nullable = false)
    private Phong idPhong;

    @ManyToOne
    @JoinColumn(name = "idKhu", nullable = false)
    private Khu idKhu;

	public Long getIdgiuong() {
		return idgiuong;
	}

	public void setIdgiuong(Long idgiuong) {
		this.idgiuong = idgiuong;
	}

	public String getViTriGiuong() {
		return viTriGiuong;
	}

	public void setViTriGiuong(String viTriGiuong) {
		this.viTriGiuong = viTriGiuong;
	}

	public Integer getTinhTrangDangKy() {
		return tinhTrangDangKy;
	}

	public void setTinhTrangDangKy(Integer tinhTrangDangKy) {
		this.tinhTrangDangKy = tinhTrangDangKy;
	}

	public Set<DangKyGiuong> getDangKyGiuongs() {
		return dangKyGiuongs;
	}

	public void setDangKyGiuongs(Set<DangKyGiuong> dangKyGiuongs) {
		this.dangKyGiuongs = dangKyGiuongs;
	}

	public Phong getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(Phong idPhong) {
		this.idPhong = idPhong;
	}

	public Khu getIdKhu() {
		return idKhu;
	}

	public void setIdKhu(Khu idKhu) {
		this.idKhu = idKhu;
	}

	
}
