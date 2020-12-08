package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


/**
 * A DangKyGiuong.
 */
@Entity
@Table(name = "dang_ky_giuong")
public class DangKyGiuong{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDK;

    @Column(name = "hoc_ky")
    private Integer hocKy;

    @Column(name = "nam_hoc")
    private Integer namHoc;

    @ManyToOne
    @JoinColumn(name = "idKhu", nullable = false)
    private Khu idKhu;

    @ManyToOne
    @JoinColumn(name = "tenDangNhap", nullable = false)
    private NguoiDung tenDangNhap;

    @ManyToOne
    @JoinColumn(name = "idGiuong", nullable = false)
    private Giuong idGiuong;

    @ManyToOne
    @JoinColumn(name = "idPhong", nullable = false)
    private Phong idPhong;

	public Long getIdDK() {
		return idDK;
	}

	public void setIdDK(Long idDK) {
		this.idDK = idDK;
	}

	public Integer getHocKy() {
		return hocKy;
	}

	public void setHocKy(Integer hocKy) {
		this.hocKy = hocKy;
	}

	public Integer getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(Integer namHoc) {
		this.namHoc = namHoc;
	}

	public Khu getIdKhu() {
		return idKhu;
	}

	public void setIdKhu(Khu idKhu) {
		this.idKhu = idKhu;
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

	public Phong getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(Phong idPhong) {
		this.idPhong = idPhong;
	}

   

}
