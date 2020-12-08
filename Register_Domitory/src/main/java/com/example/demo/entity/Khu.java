package com.example.demo.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private Integer soTang;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idKhu")
    private Set<Phong> phongs = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idKhu")
    private Set<DangKyGiuong> dangKyGiuongs = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idKhu")
    private Set<Giuong> giuongs = new HashSet<>();

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

	public Set<Phong> getPhongs() {
		return phongs;
	}

	public void setPhongs(Set<Phong> phongs) {
		this.phongs = phongs;
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

   
}
