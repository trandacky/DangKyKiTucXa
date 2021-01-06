package com.example.demo.entity;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A Giuong.
 */
@Entity
@Table(name = "giuong")
public class Giuong{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_giuong")
    private Long idGiuong;

    @Column(name = "vi_tri_giuong")
    private String viTriGiuong;

    @Column(name = "tinh_trang_giuong")
    private boolean tinhTrangGiuong;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idGiuong")
    private List<DangKyGiuong> dangKyGiuongs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "idPhong", nullable = false)
    private Phong idPhong;

	public Long getIdGiuong() {
		return idGiuong;
	}

	public void setIdGiuong(Long idGiuong) {
		this.idGiuong = idGiuong;
	}

	public String getViTriGiuong() {
		return viTriGiuong;
	}

	public void setViTriGiuong(String viTriGiuong) {
		this.viTriGiuong = viTriGiuong;
	}

	public List<DangKyGiuong> getDangKyGiuongs() {
		return dangKyGiuongs;
	}

	public void setDangKyGiuongs(List<DangKyGiuong> dangKyGiuongs) {
		this.dangKyGiuongs = dangKyGiuongs;
	}

	public Phong getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(Phong idPhong) {
		this.idPhong = idPhong;
	}

	public boolean isTinhTrangGiuong() {
		return tinhTrangGiuong;
	}

	public void setTinhTrangGiuong(boolean tinhTrangGiuong) {
		this.tinhTrangGiuong = tinhTrangGiuong;
	}
	
}
