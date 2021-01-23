package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="mo_dang_ky")
public class MoDangKy {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_mo_dang_ky")
    private Long idMoDangKy;

    @Column(name = "thoi_gian_mo")
    private Date thoiGianMo;

    @Column(name = "thoi_gian_dong")
    private Date thoiGianDong;

	public Long getIdMoDangKy() {
		return idMoDangKy;
	}

	public void setIdMoDangKy(Long idMoDangKy) {
		this.idMoDangKy = idMoDangKy;
	}

	public Date getThoiGianMo() {
		return thoiGianMo;
	}

	public void setThoiGianMo(Date thoiGianMo) {
		this.thoiGianMo = thoiGianMo;
	}

	public Date getThoiGianDong() {
		return thoiGianDong;
	}

	public void setThoiGianDong(Date thoiGianDong) {
		this.thoiGianDong = thoiGianDong;
	}
	
    
    
}
