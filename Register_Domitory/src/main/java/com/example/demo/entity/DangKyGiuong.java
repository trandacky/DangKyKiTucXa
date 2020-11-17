package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="DangKyGiuong")
public class DangKyGiuong {
	@Id
	@Column(name = "idDk")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDk;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tenDangNhap", nullable = false)
	private NguoiDung nguoiDung;

	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="idKhu", nullable = false) private Khu khu;
	 */
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="idPhong", nullable = false) private Phong phong;
	 */
	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="idGiuong", nullable = false) private Giuong giuong;
	 */

	@Column(name = "hocKy")
	private String hocKy;

	@Column(name = "namHoc")
	private int namHoc;

	public long getIdDk() {
		return idDk;
	}

	public void setIdDk(long idDk) {
		this.idDk = idDk;
	}

	public NguoiDung getNguoiDung() {
		return nguoiDung;
	}

	public void setNguoiDung(NguoiDung nguoiDung) {
		this.nguoiDung = nguoiDung;
	}

	public String getHocKy() {
		return hocKy;
	}

	public void setHocKy(String hocKy) {
		this.hocKy = hocKy;
	}

	public int getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(int namHoc) {
		this.namHoc = namHoc;
	}
	
	
}
