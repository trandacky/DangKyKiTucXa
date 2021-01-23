package com.example.demo.entity;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A Khu.
 */
@Entity
@Table(name = "khu")
public class Khu{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKhu;

    @Column(name = "ten_khu")
    private String tenKhu;

    @Column(name = "so_tang")
    private Integer soTang=5;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh=false;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idKhu")
    private List<Phong> phongs = new ArrayList<>();


	public Long getIdKhu() {
		return idKhu;
	}

	public void setIdKhu(Long idKhu) {
		this.idKhu = idKhu;
	}

	public String getTenKhu() {
		return tenKhu;
	}

	public void setTenKhu(String tenKhu) {
		this.tenKhu = tenKhu;
	}

	public Integer getSoTang() {
		return soTang;
	}

	public void setSoTang(Integer soTang) {
		this.soTang = soTang;
	}

	public Boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public List<Phong> getPhongs() {
		return phongs;
	}

	public void setPhongs(List<Phong> phongs) {
		this.phongs = phongs;
	}



   
}
